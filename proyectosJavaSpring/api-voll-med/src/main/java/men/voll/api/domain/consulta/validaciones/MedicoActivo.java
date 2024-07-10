package men.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import men.voll.api.domain.consulta.DatosAgendarConsulta;
import men.voll.api.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MedicoActivo implements ValidadorDeConsultas{

    @Autowired
    private MedicoRepository medicoRepository;

    public void valida(DatosAgendarConsulta datos){
        if (datos.idMedico() == null){
            return;
        }

        var medicoActivo = medicoRepository.findActivoById(datos.idMedico());
        if (!medicoActivo){
            throw new ValidationException("No se puede permitir agendar citas con medicos inactivos en el sistema");
        }
    }
}
