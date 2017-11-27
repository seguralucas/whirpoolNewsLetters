package fiber.externalapis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import fiber.newsletter.entidades.Respuesta;
import fiber.propiedades.PropiedadesFiberWS;

public class HandlerExternalApis {

	private String URL_BASE=PropiedadesFiberWS.getInstance().getUrlBase();
	public static Integer RESPONSE_GET_CODE_OK=200;
	public Respuesta getProductsById(String productId) {
		  HttpURLConnection connection = null;
		  try {
		    URL url = new URL(URL_BASE+"/rest/search/spGetDataClientByProd?iIdProducto="+productId+"&oauth_token="+PropiedadesFiberWS.getInstance().getToken());
		    connection = (HttpURLConnection) url.openConnection();
		    connection.setRequestMethod("GET");
		    connection.setRequestProperty("Content-Type", 
		        "application/x-www-form-urlencoded");
		    connection.setRequestProperty("Content-Language", "en-US");  
		    connection.setUseCaches(false);
		    connection.setDoOutput(true);
		    return UtilsWS.empaquetarRespuesta(connection,RESPONSE_GET_CODE_OK);
		}
	   catch (Exception e) {
		    e.printStackTrace();
		    return null;
		  } finally {
		    if (connection != null) {
		      connection.disconnect();
		    }
		  }
	}
	
	public static void main(String[] args) {
		HandlerExternalApis h= new HandlerExternalApis();
		System.out.println(h.getProductsBySucursalId("Terminal"));
	}
	//Terminal
	public Respuesta getProductsBySucursalId(String idSucursal) {
		  HttpURLConnection connection = null;
		  try {
		    URL url = new URL(URL_BASE+"/rest/search/spGetDataClientByProd?iSucursal="+idSucursal+"&oauth_token="+PropiedadesFiberWS.getInstance().getToken());
		    connection = (HttpURLConnection) url.openConnection();
		    connection.setRequestMethod("GET");
		    connection.setRequestProperty("Content-Type", 
		        "application/x-www-form-urlencoded");
		    connection.setRequestProperty("Content-Language", "en-US");  
		    connection.setUseCaches(false);
		    connection.setDoOutput(true);
		    return UtilsWS.empaquetarRespuesta(connection,RESPONSE_GET_CODE_OK);
		}
	   catch (Exception e) {
		    e.printStackTrace();
		    return null;
		  } finally {
		    if (connection != null) {
		      connection.disconnect();
		    }
		  }
	}
	
	
	

	

}
