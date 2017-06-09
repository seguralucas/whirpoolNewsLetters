package servicio;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;


@Path("/joda")
public class Joda {
	@GET
	@Path("/{milSeg}")
	public Response getMsg(@PathParam("milSeg") String milSeg) {
		return Response.status(200).build();
	}
}
