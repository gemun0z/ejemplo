package cl.idesoft.ejemplo.controller;

import cl.idesoft.ejemplo.dto.Persona;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Metodos de Persona")
@RestController
@RequestMapping(value = "/api/v1")
public class PersonaController {

    @PostMapping(path = "/persona", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> crearPersona(@RequestBody Persona persona) {
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/persona/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Persona> obtenerPersona(@PathVariable(value = "id") Integer id) {
        Persona persona = new Persona();
        persona.setId(id);
        persona.setNombre("Germán");
        persona.setApellido("Muñoz");
        persona.setEdad("30");
        return ResponseEntity.ok(persona);
    }

    @PutMapping(path = "/persona", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Persona> actualizarPersona(@RequestBody Persona persona) {
        return ResponseEntity.ok(persona);
    }

    @DeleteMapping(path = "/persona/{id}")
    public ResponseEntity<Void> eliminarPersona(@PathVariable(value = "id") Integer id) {
        System.out.println(id);
        return ResponseEntity.noContent().build();
    }

}
