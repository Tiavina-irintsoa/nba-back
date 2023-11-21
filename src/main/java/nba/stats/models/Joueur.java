package nba.stats.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Joueur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idJoueur;
    String nomJoueur;

    public static Joueur copyAndControle(Joueur joueur) throws Exception {
        Joueur j = new Joueur();
        j.setNomJoueur(joueur.getNomJoueur());
        return j;
    }

    public void update(Joueur joueur) throws Exception {
        setNomJoueur(joueur.getNomJoueur());
    }

    public int getIdJoueur() {
        return idJoueur;
    }

    public void setIdJoueur(int idJoueur) {
        this.idJoueur = idJoueur;
    }

    public String getNomJoueur() {
        return nomJoueur;
    }

    public void setNomJoueur(String nomJoueur) throws Exception {
        if (nomJoueur.length() == 0) {
            throw new Exception("Nom invalide");
        }
        this.nomJoueur = nomJoueur;
    }
}
