package whirlpool.newsletter.configuracion;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;

import com.sun.xml.internal.fastinfoset.sax.Properties;

public class IpsSecurity {
	
	private static IpsSecurity instance;
	HashMap<String, IntentosDias> map;
	private IpsSecurity(){
		map= new HashMap<String, IntentosDias>();
	}
	
	public synchronized static IpsSecurity getInstance(){
		if(instance==null)
			instance= new IpsSecurity();
		return instance;
	}
	
	public boolean validarIp(String ip){
		Propiedades p= new Propiedades();
		if(!map.containsKey(ip)){
			insertarEnMap(ip);
			return true;
		}
		IntentosDias intentosDias=map.get(ip);
		if(fechaExpirada(intentosDias)){
			insertarEnMap(ip);
			return true;
		}
		if(intentosDias.cantRequests.compareTo(p.getMaximosPedidosPorIrDiario())<0){
			intentosDias.cantRequests++;
			return true;
		}
		return false;
	}
	private boolean fechaExpirada(IntentosDias intentosDias){
		return intentosDias.fechaDePrimerIntento.isBefore(LocalDate.now());
	}
	
	private void insertarEnMap(String ip){
		map.put(ip, new IntentosDias(LocalDate.now()));
	}
	
	
	private class IntentosDias{
		public LocalDate fechaDePrimerIntento;
		public Integer cantRequests;
		public IntentosDias(LocalDate fechaDePrimerIntento){
			cantRequests=1;
			this.fechaDePrimerIntento=fechaDePrimerIntento;
		}

	}
	
	public static void main(String[] args) {
		System.out.println(IpsSecurity.getInstance().validarIp("127.0.0.1"));
		System.out.println(IpsSecurity.getInstance().validarIp("127.0.0.1"));
		System.out.println(IpsSecurity.getInstance().validarIp("127.0.0.1"));
		System.out.println(IpsSecurity.getInstance().validarIp("127.0.0.1"));
	}
	
}

