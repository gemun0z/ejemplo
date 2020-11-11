package cl.idesoft.ejemplo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "Persona")
public class PersonaEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @Column(name = "nombre", length = 50)
    private String nombre;
    @Column(name = "apellido", length = 50)
    private String apellido;
    @Column(name = "edad")
    private Integer edad;

}
