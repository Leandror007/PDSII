package clinica.domain.facade;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import clinica.domain.Consultas;
import clinica.domain.service.ConsultasService;

@Path("/consultas")
@Produces({ "application/json" })
public class ConsultasFacade {
	
	@Inject
	private ConsultasService service;

	@GET
	@Path("/")
	public List<Consultas> listarTodos() {
		return service.listarTodos();
	}

	@POST
	@Path("/")
	public void salvar(Consultas consultas) {
		service.salvar(consultas);
	}

	@DELETE
	@Path("/{codigo}")
	public void remover(@PathParam("codigo") Integer codigo) {
		service.remover(codigo);
	}

}
