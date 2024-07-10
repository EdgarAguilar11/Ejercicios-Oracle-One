package men.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import men.voll.api.domain.consulta.DatosAgendarConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class HorarioDeAnticipacion implements ValidadorDeConsultas{
    public void valida(DatosAgendarConsulta datos){
        var ahora = LocalDateTime.now();
        var horaDeConsulta = datos.fecha();

        var diferenciaDeTreintaMinutos = Duration.between(ahora, horaDeConsulta).toMinutes() < 30;

        if (diferenciaDeTreintaMinutos){
            throw new ValidationException("Las consultas deben programarse con al menos 30 minutos de anticipación");
        }
    }
}
