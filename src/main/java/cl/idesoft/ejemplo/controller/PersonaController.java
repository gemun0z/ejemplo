package cl.idesoft.ejemplo.controller;

import cl.idesoft.ejemplo.dto.Persona;
import cl.idesoft.ejemplo.service.IPersonaService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Metodos de Persona")
@RestController
@RequestMapping(value = "/api/v1")
public class PersonaController {

    @Autowired
    private IPersonaService personaService;

    @PostMapping(path = "/persona", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> crearPersona(@RequestBody Persona persona) {
        personaService.insertarPersona(persona);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(path = "/persona/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Persona> obtenerPersona(@PathVariable(value = "id") Integer id) {
        Persona persona = personaService.obtenerPersona(id);
        return ResponseEntity.ok(persona);
    }

    @PutMapping(path = "/persona", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> actualizarPersona(@RequestBody Persona persona) {
        personaService.actualizarPersona(persona);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "/persona/{id}")
    public ResponseEntity<Void> eliminarPersona(@PathVariable(value = "id") Integer id) {
        personaService.eliminarPersona(id);
        return ResponseEntity.noContent().build();
    }

}
