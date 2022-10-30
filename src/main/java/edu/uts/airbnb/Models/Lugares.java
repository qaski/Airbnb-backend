package com.init.lugares.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="lugares")
public class Lugares {
      
	  @Id
	  @Column(name="id")
	  private Long id;
	
	@Column(name="lugar")
	  private String lugar;
	  
	  @Column(name="nombre",nullable=false,length=100)
	  private String nombre;
	  
	  @Column(name="precio")
	  private int precio;
	  
	  @Column(name="puntuacion")
	  private double puntuacion;
	  
	  @Column(name="imagen")
	  private String imagen;
	  
	  
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	} 
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public double getPuntuacion() {
		return puntuacion;
	}
	public void setPuntuacion(double puntuacion) {
		this.puntuacion = puntuacion;
	}
	
	
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
 