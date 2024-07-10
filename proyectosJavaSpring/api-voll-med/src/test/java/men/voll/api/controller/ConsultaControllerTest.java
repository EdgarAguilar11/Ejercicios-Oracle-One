package men.voll.api.controller;

import men.voll.api.domain.consulta.AgendaDeConsultaService;
import men.voll.api.domain.consulta.DatosAgendarConsulta;
import men.voll.api.domain.consulta.DatosDetalleConsulta;
import men.voll.api.domain.medico.Especialidad;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
public class ConsultaControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<DatosAgendarConsulta> agendarConsultaJacksonTester;

    @Autowired
    private JacksonTester<DatosDetalleConsulta> detalleConsultaJacksonTester;

    @MockBean
    private AgendaDeConsultaService agendaDeConsultaService;

    @Test
    @DisplayName("deberia retornar estado http 400 cuando los datos ingresados sean invalidos")
    @WithMockUser
    void agendarEscenarioUno() throws Exception {
        //given //when
        var response = mvc.perform(MockMvcRequestBuilders.post("/consultas")).andReturn().getResponse();

        //then
        AssertionsForClassTypes.assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("deberia retornar estado http 200 cuando los datos ingresados son validos")
    @WithMockUser
    void agendarEscenarioDos() throws Exception {
        //given
        var fecha = LocalDateTime.now().plusHours(1);
        var especialidad = Especialidad.CARDIOLOGIA;
        var datos = new DatosDetalleConsulta(null,2l,5l,fecha);

        // when

        Mockito.when(agendaDeConsultaService.agendar(ArgumentMatchers.any())).thenReturn(datos);

        var response = mvc.perform(MockMvcRequestBuilders.post("/consultas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(agendarConsultaJacksonTester.write(new DatosAgendarConsulta(null,2l,5l,fecha, especialidad)).getJson())
        ).andReturn().getResponse();

        //then
        AssertionsForClassTypes.assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

        var jsonEsperado = detalleConsultaJacksonTester.write(datos).getJson();

        AssertionsForClassTypes.assertThat(response.getContentAsString()).isEqualTo(jsonEsperado);

    }
}
