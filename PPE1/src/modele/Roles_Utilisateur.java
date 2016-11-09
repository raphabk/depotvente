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
@Table(name = "ROLES_UTILISATEUR")
public class Roles_Utilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idru;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dernière_mise_à_jour;
	private String modifié_par;
	@ManyToOne
	@JoinColumn(name = "utilisateur_fk")
	private Utilisateur utilisateur;
	@ManyToOne
	@JoinColumn(name = "role_fk")
	private Role roleu;

	public Roles_Utilisateur() {
		super();
	}

	public Roles_Utilisateur(Date dernière_mise_à_jour, String modifié_par, Utilisateur utilisateur) {
		super();
		this.dernière_mise_à_jour = dernière_mise_à_jour;
		this.modifié_par = modifié_par;
		this.utilisateur = utilisateur;
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

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Role getRoleu() {
		return roleu;
	}

	public void setRoleu(Role roleu) {
		this.roleu = roleu;
	}

	@Override
	public String toString() {
		return "Role_Utilisateur [dernière_mise_à_jour=" + dernière_mise_à_jour + ", modifié_par=" + modifié_par
				+ ", utilisateur=" + utilisateur + "]";
	}

}
