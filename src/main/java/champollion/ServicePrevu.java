package champollion;

public class ServicePrevu {

	private int volumeCM;
        private int volumeTD;
        private int volumeTP;
        private final UE ue;
        private final Enseignant e;
        /*
        *@throws les volumes horaires ne peuvent pas être négatifs

        */
        public ServicePrevu(int volumeCM,int volumeTD,int volumeTP,UE ue,Enseignant e) {
                if (volumeCM<0)
                    throw new IllegalArgumentException("Le volume CM ne peut pas être négatif") ;
                if (volumeTD<0)
                    throw new IllegalArgumentException("Le volume TD ne peut pas être négatif");
                if (volumeTP<0)
                    throw new IllegalArgumentException("Le volume TP ne peut pas être négatif");

                this.volumeCM=volumeCM;
                this.volumeTP=volumeTP;
                this.volumeTD=volumeTD;
                this.ue=ue;
                this.e=e;
                }
        
        public int getVolumeCM(){
                return volumeCM;}

        public int getVolumeTD(){
                return volumeTD;}

        public int getVolumeTP(){
                return volumeTP;}

        public Enseignant getEnseignant(){
                return e;}

        public UE getUE(){
                return ue;}
}
