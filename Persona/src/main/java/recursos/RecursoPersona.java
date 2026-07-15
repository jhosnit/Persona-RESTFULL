package recursos;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import modelo.entities.Persona;
import modelo.service.PersonaService;

@Path("/personas")
public class RecursoPersona {
	private PersonaService service = new PersonaService();

	@Path("/buscar/{cedula}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar(@PathParam("cedula") String cedula) {
		Persona persona = service.buscarPorCedula(cedula);
		if (persona == null) {
			return Response.status(Response.Status.NOT_FOUND).entity("No se encontro una persona con esa cedula").build();
		}
		return Response.ok(persona).build();
	}

	@Path("/add")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response add(Persona p) {
		service.agregarCiudadano(p);
		return Response.ok("Persona agregada con exito").build();
	}

	@Path("/update")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(Persona p) {
		service.actualizarRegistro(p);
		return Response.ok("Persona actualizada con exito").build();
	}

	@Path("/delete/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") int id) {
		service.darDeBaja(id);
		return Response.ok("Persona eliminada con exito").build();
	}

	@Path("/listar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response todos() {
		return Response.ok(service.listar()).build();
	}
}