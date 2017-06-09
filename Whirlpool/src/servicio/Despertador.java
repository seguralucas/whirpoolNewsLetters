package servicio;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;


@Path("/despertador")
public class Despertador {
	@GET
	@Path("/{hora}/{minuto}")
	public Response getMsg(@PathParam("hora") String hora,@PathParam("minuto") String minuto) {
		return Response.status(200).build();
	}
}
