package men.voll.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import men.voll.api.domain.consulta.AgendaDeConsultaService;
import men.voll.api.domain.consulta.DatosAgendarConsulta;
import men.voll.api.domain.consulta.DatosCancelamientoConsulta;
import men.voll.api.domain.consulta.DatosDetalleConsulta;
import men.voll.api.domain.medico.MedicoRepository;
import men.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("/consultas")
@SecurityRequirement(name = "bearer-key")
public class ConsultaController {

    @Autowired
    private AgendaDeConsultaService service;

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DatosAgendarConsulta datosAgendarConsulta){
        var response = service.agendar(datosAgendarConsulta);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping
    @Transactional
    @Operation(
            summary = "cancela una consulta de la agenda",
            description = "requiere motivo",
            tags = { "consulta", "delete" })
    public ResponseEntity cancelar(@RequestBody @Valid DatosCancelamientoConsulta dados) {
        service.cancelar(dados);
        return ResponseEntity.noContent().build();
    }
}
