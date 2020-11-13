package cl.idesoft.ejemplo.controller;

import cl.idesoft.ejemplo.dto.Persona;
import cl.idesoft.ejemplo.service.IPersonaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = {PersonaController.class})
public class PersonaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IPersonaService personaService;

    @Test
    public void crearPersona() throws Exception {

        Persona persona = new Persona();
        persona.setId(1);
        persona.setNombre("Germán");
        persona.setApellido("Muñoz");
        persona.setEdad(30);

        doNothing().when(personaService).insertarPersona(any());

        mockMvc.perform(MockMvcRequestBuilders
                .post("/api/v1/persona")
                .content(asJsonString(persona))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void obtenerPersona() throws Exception {

        Persona persona = new Persona();
        persona.setId(1);
        persona.setNombre("Germán");
        persona.setApellido("Muñoz");
        persona.setEdad(30);

        when(personaService.obtenerPersona(anyInt())).thenReturn(persona);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/persona/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.nombre").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.apellido").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.edad").exists());

    }

    @Test
    public void actualizarPersona() throws Exception {
        Persona persona = new Persona();
        persona.setId(1);
        persona.setNombre("Juan");
        persona.setApellido("Perez");
        persona.setEdad(30);

        doNothing().when(personaService).insertarPersona(any());

        mockMvc.perform(MockMvcRequestBuilders
                .put("/api/v1/persona")
                .content(asJsonString(persona))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void eliminarPersona() throws Exception {

        doNothing().when(personaService).eliminarPersona(anyInt());

        mockMvc.perform(MockMvcRequestBuilders
                .delete("/api/v1/persona/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}