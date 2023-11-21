package nba.stats.models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import nba.stats.models.Match;

@Entity
public class MatchJoueur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idmatcheffectif;
    int idmatch;
    int idjoueur;

    public static MatchJoueur copyAndControle(MatchJoueur m) throws Exception {
        MatchJoueur j = new MatchJoueur();
        j.update(m);
        return j;
    }

    public void update(MatchJoueur m) throws Exception {
        setIdjoueur(m.getIdjoueur());
        setIdmatch(m.getIdmatch());
        setIdmatcheffectif(m.getIdmatcheffectif());
    }

    public int getIdmatcheffectif() {
        return idmatcheffectif;
    }

    public void setIdmatcheffectif(int idmatcheffectif) {
        this.idmatcheffectif = idmatcheffectif;
    }

    public int getIdmatch() {
        return idmatch;
    }

    public void setIdmatch(int idmatch) {
        this.idmatch = idmatch;
    }

    public int getIdjoueur() {
        return idjoueur;
    }

    public void setIdjoueur(int idjoueur) {
        this.idjoueur = idjoueur;
    }

}
