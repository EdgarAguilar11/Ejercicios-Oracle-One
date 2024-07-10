package men.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import men.voll.api.domain.consulta.ConsultaRepository;
import men.voll.api.domain.consulta.DatosAgendarConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MedicoConConsulta implements ValidadorDeConsultas{

    @Autowired
    private ConsultaRepository consultaRepository;

    public void valida(DatosAgendarConsulta datos){
        if (datos.idMedico() == null){
            return;
        }
        var medicoConConsulta = consultaRepository.existsByMedicoIdAndFecha(datos.idMedico(), datos.fecha());

        if (medicoConConsulta){
            throw new ValidationException("Este médico ya tiene una consulta en ese horario");
        }
    }
}
