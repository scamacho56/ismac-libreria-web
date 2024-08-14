package com.distribuida.entities;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Component
@Entity
@Table(name = "factura_detalle")
public class Factura_detalle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_factura_detalle")
	private int idFacturadetalle;
	@Column(name = "cantidad")
	private int cantidad;
	@Column(name = "subtotal")
	private double subtotal;
	//@Column(name = "id_factura")
	//private int idFactura;
	//@Column(name = "id_libro")
	//private int idLibro;
	
	public Factura_detalle() {}

	  //@OneToOne
		//@ManyToOne
		//@OneToOne
		
	@JoinColumn(name="id_factura")
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private Factura factura;

	@JoinColumn(name="id_libro")
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private Libro libro;
	
	
	public Factura_detalle(int idFacturadetalle, int cantidad, double subtotal) {
		
		this.idFacturadetalle = idFacturadetalle;
		this.cantidad = cantidad;
		this.subtotal = subtotal;
		//this.idFactura = idFactura;
		//this.idLibro = idLibro;
	}

	public int getIdFacturadetalle() {
		return idFacturadetalle;
	}

	public void setIdFacturadetalle(int idFacturadetalle) {
		this.idFacturadetalle = idFacturadetalle;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	@Override
	public String toString() {
		return "Factura_detalle [idFacturadetalle=" + idFacturadetalle + ", cantidad=" + cantidad + ", subtotal="
				+ subtotal + ", factura=" + factura + ", libro=" + libro + "]";
	}


	
}
