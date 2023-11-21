package nba.stats.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Points {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idpoints;
    int idmatcheffectif;
    int minute;
    int second;
    int points;

    public static Points copyAndControle(Points Points) throws Exception {
        Points j = new Points();
        j.update(Points);
        return j;
    }

    public void update(Points m) throws Exception {
        setIdpoints(m.getIdpoints());
        setMinute(m.getMinute());
        setSecond(m.getSecond());
        setIdmatcheffectif(m.getIdmatcheffectif());
    }

    public int getIdpoints() {
        return idpoints;
    }

    public void setIdpoints(int idpoints) {
        this.idpoints = idpoints;
    }

    public int getIdmatcheffectif() {
        return idmatcheffectif;
    }

    public void setIdmatcheffectif(int idmatcheffectif) {
        this.idmatcheffectif = idmatcheffectif;
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

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

}
