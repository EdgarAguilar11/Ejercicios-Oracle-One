package men.voll.api.domain.consulta;

import men.voll.api.domain.medico.Medico;
import men.voll.api.domain.medico.MedicoRepository;
import men.voll.api.domain.paciente.Paciente;
import men.voll.api.domain.paciente.PacienteRepository;
import men.voll.api.infra.errores.ValicacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendaDeConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;


    public void agendar(DatosAgendarConsulta datos){
        if (pacienteRepository.findById(datos.idPaciente()).isPresent()){
            throw new ValicacionDeIntegridad("Este id para el paciente no fue encontrado");
        }

        if (datos.idMedico() != null && medicoRepository.existsById(datos.idMedico())){
            throw new ValicacionDeIntegridad("Este id para el medico no fue encontrado");
        }

//        var paciente = pacienteRepository.findById(datos.idPaciente()).get();
//        var medico = medicoRepository.findById(datos.idMedico()).get();
        var paciente = pacienteRepository.findById(datos.idPaciente()).get();
        var medico = seleccionarMedico(datos);
        var consulta = new Consulta(null, medico, paciente, datos.fecha());
        consultaRepository.save(consulta);
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
