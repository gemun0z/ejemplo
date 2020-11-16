package cl.idesoft.ejemplo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Relation(collectionRelation = "persona")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonaModel extends RepresentationModel<PersonaModel> {

    @JsonProperty(value = "id")
    private int id;

    @JsonProperty(value = "nombre")
    private String nombre;

    @JsonProperty(value = "apellido_paterno")
    private String apellidoPaterno;

    @JsonProperty(value = "apellido_materno")
    private String apellidoMaterno;

    @JsonProperty(value = "edad")
    private int edad;

}
