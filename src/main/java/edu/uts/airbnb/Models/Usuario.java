package edu.uts.airbnb.Models;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (nullable = false)
    private String nombre;
    @Column (nullable = false)
    private String apellido;
    @Column(length = 12)
    private String telefono;
    @Column (nullable = false)
    private String Direccion;


}
