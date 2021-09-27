package models;

import java.io.Serializable;

public class ApiReponseObject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5245272563587741893L;
	
	
	private String name;
	
	private String url;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	
	
	
	

}
