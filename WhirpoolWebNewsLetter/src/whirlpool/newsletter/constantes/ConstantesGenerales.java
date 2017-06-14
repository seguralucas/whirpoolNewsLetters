package whirlpool.newsletter.constantes;

import java.io.File;
import java.net.URISyntaxException;

import com.jcraft.jsch.Buffer;

import whirlpool.newsletter.WritterHelper;

public class ConstantesGenerales {
	 public static String SEPARADOR_ERROR_PETICION = "##############################################################################################";
	 public static String SEPARADOR_ERROR_JSON = "**********************************************************************************************";
	 public static String SEPARADOR_ERROR_TRYCATCH = "---------------------------------------------------------------------";
	 public static String PATH_EJECUCION;
	 public static String PATH_CONFIGURACION/*=PATH_EJECUCION+"/Configuracion/configuracion.properties"*/;
	 public static String PATH_MAPEO/*=PATH_EJECUCION+"/Configuracion/mapeo.csv"*/;
	 
	 static{
		 try {
			String aux=new File(ConstantesGenerales.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()).getAbsolutePath(); //Dos puntos porque te lo deja en /bin
			String auxs[]=aux.split("\\\\");
			if(auxs.length==1)
				auxs=aux.split("\\/");
			System.out.println(aux);
			PATH_EJECUCION="";
			for(int i=0;i<auxs.length-2;i++)
				PATH_EJECUCION+=auxs[i]+"/";
			PATH_EJECUCION=PATH_EJECUCION.substring(0, PATH_EJECUCION.length());
			System.out.println(PATH_EJECUCION);
		    PATH_CONFIGURACION=PATH_EJECUCION+"Configuracion/configuracion.properties";
			WritterHelper.getInstance().escribirAlFinal("test.txt", PATH_CONFIGURACION);
		    PATH_MAPEO=PATH_EJECUCION+"Configuracion/mapeo.csv";		 
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
}
