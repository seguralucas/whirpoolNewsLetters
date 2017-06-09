package servicio;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;


@Path("/encendido")
public class Encendido {
	@GET
	@Path("/{estado}")
	public Response getMsg(@PathParam("estado") String estado) {
		return Response.status(200).build();
	}
}
