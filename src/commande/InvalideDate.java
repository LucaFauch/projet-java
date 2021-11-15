package commande;
import commande.Date;

public class InvalideDate extends RuntimeException{
    Date date;

    public InvalideDate(Date date){
        super("Date invalide. Date fournie : "+date);
        this.date=date;
    }
}
