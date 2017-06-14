package whirlpool.newsletter.entidades;


import whirlpool.newsletter.WritterHelper;
import whirlpool.newsletter.configuracion.Propiedades;

public class NewsLettersDao {

	public Respuesta crearYSubirCSV(NewsLetters newsLetters){
		Respuesta respuesta = new Respuesta();
		try{
			Propiedades p= new Propiedades();
			WritterHelper.getInstance().escribirCSVJobs(p.getPathSalidaTomcat()+"/"+p.getOutputFile(), newsLetters);
			p.getSftpPropiedades().transferirFichero(p.getPathSalidaTomcat()+"/"+p.getOutputFile(), p.getOutputPathSFTP()+"/"+p.getOutputFile());				
			respuesta.setProcesoCorrecto(true);
			respuesta.setMensaje("NewLetter subido correctamente");
			respuesta.setCodigoRespuesta(200);
		}
		catch(Exception e){
			respuesta.setProcesoCorrecto(false);
			respuesta.setMensaje(e.getMessage());
			respuesta.setCodigoRespuesta(400);
		}
			return respuesta;
	}
}
