package champollion;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
public class ChampollionJUnitTest {
	Enseignant untel;
	UE uml, java;
		
	@BeforeEach
	public void setUp() {
                
                
		untel = new Enseignant("untel", "untel@gmail.com");
		uml = new UE("UML");
		java = new UE("Programmation en java");	
                
	}
	

	@Test
	public void testNouvelEnseignantSansService() {
		assertEquals(0, untel.heuresPrevues(),
                        "Un nouvel enseignant doit avoir 0 heures prévues");
	}
	

	@Test
	public void testAjouteHeures() {
                // 10h TD pour UML
		untel.ajouteEnseignement(uml, 0, 10, 0);

		assertEquals(10, untel.heuresPrevuesPourUE(uml),
                        "L'enseignant doit maintenant avoir 10 heures prévues pour l'UE 'uml'");

                // 20h TD pour UML
                untel.ajouteEnseignement(uml, 0, 20, 0);
                
		assertEquals(10 + 20, untel.heuresPrevuesPourUE(uml),
                         "L'enseignant doit maintenant avoir 30 heures prévues pour l'UE 'uml'");		
		
	}
        
        @Test
        public void testAjoutIntervention(){
            Salle s=new Salle("B102",15);
            //On crée une intervention
            Date d=new Date();
            TypeIntervention type=TypeIntervention.TP;
            Intervention cours1=new Intervention(s,uml,untel,2,d,type);
            //On ajoute l'intervention
            untel.ajouteIntervention(cours1);
            //On récupère la liste
            ArrayList<Intervention> Liste=untel.getInterventionsPlanifiees();
            //On test l'ajout de l'intervention
            assertEquals(cours1,Liste.get(0),"L'intervention n'a pas été ajouté au planning");

        }
        
        @Test
        public void testEnSousServiceFalse(){
            untel.ajouteEnseignement(uml, 0, 193,0 );
            assertFalse(untel.enSousService());}

        
        @Test
        public void testEnSousServiceTrue(){
            untel.ajouteEnseignement(uml, 0, 191,0 );
            assertTrue(untel.enSousService());}

        @Test
        public void testPlanification(){
            Salle s=new Salle("B102",15);
            Date d=new Date();

            TypeIntervention type1=TypeIntervention.CM;
            Intervention cours1=new Intervention(s,uml,untel,4,d,type1);
            untel.ajouteIntervention(cours1);

          
            TypeIntervention type2=TypeIntervention.TD;
            Intervention cours2=new Intervention(s,uml,untel,3,d,type2);
            untel.ajouteIntervention(cours2);

         
            TypeIntervention type3=TypeIntervention.TP;
            Intervention cours3=new Intervention(s,uml,untel,2,d,type3);
            untel.ajouteIntervention(cours3);
            
            assertEquals(Math.round(2*0.75+3+4*1.5),untel.heuresPlanifiees(),"Le nombre d'heure planifié est incorrect");

}

	
}
