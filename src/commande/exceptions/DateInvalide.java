package commande.exceptions;
import commande.Date;

public class DateInvalide extends RuntimeException{
    Date date;

    public DateInvalide(Date date){
        super("Date invalide. Date fournie : "+date);
        this.date=date;
    }
}
