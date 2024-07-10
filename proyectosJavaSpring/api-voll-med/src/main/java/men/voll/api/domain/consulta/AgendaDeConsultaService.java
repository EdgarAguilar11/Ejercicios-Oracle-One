package men.voll.api.domain.consulta;

import men.voll.api.domain.consulta.validaciones.ValidadorCancelamientoDeConsulta;
import men.voll.api.domain.consulta.validaciones.ValidadorDeConsultas;
import men.voll.api.domain.medico.Medico;
import men.voll.api.domain.medico.MedicoRepository;
import men.voll.api.domain.paciente.Paciente;
import men.voll.api.domain.paciente.PacienteRepository;
import men.voll.api.infra.errores.ValicacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaDeConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private List<ValidadorDeConsultas> validadores;

    @Autowired
    private List<ValidadorCancelamientoDeConsulta> validadoresCancelamiento;


    public DatosDetalleConsulta agendar(DatosAgendarConsulta datos){
        if (!pacienteRepository.findById(datos.idPaciente()).isPresent()){
            throw new ValicacionDeIntegridad("Este id para el paciente no fue encontrado");
        }

        if (datos.idMedico() != null && !medicoRepository.existsById(datos.idMedico())){
            throw new ValicacionDeIntegridad("Este id para el medico no fue encontrado");
        }

        //validaciones
        validadores.forEach(v -> v.valida(datos));

//        var paciente = pacienteRepository.findById(datos.idPaciente()).get();
//        var medico = medicoRepository.findById(datos.idMedico()).get();
        var paciente = pacienteRepository.findById(datos.idPaciente()).get();
        var medico = seleccionarMedico(datos);

        if (medico == null){
            throw new ValicacionDeIntegridad("No existen medicos disponibles para este horario y especialidad");
        }

        var consulta = new Consulta(medico, paciente, datos.fecha());
        consultaRepository.save(consulta);

        return new DatosDetalleConsulta(consulta);
    }

    public void cancelar(DatosCancelamientoConsulta datos) {
        if (!consultaRepository.existsById(datos.idConsulta())) {
            throw new ValicacionDeIntegridad("Id de la consulta informado no existe!");
        }

        validadoresCancelamiento.forEach(v -> v.validar(datos));

        var consulta = consultaRepository.getReferenceById(datos.idConsulta());
        consulta.cancelar(datos.motivo());
    }

    private Medico seleccionarMedico(DatosAgendarConsulta datos) {
        if (datos.idMedico()!=null){
            return medicoRepository.getReferenceById(datos.idMedico());
        }
        if(datos.especialidad()==null){
            throw new ValicacionDeIntegridad("Debe seleccionarse una especialidad para el medico");
        }
        return medicoRepository.seleccionarMedicoConEspecialiadEnFecha(datos.especialidad(), datos.fecha());
    }
}
