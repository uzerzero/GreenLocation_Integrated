package modele;

import java.io.Serializable;
import javax.persistence.*;

@MappedSuperclass
@Entity
public class Utilisateur implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public Utilisateur() {
		super();
	}
	private long id;
	private String login;	
	private String pwd;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
   
}
