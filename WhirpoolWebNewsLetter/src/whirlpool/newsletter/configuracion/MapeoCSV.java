package whirlpool.newsletter.configuracion;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;

import whirlpool.newsletter.constantes.ConstantesGenerales;

public class MapeoCSV {
	private String cabecera;
	private String cuerpo;
	
	public MapeoCSV(){
		File f= new File(ConstantesGenerales.PATH_MAPEO);
		try(FileReader fr= new FileReader(f)) {
				BufferedReader br= new BufferedReader(fr);
				String aux="";
				int line=0;
				while((aux=br.readLine())!=null && line<2){
					if(line==0)
						cabecera=aux;
					else
						cuerpo=aux;
					line++;
				}				
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	public String getCabecera() {
		return cabecera;
	}

	public void setCabecera(String cabecera) {
		this.cabecera = cabecera;
	}

	public String getCuerpo() {
		return cuerpo;
	}

	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}
	

	
}
