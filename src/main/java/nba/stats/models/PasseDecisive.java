package nba.stats.models;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import nba.stats.models.Match;
@Entity
public class PasseDecisive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idPasseDecisive;
    double minute;
    double second;
    int matcheffectif;

    public static PasseDecisive copyAndControle(PasseDecisive PasseDecisive) throws Exception {
        PasseDecisive j = new PasseDecisive();
        j.update(PasseDecisive);
        return j;
    }
    public void update(PasseDecisive m) throws Exception {
        setSecond(m.getSecond());
        setMinute(m.getMinute());
        setMatcheffectif(m.getMatcheffectif());
}
    public int getIdPasseDecisive() {
        return idPasseDecisive;
    }
    public void setIdPasseDecisive(int idPasseDecisive) {
        this.idPasseDecisive = idPasseDecisive;
    }
    public double getMinute() {
        return minute;
    }
    public void setMinute(double minute) {
        this.minute = minute;
    }
    public double getSecond() {
        return second;
    }
    public void setSecond(double second) {
        this.second = second;
    }
    public int getMatcheffectif() {
        return matcheffectif;
    }
    public void setMatcheffectif(int matcheffectif) {
        this.matcheffectif = matcheffectif;
    }
}
