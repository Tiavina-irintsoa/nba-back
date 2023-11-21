package nba.stats.models;

import java.lang.annotation.Inherited;
import java.sql.Time;

@Entity
public class FicheJoueur {
    @Id
    private int idJoueur;
    @OneToOne
    @JoinColumn(name="idjoueur",referencedColumnName="idjoueur",insertable=false,updatable=false)
    Joueur joueur;

    @JoinColumn(name="idequipe",referencedColumnName="idequipe",insertable=false,updatable=false)
    Equipe equipe;

    double rpm;
    double pdpm;
    double lf;
    double deuxp;
    double troisp;
    double ppm;
    Time mpm;
    double mj;
    double m;


    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Joueur getJoueur() {
        return joueur;
    }
    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }
    public Equipe getEquipe() {
        return equipe;
    }
    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }
    public double getRpm() {
        return rpm;
    }
    public void setRpm(double rpm) {
        this.rpm = rpm;
    }
    public double getPdpm() {
        return pdpm;
    }
    public void setPdpm(double pdpm) {
        this.pdpm = pdpm;
    }
    public double getLf() {
        return lf;
    }
    public void setLf(double lf) {
        this.lf = lf;
    }
    public double getDeuxp() {
        return deuxp;
    }
    public void setDeuxp(double deuxp) {
        this.deuxp = deuxp;
    }
    public double getTroisp() {
        return troisp;
    }
    public void setTroisp(double troisp) {
        this.troisp = troisp;
    }
    public double getPpm() {
        return ppm;
    }
    public void setPpm(double ppm) {
        this.ppm = ppm;
    }
    public Time getMpm() {
        return mpm;
    }
    public void setMpm(Time mpm) {
        this.mpm = mpm;
    }
    public double getMj() {
        return mj;
    }
    public void setMj(double mj) {
        this.mj = mj;
    }
    public double getM() {
        return m;
    }
    public void setM(double m) {
        this.m = m;
    }


}
