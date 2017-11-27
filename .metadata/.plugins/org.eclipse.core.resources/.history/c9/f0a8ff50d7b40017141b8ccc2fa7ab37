package whirlpool.newsletter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MultivaluedMap;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;
import com.sun.xml.internal.fastinfoset.sax.Properties;

import whirlpool.newsletter.configuracion.Propiedades;

public class CORSFilter implements ContainerResponseFilter {


    @Override
    public ContainerResponse filter(ContainerRequest request,
            ContainerResponse response) {
    	Propiedades p= new Propiedades();
    	List<String> listaOrigenes=request.getRequestHeader("origin");
    	if(listaOrigenes.size()==1 && listaOrigenes.get(0).matches(".*"+p.getUrlAllowed())){
    		System.out.println("Origen"+listaOrigenes.get(0));
	        response.getHttpHeaders().add("Access-Control-Allow-Origin", listaOrigenes.get(0));
	        response.getHttpHeaders().add("Access-Control-Allow-Headers",
	                "origin, content-type, accept, authorization");
	        response.getHttpHeaders().add("Access-Control-Allow-Credentials", "true");
	        response.getHttpHeaders().add("Access-Control-Allow-Methods", "POST");
    	}
        return response;
    }

}


