import commande.BonDeCommande;
import ui.XmlRead;


class Main{
    public static void main(String[] args){
        //System.out.println("Test");
        XmlRead Test = new XmlRead();

        System.out.println(Test.jour);
        System.out.println(Test.mois);
        System.out.println(Test.annee);
        System.out.println(Test.prix);
    }
}