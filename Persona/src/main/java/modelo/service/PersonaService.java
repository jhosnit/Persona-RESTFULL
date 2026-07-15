package modelo.service;

import java.util.List;

import modelo.dao.PersonaDAO;
import modelo.entities.Persona;

public class PersonaService {

	private PersonaDAO personaDAO;
	
	public PersonaService(){
		this.personaDAO = new PersonaDAO();
	}

	public Persona buscarPorCedula(String cedula) {
		return personaDAO.getByCedula(cedula);
	}

	public void agregarCiudadano(Persona p) {
		personaDAO.create(p);
	}

	public void actualizarRegistro(Persona p) {
		personaDAO.update(p);
	}

	public void darDeBaja(int id) {
		personaDAO.delete(id);
	}

	public boolean aplicaCredito(String cedula) {
		Persona persona = personaDAO.getByCedula(cedula);
		if (persona.getEdad() >= 18) {
			return true;
		}
		return false;
	}
	
	public List<Persona> listar(){
		return personaDAO.getAll();
	}
}