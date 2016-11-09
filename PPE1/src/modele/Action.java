package modele;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ACTION")
public class Action {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ida;
	private String action;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dernière_mise_à_jour;
	private String modifié_par;
	private String description;
	@OneToMany(mappedBy = "action", cascade = CascadeType.ALL)
	private List<Roles_Action> actions = new ArrayList<>();
	
	public void ajoutRole(Roles_Action nouveau, Role condition){
		actions.add(nouveau);
		nouveau.setAction(this);
	}

	public Action(String action, Date dernière_mise_à_jour, String modifié_par, String description) {
		super();
		this.action = action;
		this.dernière_mise_à_jour = dernière_mise_à_jour;
		this.modifié_par = modifié_par;
		this.description = description;
	}

	public Action() {
		super();
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Roles_Action> getActions() {
		return actions;
	}

	public void setActions(List<Roles_Action> actions) {
		this.actions = actions;
	}

	@Override
	public String toString() {
		return "Action [action=" + action + ", dernière_mise_à_jour=" + dernière_mise_à_jour + ", modifié_par="
				+ modifié_par + ", description=" + description + ", actions=" + actions + "]";
	}

}
