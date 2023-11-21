package nba.stats.models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idmatch;
    String lieu;
    int equipe1;
    int equipe2;
    Date datedebut;

    public static Match copyAndControle(Match Match) throws Exception {
        Match j = new Match();
        j.update(Match);
        return j;
    }

    public void update(Match m) throws Exception {
        setDatedebut(m.getDatedebut());
        setEquipe1(m.getEquipe1());
        setEquipe2t(m.getEquipe2());
        setLieu(m.getLieu());
        setIdmatch(m.getIdmatch());
    }

    public int getIdmatch() {
        return idmatch;
    }

    public void setIdmatch(int idmatch) {
        this.idmatch = idmatch;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public int getEquipe1() {
        return equipe1;
    }

    public void setEquipe1(int equipe1) {
        this.equipe1 = equipe1;
    }

    public int getEquipe2() {
        return equipe2;
    }

    public void setEquipe2(int equipe2) {
        this.equipe2 = equipe2;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

}
