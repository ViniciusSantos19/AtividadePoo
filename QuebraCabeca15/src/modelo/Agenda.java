package modelo;

import ConnectDb.DAOpostgres;

public class Agenda {
	private DAOpostgres connection;
	public Agenda() {
		this.connection = new DAOpostgres();
	}
	
	
}
