package whirlpool.newsletter.servicios;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import whirlpool.newsletter.WritterHelper;
import whirlpool.newsletter.configuracion.IpsSecurity;
import whirlpool.newsletter.configuracion.Propiedades;
import whirlpool.newsletter.entidades.NewsLetters;
import whirlpool.newsletter.entidades.NewsLettersDao;
import whirlpool.newsletter.entidades.Respuesta;




@Path("/news-letters")
public class NewsLettersService {
    	 
	   @Context
	   private UriInfo uri;
	   
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getTrackInJSON(@Context HttpServletRequest requestContex) {
		NewsLetters newsLetters = new NewsLetters();
		newsLetters.setBirthDate("25/12/2017");
		newsLetters.setCustomerId("111");
		newsLetters.setFirstName("PrimerNombre");
		newsLetters.setLastName("LastName");
		newsLetters.setRegistro("Alguno");
		newsLetters.setTienda("tienda");
		
		try{
	//	Propiedades p= new Propiedades();
	//	WritterHelper.getInstance().escribirCSVJobs(p.getPathSalidaTomcat()+"/"+p.getOutputFile(), newsLetters);
	//	p.getSftpPropiedades().transferirFichero(p.getPathSalidaTomcat()+"/"+p.getOutputFile(), p.getOutputPathSFTP()+"/"+p.getOutputFile());
	    return /*"salida: "+p.getPathSalidaTomcat()+"/"+p.getOutputFile()+"---"+*/requestContex.getRemoteAddr();	    
		}
		catch(Exception e){
			return e.getMessage()+"---"+requestContex.getRemoteAddr();
		}
	}
	
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		public Response createTrackInJSON(NewsLetters newsLetters,@Context HttpServletRequest requestContex){
			Propiedades p= new Propiedades();
			Respuesta respuesta = new Respuesta();
			if(!IpsSecurity.getInstance().validarIp(requestContex.getRemoteAddr())){
				respuesta.setProcesoCorrecto(false);
				respuesta.setMensaje("Has superado el limite de "+p.getMaximosPedidosPorIrDiario()+" requests diarios.");
				respuesta.setCodigoRespuesta(400);
			}else{
				NewsLettersDao newsLettersDao= new NewsLettersDao();
				respuesta= newsLettersDao.crearYSubirCSV(newsLetters);
			}
			return Response.status(respuesta.getCodigoRespuesta()).entity(respuesta.toString()).build();
		
		}
		
	}
