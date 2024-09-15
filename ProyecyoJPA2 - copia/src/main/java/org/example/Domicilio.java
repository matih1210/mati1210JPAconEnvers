package org.example;

import lombok.*;
import org.hibernate.envers.Audited;


import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;


@Getter
@Entity
@Table(name = "domicilio")
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Audited

public class Domicilio implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_calle")
    private String nombreCalle;

    @Column(name = "numero")
    private int numero;

}
