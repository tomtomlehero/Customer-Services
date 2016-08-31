package fr.mla.framework.ws.error;



import java.util.ArrayList;
import java.util.List;

public class ErrorEO {

	  private String id = null;
	  private String description = null;
	  private List<String> messages = new ArrayList<String>();

	  
	  /**
	   * Constructor, getters, setters...
	   */
	  

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
 

}
