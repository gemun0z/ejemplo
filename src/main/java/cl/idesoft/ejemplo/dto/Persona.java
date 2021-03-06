package cl.idesoft.ejemplo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Persona {

    private int id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private int edad;

}
