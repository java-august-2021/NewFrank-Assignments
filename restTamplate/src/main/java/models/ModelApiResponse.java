package models;

import java.io.Serializable;
import java.util.List;

public class ModelApiResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8233863255476558598L;
	
	private int count;
	
	private String next;
	
	private String previous;
	
	private List<ApiReponseObject> results;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public String getPrevious() {
		return previous;
	}

	public void setPrevious(String previous) {
		this.previous = previous;
	}

	public List<ApiReponseObject> getResults() {
		return results;
	}

	public void setResults(List<ApiReponseObject> results) {
		this.results = results;
	}
	
	
	
	

}
