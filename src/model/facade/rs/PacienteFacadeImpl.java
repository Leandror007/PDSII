package model.facade.rs;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.dao.PacienteDao;
import model.domain.Paciente;
import model.facade.PacienteFacade;

@Path("/paciente")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class PacienteFacadeImpl implements PacienteFacade {

	@Inject
	private PacienteDao pacienteDao;
	
	/* (non-Javadoc)
	 * @see model.facade.rs.PacienteFacade#getPacientes()
	 */
	@Override
	@GET
	public List<Paciente> getPacientes() {
		return pacienteDao.getPacientes(new Paciente());
	}

	/* (non-Javadoc)
	 * @see model.facade.rs.PacienteFacade#getPacientes(java.lang.Integer)
	 */
	@Override
	@GET
	@Path("/{codigo}")
	public List<Paciente> getPacientes(@PathParam("codigo") Integer codigo) {
		Paciente paciente = new Paciente();
		paciente.setCodigo(codigo);
		return pacienteDao.getPacientes(paciente);
	}
	
	/* (non-Javadoc)
	 * @see model.facade.rs.PacienteFacade#salvar(model.domain.Paciente)
	 */
	@Override
	@POST 
	public Paciente salvar(Paciente paciente) { 
		paciente = pacienteDao.salvar(paciente);
	 	return paciente;
	}
	
	/* (non-Javadoc)
	 * @see model.facade.rs.PacienteFacade#atualizar(model.domain.Paciente)
	 */
	@Override
	@PUT 
	public void atualizar(Paciente paciente) { 
		pacienteDao.atualizar(paciente);
	}

	/* (non-Javadoc)
	 * @see model.facade.rs.PacienteFacade#deletarPaciente(java.lang.Integer)
	 */
	@Override
	@DELETE
	@Path("/{codigo}")
	public void deletarPaciente(@PathParam("codigo") Integer codigo) {
		Paciente paciente = new Paciente();
		paciente.setCodigo(codigo);
		pacienteDao.excluir(paciente);
	}

}
