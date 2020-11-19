package champollion;

import java.util.*;







public class Enseignant extends Personne {

   private Set<ServicePrevu> servicesPrevus;
   private ArrayList<Intervention> InterventionsPlanifiees;
  
    public Enseignant(String nom, String email) {
        super(nom, email);
        
        servicesPrevus=new HashSet();
        InterventionsPlanifiees=new ArrayList();
    }

    public ArrayList<Intervention> getInterventionsPlanifiees(){
            return InterventionsPlanifiees;}

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant en "heures équivalent TD" Pour le calcul : 1 heure
     * de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure de TP vaut 0,75h
     * "équivalent TD"
     *
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevues() {
        float eqTP;
        float eqCM;
        float result1;
        result1=0f;

        for(ServicePrevu sp:servicesPrevus){
            eqTP=sp.getVolumeTP()*0.75f;
            eqCM=sp.getVolumeCM()*1.5f;
            result1= result1+eqTP+eqCM+sp.getVolumeTD();
            
            }
        int result=Math.round(result1);
        return result; }   

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant dans l'UE spécifiée en "heures équivalent TD" Pour
     * le calcul : 1 heure de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure
     * de TP vaut 0,75h "équivalent TD"
     *
     * @param ue l'UE concernée
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevuesPourUE(UE ue){
            float eqTP;
            float eqCM;
            float result1;
            result1=0f; 
            int result=0;
        for (ServicePrevu sp:servicesPrevus){
           if(ue.equals(sp.getUE())){
                eqTP=sp.getVolumeTP()*0.75f;
                eqCM=sp.getVolumeCM()*1.5f;
                result1= result1+eqTP+eqCM+sp.getVolumeTD();
                result=Math.round(result1);
                    
            }
       
        }
       return result;
    }

    /**
     * Ajoute un enseignement au service prévu pour cet enseignant
     *
     * @param ue l'UE concernée
     * @param volumeCM le volume d'heures de cours magitral
     * @param volumeTD le volume d'heures de TD
     * @param volumeTP le volume d'heures de TP
     */
    public void ajouteEnseignement(UE ue, int volumeCM, int volumeTD, int volumeTP) {
          
          ServicePrevu sp=new ServicePrevu(volumeCM,volumeTD,volumeTP,ue,this);
          servicesPrevus.add(sp);
    }
    
    public void ajouteIntervention(Intervention i){
        InterventionsPlanifiees.add(i);
     
    }

    public int heuresPlanifiees(){
          float result=0f;
           
          float eqTP=0f;
          float eqCM=0f;
          
          TypeIntervention CM=TypeIntervention.CM;
          TypeIntervention TP=TypeIntervention.TP;
          TypeIntervention TD=TypeIntervention.TD;
          for(Intervention i:InterventionsPlanifiees){
            if (CM.equals(i.getType())){
                eqCM=i.getDuree()*1.5f;
                result=result+eqCM; }
            if (TP.equals(i.getType())){
                eqTP=i.getDuree()*0.75f;
                result=result+eqTP; }
            if (TD.equals(i.getType())){
                result=result+i.getDuree();}
           }
        return Math.round(result);
    }

    
    public boolean enSousService(){
        int TotalHeure=heuresPrevues();
        if (TotalHeure>=192)
            return false;
        return true;
    }

}
