package model;

public class Usuarios {
	private int id;
	private String nombre, password, estado;
	
	public Usuarios(int codigo, String n, String p, String e) {
		id=codigo;
		nombre=n;
		password=p;
		estado=e;
	}// cierra constructor

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getPassword() {
		return password;
	}

	public String getEstado() {
		return estado;
	}
	
	
	
}// cierra clase
