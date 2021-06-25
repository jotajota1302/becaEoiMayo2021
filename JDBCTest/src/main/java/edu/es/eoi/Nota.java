package edu.es.eoi;

public class Nota {

	private int id;
	private double calificacion;
	private String materia;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public Nota(double calificacion, String materia) {
		super();
		this.calificacion = calificacion;
		this.materia = materia;
	}

}
