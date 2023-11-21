package nba.stats.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Rebond {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idrebond;
    int idmatcheffectif;
    int minute;
    int second;

    public static Rebond copyAndControle(Rebond Rebond) throws Exception {
        Rebond j = new Rebond();
        j.update(Rebond);
        return j;
    }

    public void update(Rebond m) throws Exception {
        setIdrebond(m.getIdrebond());
        setMinute(m.getMinute());
        setSecond(m.getSecond());
        setIdmatcheffectif(m.getIdmatcheffectif());
    }

    public int getIdrebond() {
        return idrebond;
    }

    public void setIdrebond(int idrebond) {
        this.idrebond = idrebond;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getIdmatcheffectif() {
        return idmatcheffectif;
    }

    public void setIdmatcheffectif(int idmatcheffectif) {
        this.idmatcheffectif = idmatcheffectif;
    }

}
