/*
 *
 */

package champollion;
import java.util.*;
/**
 *
 * 
 */
public class Intervention {
    private final Date debut;
    private int duree;
    private boolean annulee;
    private Enseignant intervenant;
    private Salle lieu;
    private TypeIntervention type;
    private UE matiere;

    public Intervention(Salle lieu,UE matiere,Enseignant intervenant,int duree,Date debut,TypeIntervention type){
        
        this.duree=duree;
        this.debut=debut;
        annulee=false;

        this.lieu=lieu;
        this.matiere=matiere;
        this.intervenant=intervenant;  
        this.type=type;
    }

    public Date getDebut(){
        return debut;}
     

    public int getDuree(){
        return duree;}

    public boolean getAnnulee(){
        return annulee;}
    
    public void setAnnulee(boolean b){
        annulee=b;}

    public Salle getLieu(){
        return lieu;}
     

    public Enseignant getIntervenant(){
        return intervenant;}

    public TypeIntervention getType(){
        return type;}


    
}
