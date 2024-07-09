package men.voll.api.controller;

import jakarta.validation.Valid;
import men.voll.api.domain.consulta.AgendaDeConsultaService;
import men.voll.api.domain.consulta.DatosAgendarConsulta;
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
public class ConsultaController {

    @Autowired
    private AgendaDeConsultaService service;

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DatosAgendarConsulta datosAgendarConsulta){
        service.agendar(datosAgendarConsulta);
        return ResponseEntity.ok(new DatosDetalleConsulta(null,null,null,null));
    }
}
