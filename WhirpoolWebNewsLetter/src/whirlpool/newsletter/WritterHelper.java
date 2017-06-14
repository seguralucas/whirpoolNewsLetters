package whirlpool.newsletter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.sun.xml.internal.fastinfoset.sax.Properties;

import whirlpool.newsletter.configuracion.MapeoCSV;
import whirlpool.newsletter.configuracion.Propiedades;
import whirlpool.newsletter.entidades.NewsLetters;

public class WritterHelper {
	
	private static WritterHelper instance;
	private WritterHelper(){}
	
	public static synchronized WritterHelper getInstance(){
		if(instance==null)
			instance=new WritterHelper();
		return instance;			
	}
	
	
	public synchronized void escribirAlFinal(String path, String line){
		escribirAlFinal(new File(path),line);
	}
	private synchronized void escribirAlFinal(File file, String line){
		try(FileWriter fw = new FileWriter(file, true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
			{
			    out.println(line);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public synchronized void escribirError(String nameFile, String line){
		Propiedades p= new Propiedades();
		File theDir = new File("erroresDe"+p.getInstancia());
		if (!theDir.exists()) {
		    System.out.println("creating directory: " + theDir.getName());
		    boolean result = false;
		    try{
		        theDir.mkdir();
		        result = true;
		    } 
		    catch(SecurityException se){
		    	se.printStackTrace();
		    }        
		    if(result) {    
		        System.out.println("DIR created");  
		    }
		}
		LocalDateTime timeNow= LocalDateTime.now();
        escribirAlFinal(theDir.getPath()+"/"+nameFile,timeNow+": "+line);
	}
	
	public synchronized void escribirCSVJobs(String path, NewsLetters newsLetters){
		escribirCSVJobs(new File(path), newsLetters);
	}
	
	public synchronized void escribirCSVJobs(File f, NewsLetters newsLetters){
		MapeoCSV mapeo= new MapeoCSV();
		escribirAlFinal(f, mapeo.getCabecera());
		String cuerpo=newsLetters.reemplazarKeysPorValue(mapeo.getCuerpo());
		escribirAlFinal(f, cuerpo);
	}
	
	public static void main(String[] args) {
		File theDir = new File("errores");
		if (!theDir.exists()) {
		    boolean result = false;
		    try{
		        theDir.mkdir();
		        result = true;
		    } 
		    catch(SecurityException se){
		    	se.printStackTrace();
		    }        
		    if(result) {    
		        System.out.println("DIR created");  
		    }
	}
	}
	

}
