package whirlpool.newsletter.configuracion;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import whirlpool.newsletter.WritterHelper;

public class SFTPPropiedades {
	private String user;
	private Integer puerto;
	private String keyFile;
	private String host;
	
	public SFTPPropiedades(){}
	
	public SFTPPropiedades(String host,String user, Integer puerto, String keyFile) {
		super();
		this.host=host;
		this.user = user;
		this.puerto = puerto;
		this.keyFile = keyFile;
	}
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public Integer getPuerto() {
		return puerto;
	}
	public void setPuerto(Integer puerto) {
		this.puerto = puerto;
	}
	public String getKeyFile() {
		return keyFile;
	}
	public void setKeyFile(String keyFile) {
		this.keyFile = keyFile;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}
	
	public void transferirFichero(String pathInput, String pathOutput) throws Exception {
	    try {
	    JSch jsch = new JSch();
	    jsch.addIdentity(this.getKeyFile());
	    Session session = jsch.getSession(this.getUser(), this.getHost(), this.getPuerto());
	    java.util.Properties config = new java.util.Properties(); 
	    config.put("StrictHostKeyChecking", "no");
	    session.setConfig(config);
	    session.connect();
	    Channel channel = session.openChannel("sftp");
	    channel.setInputStream(System.in);
	    channel.setOutputStream(System.out);
	    channel.connect();
	    ChannelSftp c = (ChannelSftp) channel;
	    c.put(pathInput, pathOutput);
	    c.exit();
	    session.disconnect();

		} catch (Exception e) {
		    e.printStackTrace();
		    WritterHelper.getInstance().escribirError("errorSFTP.log", "Error al transferir el archivo "+pathOutput+" por sftp");
		    throw e;
		}
}

			
}
