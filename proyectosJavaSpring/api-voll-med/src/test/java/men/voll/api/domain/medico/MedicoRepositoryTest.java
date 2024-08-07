package men.voll.api.domain.medico;

import men.voll.api.domain.consulta.Consulta;
import men.voll.api.domain.direccion.DatosDireccion;
import men.voll.api.domain.paciente.DatosRegistroPaciente;
import men.voll.api.domain.paciente.Paciente;
import org.assertj.core.api.AssertionsForClassTypes;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.Assert;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
//las siguientes lineas se quitan si se usa una base de datos en memoria, por ejemplo H2
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) //configuracion base de datos de prueba
@ActiveProfiles("test")
class MedicoRepositoryTest {

    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private TestEntityManager em;

    @Test
    @DisplayName("Deberia retornar nulo cuando el medico se encuentre en consulta con otro paciente en ese horario")
    void seleccionarMedicoConEspecialiadEnFechaEscenarioUno() {
        var proximoLunes10H = LocalDate.now()
                .with(TemporalAdjusters.next(DayOfWeek.MONDAY))
                .atTime(10,0);

        var medico = registrarMedico("Jose","j@mail.com","123456",Especialidad.CARDIOLOGIA);;
        var paciente = registrarPaciente("antonio","a@mail.com","654321");
        registrarConsulta(medico,paciente,proximoLunes10H);

        var medicoLibre = medicoRepository.seleccionarMedicoConEspecialiadEnFecha(Especialidad.CARDIOLOGIA, proximoLunes10H);

        AssertionsForClassTypes.assertThat(medicoLibre).isNull();
    }

    @Test
    @DisplayName("deberia retornar un medico cuando realice la consulta en la base de datos  en ese horario")
    void seleccionarMedicoConEspecialidadEnFechaEscenarioDos() {

        //given
        var proximoLunes10H = LocalDate.now()
                .with(TemporalAdjusters.next(DayOfWeek.MONDAY))
                .atTime(10,0);

        var medico=registrarMedico("Jose","j@mail.com","123456",Especialidad.CARDIOLOGIA);

        //when
        var medicoLibre = medicoRepository.seleccionarMedicoConEspecialiadEnFecha(Especialidad.CARDIOLOGIA,proximoLunes10H);

        //then
        AssertionsForClassTypes.assertThat(medicoLibre).isEqualTo(medico);
    }

    private void registrarConsulta(Medico medico, Paciente paciente, LocalDateTime fecha) {
        em.persist(new Consulta(null, medico, paciente, fecha, null));
    }

    private Medico registrarMedico(String nombre, String email, String documento, Especialidad especialidad) {
        var medico = new Medico(datosMedico(nombre, email, documento, especialidad));
        em.persist(medico);
        return medico;
    }

    private Paciente registrarPaciente(String nombre, String email, String documento) {
        var paciente = new Paciente(datosPaciente(nombre, email, documento));
        em.persist(paciente);
        return paciente;
    }

    private DatosRegistroMedico datosMedico(String nombre, String email, String documento, Especialidad especialidad) {
        return new DatosRegistroMedico(
                nombre,
                email,
                "61999999999",
                documento,
                especialidad,
                datosDireccion()
        );
    }

    private DatosRegistroPaciente datosPaciente(String nombre, String email, String documento) {
        return new DatosRegistroPaciente(
                nombre,
                email,
                "61999999999",
                documento,
                datosDireccion()
        );
    }

    private DatosDireccion datosDireccion() {
        return new DatosDireccion(
                " loca",
                "azul",
                "acapulpo",
                "321",
                "12"
        );
    }
}