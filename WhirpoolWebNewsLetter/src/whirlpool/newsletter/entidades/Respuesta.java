package whirlpool.newsletter.entidades;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Respuesta {
	private boolean procesoCorrecto;
	private String mensaje;
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

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
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
			return "{\"procesoCorrecto\":"+this.isProcesoCorrecto()+", \"mensaje\":\""+this.getMensaje()+"\", \"codigoRespuesta\":"+this.getCodigoRespuesta()+" }";
		}
		//return "{\"procesoCorrecto\":"+this.isProcesoCorrecto()+", \"mensaje\":\""+this.getMensaje()+"\", \"codigoRespuesta\":"+this.getCodigoRespuesta()+" }";
	}
	
	
	
	
}
