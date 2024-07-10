package men.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import men.voll.api.domain.consulta.ConsultaRepository;
import men.voll.api.domain.consulta.DatosAgendarConsulta;
import men.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PacienteSinConsulta implements ValidadorDeConsultas{

    @Autowired
    private ConsultaRepository consultaRepository;

    public void valida(DatosAgendarConsulta datos){
        var primerHorario = datos.fecha().withHour(7);
        var ultimoHorario = datos.fecha().withHour(18);

        var pacienteConsulta = consultaRepository.existsByPacienteIdAndFechaBetween(datos.idPaciente(),primerHorario,ultimoHorario);

        if (pacienteConsulta){
            throw new ValidationException("El paciente ya tiene una consulta para ese día");
        }
    }
}
