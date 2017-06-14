package whirlpool.newsletter.configuracion;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Properties;

import whirlpool.newsletter.WritterHelper;
import whirlpool.newsletter.constantes.ConstantesGenerales;


public class Propiedades {

	private String instancia;
	private String pathSalidaTomcat;
	private String outputFile;
	private String outputPathSFTP;
	private SFTPPropiedades sftpPropiedades;
	private String urlAllowed;
	private Integer maximosPedidosPorIrDiario;
	public Propiedades(){

		
		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream(ConstantesGenerales.PATH_CONFIGURACION);
			prop.load(input);
			instancia= prop.getProperty("instancia");
			pathSalidaTomcat=prop.getProperty("pathSalidaTomcat");
			outputFile=prop.getProperty("outputFile");
			sftpPropiedades=new SFTPPropiedades(prop.getProperty("host"),prop.getProperty("user"), Integer.parseInt(prop.getProperty("puerto")), prop.getProperty("keyFile"));
			outputPathSFTP=prop.getProperty("outputPathSFTP");
			urlAllowed= prop.getProperty("urlAllowed");
			maximosPedidosPorIrDiario=Integer.parseInt(prop.getProperty("maximosPedidosPorIrDiario"));
			

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public String getInstancia() {
		return instancia;
	}

	
	
	public String getUrlAllowed() {
		return urlAllowed;
	}

	public String getOutputPathSFTP() {
		return outputPathSFTP;
	}

	
	public Integer getMaximosPedidosPorIrDiario() {
		return maximosPedidosPorIrDiario;
	}

	private String completarFechaConCeroAIzquierda(String value){
		return value.length()<2?"0"+value:value;
	}

	public String getOutputFile() {
		LocalDateTime ldt= LocalDateTime.now();
		outputFile=outputFile.replaceAll("YY",completarFechaConCeroAIzquierda(String.valueOf(ldt.getYear())));
		outputFile=outputFile.replaceAll("MM",completarFechaConCeroAIzquierda(String.valueOf(ldt.getMonthValue())));
		outputFile=outputFile.replaceAll("DD",completarFechaConCeroAIzquierda(String.valueOf(ldt.getDayOfMonth())));
		outputFile=outputFile.replaceAll("HH",completarFechaConCeroAIzquierda(String.valueOf(ldt.getHour())));
		outputFile=outputFile.replaceAll("MI",completarFechaConCeroAIzquierda(String.valueOf(ldt.getMinute())));
		outputFile=outputFile.replaceAll("SS",completarFechaConCeroAIzquierda(String.valueOf(ldt.getSecond())));
		outputFile=outputFile.replaceAll("NN",completarFechaConCeroAIzquierda(String.valueOf(ldt.getNano())));
		return outputFile;	
	}
	

	public void setPathSalidaTomcat(String pathSalida) {
		this.pathSalidaTomcat = pathSalida;
	}
	
	public String getPathSalidaTomcat(){
		return pathSalidaTomcat;
	}
	
	public SFTPPropiedades getSftpPropiedades(){
		return sftpPropiedades;
	}
	


}
