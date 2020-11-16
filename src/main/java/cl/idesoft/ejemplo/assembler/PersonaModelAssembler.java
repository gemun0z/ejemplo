package cl.idesoft.ejemplo.assembler;

import cl.idesoft.ejemplo.controller.PersonaController;
import cl.idesoft.ejemplo.entity.PersonaEntity;
import cl.idesoft.ejemplo.model.PersonaModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class PersonaModelAssembler extends RepresentationModelAssemblerSupport<PersonaEntity, PersonaModel> {

    public PersonaModelAssembler() {
        super(PersonaController.class, PersonaModel.class);
    }

    @Override
    public PersonaModel toModel(PersonaEntity entity) {
        PersonaModel model = instantiateModel(entity);

        model.setId(entity.getId());
        model.setNombre(entity.getNombre());
        model.setApellidoPaterno(entity.getApellidoPaterno());
        model.setApellidoMaterno(entity.getApellidoMaterno());
        model.setEdad(entity.getEdad());

        model.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PersonaController.class).obtenerPersona(entity.getId())).withSelfRel());

        return model;
    }
}
