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
@Table(name = "ROLE")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idr;
	private String role;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dernière_mise_à_jour;
	private String modifié_par;
	private String description;
	
	@OneToMany(mappedBy = "roleu", cascade = CascadeType.ALL)
	private List<Roles_Utilisateur> utilisateurs = new ArrayList<>();
	@OneToMany(mappedBy="rolea", cascade = CascadeType.ALL)
	private List<Roles_Action> rolea = new ArrayList<>();
	
	public void ajoutRole(Roles_Utilisateur nouveau, Utilisateur condition){
		utilisateurs.add(nouveau);
		nouveau.setRoleu(this);
	}
	
	public void ajoutRAR(Roles_Action nouveau, Action condition){
		rolea.add(nouveau);
		nouveau.setRole(this);
	}

	public Role() {
		super();
	}

	public Role(String role, Date dernière_mise_à_jour, String modifié_par, String description) {
		super();
		this.role = role;
		this.dernière_mise_à_jour = dernière_mise_à_jour;
		this.modifié_par = modifié_par;
		this.description = description;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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

	public List<Roles_Utilisateur> getutilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(List<Roles_Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public List<Roles_Action> getActions() {
		return rolea;
	}

	public void setActions(List<Roles_Action> actions) {
		this.rolea = actions;
	}

	@Override
	public String toString() {
		return "Role [role=" + role + ", dernière_mise_à_jour=" + dernière_mise_à_jour + ", modifié_par=" + modifié_par
				+ ", description=" + description + ", utilisateurs=" + utilisateurs + ", actions=" + rolea + "]";
	}

}
