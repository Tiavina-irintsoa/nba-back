package main.java.nba.stats.models;
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
    String abreviation;

    public static Joueur copyAndControle(Joueur joueur) throws Exception{
        Joueur j = new Joueur();
        j.setNomJoueur(joueur.getNomJoueur());
        j.setAbreviation(joueur.getAbreviation());
    }
    public void update(Joueur joueur){
        setNom(joueur.getNom());
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
        if(nomJoueur.length()==0){
            throw new Exception("Nom invalide");
        }
        this.nomJoueur = nomJoueur;
    }
    public String getAbreviation() {
        return abreviation;
    }
    public void setAbreviation(String abreviation) throws Exception {
        if(abreviation.length()==0){
             throw new Exception("Abreviation invalide");
        }
        this.abreviation = abreviation;
    }
}
