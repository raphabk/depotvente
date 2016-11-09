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
@Table(name = "UTILISATEUR")
public class Utilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idu;
	private String nom;
	private String prénom;
	private String email;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dernière_mise_a_jour;
	private String modifié_par;
	@OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
	private List<Roles_Utilisateur> roleUtilisateurs = new ArrayList<>();
	
	public void ajoutRole(Roles_Utilisateur nouveau, Role condition){
		roleUtilisateurs.add(nouveau);
		nouveau.setUtilisateur(this);
	}


	public Utilisateur() {
		super();
	}

	public Utilisateur(String nom, String prénom, String email, Date dernière_mise_a_jour, String modifié_par) {
		super();
		this.nom = nom;
		this.prénom = prénom;
		this.email = email;
		this.dernière_mise_a_jour = dernière_mise_a_jour;
		this.modifié_par = modifié_par;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrénom() {
		return prénom;
	}

	public void setPrénom(String prénom) {
		this.prénom = prénom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDernière_mise_a_jour() {
		return dernière_mise_a_jour;
	}

	public void setDernière_mise_a_jour(Date dernière_mise_a_jour) {
		this.dernière_mise_a_jour = dernière_mise_a_jour;
	}

	public String getModifié_par() {
		return modifié_par;
	}

	public void setModifié_par(String modifié_par) {
		this.modifié_par = modifié_par;
	}

	public List<Roles_Utilisateur> getRoleUtilisateurs() {
		return roleUtilisateurs;
	}

	public void setRoleUtilisateurs(List<Roles_Utilisateur> roleUtilisateurs) {
		this.roleUtilisateurs = roleUtilisateurs;
	}

	@Override
	public String toString() {
		return "Utilisateur [nom=" + nom + ", prénom=" + prénom + ", email=" + email + ", dernière_mise_a_jour="
				+ dernière_mise_a_jour + ", modifié_par=" + modifié_par + ", roleUtilisateurs=" + roleUtilisateurs
				+ "]";
	}

}
