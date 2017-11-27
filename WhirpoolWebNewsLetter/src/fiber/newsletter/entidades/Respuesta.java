package fiber.newsletter.entidades;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Respuesta {
	private boolean procesoCorrecto;
	private Object datosRespuesta;
	private Integer codigoRespuesta;
	public Respuesta() {
		super();
	}

	public boolean isProcesoCorrecto() {
		return procesoCorrecto;
	}

	public void setProcesoCorrecto(boolean procesoCorrecto) {
		this.procesoCorrecto = procesoCorrecto;
	}

	public boolean getProcesoCorrecto() {
		return procesoCorrecto;
	}

	public Object getDatosRespuesta() {
		return datosRespuesta;
	}

	public void setDatosRespuesta(Object datosRespuesta) {
		this.datosRespuesta = datosRespuesta;
	}
	

	public Integer getCodigoRespuesta() {
		return codigoRespuesta;
	}

	public void setCodigoRespuesta(Integer codigoRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
	}

	@Override
	public String toString() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			return "{\"procesoCorrecto\":"+this.isProcesoCorrecto()+", \"mensaje\":\""+this.getDatosRespuesta()+"\", \"codigoRespuesta\":"+this.getCodigoRespuesta()+" }";
		}
		//return "{\"procesoCorrecto\":"+this.isProcesoCorrecto()+", \"mensaje\":\""+this.getMensaje()+"\", \"codigoRespuesta\":"+this.getCodigoRespuesta()+" }";
	}
	
	
	
	
}
