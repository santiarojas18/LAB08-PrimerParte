package guessBean;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Component;

@Component
@ManagedBean
@ApplicationScoped
public class UserBean {
	private String userName;
	
	public UserBean() {
	}
	
	/**
	 * Sets the user name according to the data registered by the user
	 * @param userName
	 */
	public void setUserName(String userName ) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}
}
