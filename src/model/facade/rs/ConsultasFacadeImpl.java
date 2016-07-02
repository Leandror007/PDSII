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

import model.dao.ConsultasDao;
import model.domain.Consultas;
import model.facade.ConsultasFacade;

@Path("/paciente")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class ConsultasFacadeImpl implements ConsultasFacade {

	@Inject
	private ConsultasDao pacienteDao;
	
	/* (non-Javadoc)
	 * @see model.facade.rs.ConsultasFacade#getConsultass()
	 */
	@Override
	@GET
	public List<Consultas> getConsultass() {
		return pacienteDao.getConsultass(new Consultas());
	}

	/* (non-Javadoc)
	 * @see model.facade.rs.ConsultasFacade#getConsultass(java.lang.Integer)
	 */
	@Override
	@GET
	@Path("/{codigo}")
	public List<Consultas> getConsultass(@PathParam("codigo") Integer codigo) {
		Consultas paciente = new Consultas();
		paciente.setCodigo(codigo);
		return pacienteDao.getConsultass(paciente);
	}
	
	/* (non-Javadoc)
	 * @see model.facade.rs.ConsultasFacade#salvar(model.domain.Consultas)
	 */
	@Override
	@POST 
	public Consultas salvar(Consultas paciente) { 
		paciente = pacienteDao.salvar(paciente);
	 	return paciente;
	}
	
	/* (non-Javadoc)
	 * @see model.facade.rs.ConsultasFacade#atualizar(model.domain.Consultas)
	 */
	@Override
	@PUT 
	public void atualizar(Consultas paciente) { 
		pacienteDao.atualizar(paciente);
	}

	/* (non-Javadoc)
	 * @see model.facade.rs.ConsultasFacade#deletarConsultas(java.lang.Integer)
	 */
	@Override
	@DELETE
	@Path("/{codigo}")
	public void deletarConsultas(@PathParam("codigo") Integer codigo) {
		Consultas paciente = new Consultas();
		paciente.setCodigo(codigo);
		pacienteDao.excluir(paciente);
	}

}
