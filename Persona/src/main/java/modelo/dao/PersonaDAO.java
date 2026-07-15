package modelo.dao;

import java.util.ArrayList;
import java.util.List;
import modelo.entities.Persona;

public class PersonaDAO {
	private static List<Persona> personas = new ArrayList<Persona>();

	public void create(Persona p) {
		personas.add(p);
	}

	public void update(Persona p) {
		for (int i = 0; i < personas.size(); i++) {
			if (personas.get(i).getCedula().equals(p.getCedula())) {
				personas.get(i).setCedula(p.getCedula());
				personas.get(i).setNombre(p.getNombre());
				personas.get(i).setEdad(p.getEdad());
			}
		}
	}

	public void delete(int id) {
		for (int i = 0; i < personas.size(); i++) {
			if (personas.get(i).getId() == id) {
				personas.remove(i);
				break;
			}
		}

	}

	public Persona getByCedula(String c) {
		for (Persona p : personas) {
			if (p.getCedula().equals(c)) {
				return p;
			}
		}
		return null;
	}

	public List<Persona> getAll() {
		if (personas.isEmpty()) {
			personas.add(new Persona(01, "Jhostin", "1727964197", 21));
			personas.add(new Persona(02, "Aless", "1827964197", 21));
			personas.add(new Persona(03, "Elio", "1927964197", 21));
		}
		return personas;
	}

}