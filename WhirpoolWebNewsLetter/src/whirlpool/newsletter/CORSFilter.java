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

public class CORSFilter implements ContainerResponseFilter {
	private final String URL_PERMITIDA="http://kitchenaid.com.co";
    @Override
    public ContainerResponse filter(ContainerRequest request,
            ContainerResponse response) {
    	List<String> listaOrigenes=request.getRequestHeader("origin");
    	if(listaOrigenes!=null && listaOrigenes.size()==1 && listaOrigenes.get(0).equalsIgnoreCase(URL_PERMITIDA)){
	        response.getHttpHeaders().add("Access-Control-Allow-Origin", "*");
	        response.getHttpHeaders().add("Access-Control-Allow-Headers",
	                "origin, content-type, accept, authorization");
	        response.getHttpHeaders().add("Access-Control-Allow-Credentials", "true");
	        response.getHttpHeaders().add("Access-Control-Allow-Methods",
	                "GET, POST, PUT, DELETE, OPTIONS, HEAD");
    	}
        return response;
    }
}