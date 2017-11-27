package fiber.externalapis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import fiber.newsletter.constantes.ConstantesGenerales;
import fiber.newsletter.entidades.Respuesta;

public class HandlerProducto {
	private static HandlerExternalApis handlerExternalApis= new HandlerExternalApis();
	
	public static Respuesta getJsonProductByIdProduct(String idProd) throws Exception{
		Respuesta r= handlerExternalApis.getProductsById(idProd);
		if(!r.getCodigoRespuesta().equals(HandlerExternalApis.RESPONSE_GET_CODE_OK))
			return r;
		JSONObject jsonResultado=UtilsJson.convertirStringToJson(r.getDatosRespuesta().toString());
		JSONArray arrayProducts =((JSONArray)jsonResultado.get("rows"));
		if(arrayProducts.size()==0){
			r.setDatosRespuesta(null);
			return r;
		}
		jsonResultado=(JSONObject)arrayProducts.get(0);	
		r.setDatosRespuesta(jsonResultado);
		return r;
	}
	

	

	public static void main(String[] args) throws Exception{
		System.out.println(getJsonProductByIdProduct("18508320"));// 

	}
}
