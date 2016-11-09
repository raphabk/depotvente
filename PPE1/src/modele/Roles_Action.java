package modele;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="ROLES_ACTION")
public class Roles_Action {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idra;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dernière_mise_à_jour;
	private String modifié_par;
	@ManyToOne
	@JoinColumn(name="action_fk")
	private Action action;
	@ManyToOne
	@JoinColumn(name="role_fk")
	private Role rolea;

	public Roles_Action() {
		super();
	}

	public Roles_Action(Date dernière_mise_à_jour, String modifié_par, Action action, Role role) {
		super();
		this.dernière_mise_à_jour = dernière_mise_à_jour;
		this.modifié_par = modifié_par;
		this.action = action;
		this.rolea = role;
	}

	public Date getDernière_mise_à_jour() {
		return dernière_mise_à_jour;
	}

	public void setDernière_mise_à_jour(Date dernière_mise_à_jour) {
		this.dernière_mise_à_jour = dernière_mise_à_jour;
	}

	public String getModifié_par() {
		return modifié_par;
	}

	public void setModifié_par(String modifié_par) {
		this.modifié_par = modifié_par;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public Role getRole() {
		return rolea;
	}

	public void setRole(Role role) {
		this.rolea = role;
	}

	@Override
	public String toString() {
		return "Roles_Action [dernière_mise_à_jour=" + dernière_mise_à_jour + ", modifié_par=" + modifié_par
				+ ", action=" + action + ", role=" + rolea + "]";
	}

}
