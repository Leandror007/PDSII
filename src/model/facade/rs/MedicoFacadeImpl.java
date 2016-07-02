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

import model.dao.MedicoDao;
import model.domain.Medico;
import model.facade.MedicoFacade;

@Path("/medico")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class MedicoFacadeImpl implements MedicoFacade {

	@Inject
	private MedicoDao medicoDao;
	
	/* (non-Javadoc)
	 * @see model.facade.rs.MedicoFacade#getMedicos()
	 */
	@Override
	@GET
	public List<Medico> getMedicos() {
		return medicoDao.getMedicos(new Medico());
	}

	/* (non-Javadoc)
	 * @see model.facade.rs.MedicoFacade#getMedicos(java.lang.Integer)
	 */
	@Override
	@GET
	@Path("/{codigo}")
	public List<Medico> getMedicos(@PathParam("codigo") Integer codigo) {
		Medico medico = new Medico();
		medico.setCodigo(codigo);
		return medicoDao.getMedicos(medico);
	}
	
	/* (non-Javadoc)
	 * @see model.facade.rs.MedicoFacade#salvar(model.domain.Medico)
	 */
	@Override
	@POST 
	public Medico salvar(Medico medico) { 
		medico = medicoDao.salvar(medico);
	 	return medico;
	}
	
	/* (non-Javadoc)
	 * @see model.facade.rs.MedicoFacade#atualizar(model.domain.Medico)
	 */
	@Override
	@PUT 
	public void atualizar(Medico medico) { 
		medicoDao.atualizar(medico);
	}

	/* (non-Javadoc)
	 * @see model.facade.rs.MedicoFacade#deletarMedico(java.lang.Integer)
	 */
	@Override
	@DELETE
	@Path("/{codigo}")
	public void deletarMedico(@PathParam("codigo") Integer codigo) {
		Medico medico = new Medico();
		medico.setCodigo(codigo);
		medicoDao.excluir(medico);
	}

}
