package commande;
import commande.Date;

/** Classe InvalideDate, permettant de vérifier si une date est correcte et renvoyant un message dans la console
 * @see Date
 * */
public class InvalideDate extends RuntimeException{
    Date date;

    public InvalideDate(Date date){
        super("Date invalide. Date fournie : "+date);
        this.date=date;
    }
}
