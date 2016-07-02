package clinica.domain.facade;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import clinica.domain.Medico;
import clinica.domain.service.MedicoService;

@Path("/medico")
@Produces({ "application/json" })
public class MedicoFacade {
	
	@Inject
	private MedicoService service;

	@GET
	@Path("/")
	public List<Medico> listarTodos() {
		return service.listarTodos();
	}

	@POST
	@Path("/")
	public void salvar(Medico medico) {
		service.salvar(medico);
	}

	@DELETE
	@Path("/{codigo}")
	public void remover(@PathParam("codigo") Integer codigo) {
		service.remover(codigo);
	}

}
