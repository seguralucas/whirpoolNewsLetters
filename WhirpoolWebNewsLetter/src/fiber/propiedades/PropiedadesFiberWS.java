package fiber.propiedades;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.json.simple.JSONObject;

import fiber.externalapis.HandlerExternalApis;
import fiber.newsletter.constantes.ConstantesGenerales;

public class PropiedadesFiberWS {
	HashMap<String, String> mapPropiedades;
	private static PropiedadesFiberWS instance;
    private PropiedadesFiberWS(){
    	mapPropiedades=new HashMap<String,String>();
        Properties props = new Properties();
        try{
		props.load(new FileReader(ConstantesGenerales.PATH_FIBERWS_PROPIEDADES));
		for(String key : props.stringPropertyNames()) 
			  mapPropiedades.put(key, props.getProperty(key));
        }
        catch(Exception e){
        	e.printStackTrace();
        	try(FileWriter fw= new FileWriter(new File("ErrorTemprano.txt"))) {
        		e.printStackTrace();
				fw.write("Error al recuperar las propierdades del fichero: ConfiguracionGeneral.properties");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
        }
    }
    
    public static synchronized PropiedadesFiberWS getInstance() {
    	if(instance==null)
    		instance=new PropiedadesFiberWS();
    	return instance;
    }
    
    public String getToken(){
    	return mapPropiedades.get("token");
    }

    public String getUrlBase(){
    	return mapPropiedades.get("urlBase");
    }
    
    private String getValueMap(String key){
    	return mapPropiedades.get(key);
    }
    
    public static void main(String[] args) {
		System.out.println(ConstantesGenerales.PATH_OSVC_PROPIEDADES+" "+PropiedadesFiberWS.getInstance().getUrlBase());
	}
}
