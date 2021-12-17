package commande;

import java.util.ArrayList;
import java.util.Arrays;

class Personne implements Validable{
    int id;
    ArrayList<Prix> prix;
    ArrayList<Bois> bois;
    ArrayList<NbBois> nombreBois;
    ArrayList<Date> date;


    /** Vérification d'erreur  sur l'id de la classe Personne
     * @see InvalideId
     * */
    public int isValid(){
        if(id<0){
            return 0;
        }else{
            return 1;
        }
    }

    /** Constructeur de la classe Personne, qui peut être un Client ou un Fournisseur
     * @param id l'id de la personne, doit être unique
     * @param prix la liste des objets de classe Prix de chaque planche/panneau
     * @param bois la liste des objets de classe Bois correspondant à chaque planche/panneau
     * @param nombreBois la liste des objets de classe NbBois correspondant au nombre de planche/panneau de la même taille
     * @param date la liste des objets de classe Date correspondant à chaque planche/panneau
     *
     * @throws InvalideId : si jamais l'id n'est pas correct
     * */
    Personne(int id, ArrayList<Prix> prix, ArrayList<Bois>  bois, ArrayList<NbBois> nombreBois, ArrayList<Date> date) throws InvalideId{
        this.id=id;
        this.prix=prix;
        this.bois=bois;
        this.nombreBois=nombreBois;
        this.date=date;
    }
    
}
