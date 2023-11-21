package nba.stats.models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import nba.stats.models.Equipe;
@Entity
public class Equipe {
    int idEquipe ;
    String nomEquipe;
    String  abreviation;

    public static Equipe copyAndControle(Equipe Equipe) throws Exception{
        Equipe j = new Equipe();
        j.setNomEquipe(Equipe.getNomEquipe());
        return j;
    }
    public void update(Equipe equipe) throws Exception{
        setNomEquipe(equipe.getNomEquipe());
        setAbreviation(equipe.getAbreviation());
    }
    public int getIdEquipe() {
        return idEquipe;
    }
    public void setIdEquipe(int idEquipe) {
        this.idEquipe = idEquipe;
    }
    public String getNomEquipe() {
        return nomEquipe;
    }
    public void setNomEquipe(String nomEquipe)throws Exception {
        if(nomEquipe.length()==0){
            throw new Exception("Nom nom valide");
        }
        this.nomEquipe = nomEquipe;
    }
    public String getAbreviation() {
        return abreviation;
    }
    public void setAbreviation(String abreviation) throws Exception{
        if(abreviation.length()==0){
            throw new Exception("Abreviation nom valide");
        }
        this.abreviation = abreviation;
    }
}
