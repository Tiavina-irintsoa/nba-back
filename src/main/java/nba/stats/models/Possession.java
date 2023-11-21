package nba.stats.models;

import java.sql.Date;
import java.sql.Time;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import nba.stats.models.Match;

@Entity
public class Possession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idpossession;
    int idmatcheffectif;
    Time debut;
    Time fin;

    public static Possession copyAndControle(Possession Possession) throws Exception {
        Possession j = new Possession();
        j.update(Possession);
        return j;
    }

    public void update(Possession p) throws Exception {
        setDebut(p.getDebut());
        setFin(p.getFin());
        setIdpossession(p.getIdpossession());
        setIdmatcheffectif(p.getIdmatcheffectif());
    }

    public int getIdmatcheffectif() {
        return idmatcheffectif;
    }

    public void setIdmatcheffectif(int idmatcheffectif) {
        this.idmatcheffectif = idmatcheffectif;
    }

    public Time getDebut() {
        return debut;
    }

    public void setDebut(Time debut) {
        this.debut = debut;
    }

    public Time getFin() {
        return fin;
    }

    public void setFin(Time fin) {
        this.fin = fin;
    }

    public int getIdpossession() {
        return idpossession;
    }

    public void setIdpossession(int idpossession) {
        this.idpossession = idpossession;
    }

}
