package nba.stats.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import nba.stats.models.Joueur;

@Entity(name = "joueur_equipe")
public class JoueurEquipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idjoueur_equipe;
    int idequipe;
    int idjoueur;
    Date datecontrat;

    public static JoueurEquipe copyAndControle(JoueurEquipe joueurEquipe) throws Exception {
        JoueurEquipe j = new JoueurEquipe();
        j.update(joueurEquipe);
        return j;
    }

    public void update(JoueurEquipe j) throws Exception {
        setIdjoueur_equipe(j.getIdjoueur_equipe());
        setIdjoueur(j.getIdjoueur());
        setIdequipe(j.getIdequipe());
        setDatecontrat(j.getDatecontrat());
    }

    public int getIdjoueur_equipe() {
        return idjoueur_equipe;
    }

    public void setIdjoueur_equipe(int idjoueur_equipe) {
        this.idjoueur_equipe = idjoueur_equipe;
    }

    public int getIdequipe() {
        return idequipe;
    }

    public void setIdequipe(int idequipe) {
        this.idequipe = idequipe;
    }

    public int getIdjoueur() {
        return idjoueur;
    }

    public void setIdjoueur(int idjoueur) {
        this.idjoueur = idjoueur;
    }

    public Date getDatecontrat() {
        return datecontrat;
    }

    public void setDatecontrat(Date datecontrat) {
        this.datecontrat = datecontrat;
    }
}
