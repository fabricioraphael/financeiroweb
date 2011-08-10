package financeiro.web;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class UserBean {
	private String name;
	private String email;
	private String password;
	private String confirmPassword;
	
//	public String neww(){
//		return "user";
//	}
	public String save(){
		FacesContext context = FacesContext.getCurrentInstance();
		if(!this.password.equalsIgnoreCase(this.confirmPassword)){
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Password incorrect!", ""));
			return "user";
		}
		return "success";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmsPassword) {
		this.confirmPassword = confirmsPassword;
	}
}
