package co.com.todosistemas.rest.activity.rest;


import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import co.com.todosistemas.negocio.activity.Activity;
import co.com.todosistemas.negocio.activity.PojoActivity;



/**
 * 
 * desde el front siempre se valida que la respuesta sea de status 200
 *
 * @version 1.0.0
 * @author Maria Fernanda Ochoa
 *
 */




@Named
@Path("/gestionActivity")
public class GestionActivity {

	@Inject
	private Activity act;
	
	@GET
	@Produces({ "application/json" })
	public Response doGet() {
		try {
		return Response.ok().entity(act.getActivities()).build();
		} catch (Exception e) {
			return Response.ok().entity(e.getMessage()).build();
		}
	}
	@GET
	@Produces({ "application/json" })
	@Path("/states")
	public Response doGet() {
		try {
		return Response.ok().entity(act.getStates()).build();
		} catch (Exception e) {
			return Response.ok().entity(e.getMessage()).build();
		}
	}
	@GET
	@Produces({ "application/json" })
	@Path("/employees")
	public Response doGet() {
		try {
		return Response.ok().entity(act.getEmployees()).build();
		} catch (Exception e) {
			return Response.ok().entity(e.getMessage()).build();
		}
	}
	
	@POST
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	public Response doPost(PojoActivity activity) {
		try {
			act.newActivity( activity.getName(),activity.getState(),activity.getEstimatedDate(),activity.getEmployee());
		} catch (Exception e) {
			return Response.ok().entity(e.getMessage()).build();
		}
		return Response.ok().entity("Ha realizado la insercion correctamente de la actividad").build();
	}
	@DELETE
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	public Response doDelete(int id) {
		try {
			mec.deleteActivity( id);
		} catch (Exception e) {
			return Response.ok().entity(e.getMessage()).build();
		}
		return Response.ok().entity("Ha realizado la insercion correctamente de el mecanico").build();
	}
	@PUT
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	public Response doPost(PojoActivity activity) {
		try {
			mec.updateActivity( activity.getName(),activity.getState(),activity.getEstimatedDate(),activity.getEmployee());
		} catch (Exception e) {
			return Response.ok().entity(e.getMessage()).build();
		}
		return Response.ok().entity("Ha realizado la insercion correctamente de el mecanico").build();
	}
}