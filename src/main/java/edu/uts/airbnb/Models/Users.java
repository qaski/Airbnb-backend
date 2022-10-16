package edu.uts.airbnb.Models;

import javax.persistence.*;

@Entity
@Table  (name = "users")
public class Users {

    @Id
    @PrimaryKeyJoinColumn
    private Long id;
    @Column (name = "Nombre")
    private String nombre;
    @Column (name = "cargo")
    private String cargo;

    public Users() {
    }

    public Users(Long id, String nombre, String cargo) {
        this.id = id;
        this.nombre = nombre;
        this.cargo = cargo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", cargo='" + cargo + '\'' +
                '}';
    }
}
