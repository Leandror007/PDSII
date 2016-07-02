package clinica.domain.facade;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import clinica.domain.Paciente;
import clinica.domain.service.PacienteService;

@Path("/paciente")
@Produces({ "application/json" })
public class PacienteFacade {
	
	@Inject
	private PacienteService service;

	@GET
	@Path("/")
	public List<Paciente> listarTodos() {
		return service.listarTodos();
	}

	@POST
	@Path("/")
	public void salvar(Paciente paciente) {
		service.salvar(paciente);
	}

	@DELETE
	@Path("/{codigo}")
	public void remover(@PathParam("codigo") Integer codigo) {
		service.remover(codigo);
	}

}
