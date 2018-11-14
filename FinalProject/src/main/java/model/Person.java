package model;

public class Person {
	private String ID;
	private boolean discapacitado;

	public Person(String iD, boolean discapacitado) {
		ID = iD;
		this.discapacitado = discapacitado;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public boolean isDiscapacitado() {
		return discapacitado;
	}

	public void setDiscapacitado(boolean discapaciteiro) {
		this.discapacitado = discapaciteiro;
	}

}
