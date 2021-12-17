package commande;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Classe Algo, permettant de réaliser la découpe des planches  de chaque Client pour tous les panneaux disponibles chez les fournisseurs
 *  Chaque algorithme renvoie une liste de découpe de la classe Dcoupe
 *  @see Dcoupe
 */

class Algo{
    ArrayList<Dcoupe> listDcoupe;



    Algo(int type,ArrayList <Generable> listC, ArrayList<Generable> listF,ArrayList<Generable> listD){
        if (type==1){
            Etape1(listC,listF,listD);
        }
        if (type==2){
            this.listDcoupe=Etape2( listC, listF);
        }
        if (type==3){
            this.listDcoupe=Etape3_1(listC, listF);
        }
        if (type==4){
            this.listDcoupe=Etape3_2(listC, listF);
        }
        //order_dcoupe(listDcoupe);
    }


    /** Méthode permettant d'afficher toutes les planches avec
     *  leur dimensions (Longueur 1ère ligne, largeur 2nde ligne)
     *  pour chaque client
     *  @param listClient : liste d'objets de classe Client
     *  @see Client
     */
    public static void print_list(ArrayList<Generable> listClient){
        Client c=(Client)listClient.get(0);
        ArrayList<Bois> b=c.bois;
        for (int j=0;j<listClient.size();j++) {
            b =(ArrayList<Bois>) ((Client)listClient.get(j)).bois;
            System.out.println("Client "+j);
            for (int i = 0; i < b.size(); i++) {
                System.out.print(b.get(i).dimensions.longueur + " ");
            }
            System.out.println(" ");
            for (int i = 0; i < b.size(); i++) {
                System.out.print(b.get(i).dimensions.largeur + " ");
            }
            System.out.println(" ");
        }
    }

    /** Méthode permettant de supprimer toutes les planches dont une des dimensions vaut 0
     *  @param listFournisseur : liste d'objets de classe Client
     *  @see Fournisseur
     */

    ArrayList<Generable> remove_fournisseur_zeros (ArrayList<Generable> listFournisseur) {
        Fournisseur c=(Fournisseur)listFournisseur.get(0);
        ArrayList<Bois> b=c.bois;
        ArrayList<Prix> p=c.prix;
        ArrayList<Date> d=c.date;
        for (int i = 0; i < listFournisseur.size(); i++) {

            p=(ArrayList<Prix>)((Fournisseur) listFournisseur.get(i)).prix;

            int k = 0;
            while (k < p.size()) {
                if (p.get(k).prix == 0 ) {
                    ((Fournisseur) listFournisseur.get(i)).bois.remove(k);
                    ((Fournisseur) listFournisseur.get(i)).prix.remove(k);
                    ((Fournisseur) listFournisseur.get(i)).nombreBois.remove(k);
                    ((Fournisseur) listFournisseur.get(i)).date.remove(k);
                    k--;
                }
                k++;
            }
            d=(ArrayList<Date>)((Fournisseur) listFournisseur.get(i)).date;
            k=0;
            while (k < p.size()) {
                if (d.get(k).jour == 0 ) {
                    ((Fournisseur) listFournisseur.get(i)).bois.remove(k);
                    ((Fournisseur) listFournisseur.get(i)).prix.remove(k);
                    ((Fournisseur) listFournisseur.get(i)).nombreBois.remove(k);
                    ((Fournisseur) listFournisseur.get(i)).date.remove(k);
                    k--;
                }
                k++;
            }
            b = (ArrayList<Bois>) ((Fournisseur) listFournisseur.get(i)).bois;
            k=0;
            while (k < b.size()) {
                if (b.get(k).dimensions.longueur == 0 ) {
                    b.remove(k);
                    ((Fournisseur) listFournisseur.get(i)).prix.remove(k);
                    ((Fournisseur) listFournisseur.get(i)).nombreBois.remove(k);
                    ((Fournisseur) listFournisseur.get(i)).date.remove(k);
                    k--;
                }
                k++;
            }
            ((Fournisseur) listFournisseur.get(i)).bois = b;
        }
        return listFournisseur;
    }

    /** Méthode permettant de supprimer toutes les planches dont une des dimensions vaut 0
     *  @param listClient : liste d'objets de classe Client
     *  @see Client
     */

    ArrayList<Generable> remove_client_zeros (ArrayList<Generable> listClient) {
        Client c=(Client)listClient.get(0);
        ArrayList<Bois> b=c.bois;
        ArrayList<Prix> p=c.prix;
        ArrayList<Date> d=c.date;
        for (int i = 0; i < listClient.size(); i++) {

            int k = 0;
            while (k < p.size()) {
                if (p.get(k).prix == 0 ) {
                    ((Client)listClient.get(i)).bois.remove(k);
                    ((Client)listClient.get(i)).prix.remove(k);
                    ((Client)listClient.get(i)).nombreBois.remove(k);
                    ((Client)listClient.get(i)).date.remove(k);
                    k--;
                }
                k++;
            }
            k=0;
            while (k < p.size()) {
                if (d.get(k).jour == 0 ) {
                    ((Client)listClient.get(i)).bois.remove(k);
                    ((Client)listClient.get(i)).prix.remove(k);
                    ((Client)listClient.get(i)).nombreBois.remove(k);
                    ((Client)listClient.get(i)).date.remove(k);
                    k--;
                }
                k++;
            }
            b = (ArrayList<Bois>) ((Client) listClient.get(i)).bois;
            k=0;
            while (k < b.size()) {
                if (b.get(k).dimensions.longueur <= 0) {
                    b.remove(k);
                    ((Client)listClient.get(i)).prix.remove(k);
                    ((Client)listClient.get(i)).nombreBois.remove(k);
                    ((Client)listClient.get(i)).date.remove(k);
                    k--;
                }
                k++;
            }
            ((Client) listClient.get(i)).bois = b;
        }
        return listClient;
    }

    /** Méthode permettant de ranger léxicographiquement les panneaux pour chaque client de listClient
     *  @param listClient : liste d'objets de classe Client
     *  @see Client
     */

    ArrayList<Generable> order_list_client(ArrayList<Generable> listClient){
        ArrayList<Bois> b;
        for (int i=0;i<listClient.size();i++){
            b =(ArrayList<Bois>) ((Client)listClient.get(i)).bois;
            for (int k=0;k<b.size();k++) {
                int cle=b.get(k).dimensions.longueur;
                int cle2=b.get(k).dimensions.largeur;
                Bois key=b.get(k);
                int j=k;
                while(j>0 && ((b.get(j-1).dimensions.longueur>cle) || ( b.get(j-1).dimensions.longueur==cle && b.get(j-1).dimensions.largeur>cle2))){
                    System.out.println(b.get(j-1).dimensions.longueur);
                    b.set(j,b.get(j-1));
                    j=j-1;
                    print_list(listClient);
                }
                b.set(j,key);
                print_list(listClient);
            }
            ((Client) listClient.get(i)).bois=b;
        }
        return listClient;
    }


    /**
     * Méthode réalisant la découpe pour l'étape 1
     *
     * @param listC : list d'objets de la classe Client
     * @param listF : list d'objets de la classe Fournisseur
     * @param listD : list d'objets de la classe Découpe
     */

    void Etape1 (ArrayList<Generable> listC, ArrayList<Generable>listF,ArrayList<Generable>listD){
        listC = remove_client_zeros(listC);
        listF = remove_fournisseur_zeros(listF);
        int i=0;
        int j=0;
        int ii=0;
        int jj=0;
        for (int k=0;k<listD.size();k++){
            System.out.println("nouvelle boucle");
            try {
                while (((Client) listC.get(j)).id != ((DecoupeXml) listD.get(k)).idClient && ((Fournisseur) listF.get(i)).id != ((DecoupeXml) listD.get(k)).idFournisseur) {
                    if (((Client) listC.get(j)).id != ((DecoupeXml) listD.get(k)).idClient) {
                        j++;
                    }
                    if (((Fournisseur) listF.get(i)).id != ((DecoupeXml) listD.get(k)).idFournisseur) {
                        i++;
                    }
                }
                while (((Client) listC.get(j)).bois.get(ii).id != ((DecoupeXml) listD.get(k)).idPlanche && ((Fournisseur) listF.get(i)).bois.get(jj).id != ((DecoupeXml) listD.get(k)).idPanneau) {
                    if (((Client) listC.get(j)).bois.get(ii).id != ((DecoupeXml) listD.get(k)).idPlanche) {
                        ii++;
                    }
                    if (((Fournisseur) listF.get(i)).bois.get(jj).id != ((DecoupeXml) listD.get(k)).idPanneau) {
                        jj++;
                    }
                    if (jj>=((Fournisseur) listF.get(i)).bois.size() || ii>=((Client) listC.get(j)).bois.size()){
                        throw new IllegalArgumentException("Les planches ou panneaux n'existent pas");
                    }
                }
                if (((Client) listC.get(j)).prix.get(ii).prix < ((Fournisseur) listF.get(i)).prix.get(jj).prix) {
                    System.out.println("Il y'a un problème vous allez perdre de l'argent !!!!");
                }
                if (((Client) listC.get(j)).bois.get(ii).dimensions.longueur + ((DecoupeXml) listD.get(k)).x > ((Fournisseur) listF.get(i)).bois.get(jj).dimensions.longueur || ((Client) listC.get(j)).bois.get(ii).dimensions.largeur + ((DecoupeXml) listD.get(k)).y > ((Fournisseur) listF.get(i)).bois.get(jj).dimensions.largeur && ((Client) listC.get(j)).bois.get(ii).dimensions.longueur + ((DecoupeXml) listD.get(k)).y > ((Fournisseur) listF.get(i)).bois.get(jj).dimensions.longueur || ((Client) listC.get(j)).bois.get(ii).dimensions.largeur + ((DecoupeXml) listD.get(k)).x > ((Fournisseur) listF.get(i)).bois.get(jj).dimensions.largeur) {
                    System.out.println("On dépasse du panneau !!!");
                }
                i = 0;
                j = 0;
                ii = 0;
                jj = 0;
            }
            catch(IllegalArgumentException e) {
                System.out.println("Les infos transmisent ne sont pas bonnes, au moins un des éléments n'existe pas !!");
            }
        }
    }
    public ArrayList<Dcoupe> Etape2 (ArrayList <Generable> listC, ArrayList<Generable> listF) {
        listC = remove_client_zeros(listC);
        listF = remove_fournisseur_zeros(listF);
        ArrayList<Dcoupe> listDcoupe = new ArrayList<>();
        ArrayList<Bois> b = ((Client)listC.get(0)).bois;
        int ind;
        int k=0;
        int stop_boucle=0;
        while (listC.size()>=1 && listF.size()>=1){
            ind=0;
            for (int i=0;i<((Client) listC.get(0)).nombreBois.get(0).nombre;i++){
                if (((Fournisseur) listF.get(k)).bois.get(ind).dimensions.longueur >= ((Client)listC.get(0)).bois.get(0).dimensions.longueur && ((Fournisseur) listF.get(k)).bois.get(ind).dimensions.largeur >= ((Client)listC.get(0)).bois.get(0).dimensions.largeur) {
                  if (((Fournisseur) listF.get(k)).nombreBois.get(ind).nombre>=1 && ((Client)listC.get(0)).nombreBois.get(0).nombre>=1 ){
                      Dcoupe Decoupe2Do = new Dcoupe(((Fournisseur) listF.get(k)).id, ((Fournisseur) listF.get(k)).bois.get(ind).id, ((Fournisseur) listF.get(k)).bois.get(ind).dimensions.largeur, ((Fournisseur) listF.get(k)).bois.get(ind).dimensions.longueur, ((Client) listC.get(0)).id, ((Client) listC.get(0)).bois.get(0).id, ((Client) listC.get(0)).bois.get(0).dimensions.largeur, ((Client) listC.get(0)).bois.get(0).dimensions.longueur, 0, 0);
                      listDcoupe.add(Decoupe2Do);
                      System.out.println("Ajouter a la découpe panneau id : "+((Fournisseur) listF.get(k)).bois.get(ind).id+" planche id : "+((Client) listC.get(0)).bois.get(0).id);
                      ((Fournisseur) listF.get(k)).nombreBois.get(ind).nombre--;
                      ((Client)listC.get(0)).nombreBois.get(0).nombre--;
                      if (((Fournisseur) listF.get(k)).nombreBois.get(ind).nombre == 0){
                          ((Fournisseur) listF.get(k)).nombreBois.remove(ind);
                          ((Fournisseur) listF.get(k)).bois.remove(ind);
                            stop_boucle =1;
                      }
                      if (((Client)listC.get(0)).nombreBois.get(0).nombre == 0){
                          ((Client)listC.get(0)).nombreBois.remove(0);
                          ((Client)listC.get(0)).bois.remove(0);
                          stop_boucle =1;
                      }
                      if (stop_boucle == 1){
                          System.out.println("je break");
                          stop_boucle=0;
                          break;
                      }
                  }
                }
                else {
                    ind++;
                }
                if (ind == ((Fournisseur) listF.get(k)).bois.size()){
                    ind=0;
                    k++;
                }
                if (k == listF.size()){
                    System.out.println(" il n'y a pas de panneau possible pour cette planche");
                    ((Client)listC.get(0)).nombreBois.remove(0);
                    ((Client)listC.get(0)).bois.remove(0);
                    k=0;
                }

            }
            if (((Client) listC.get(0)).nombreBois.size()==0){
                listC.remove(0);
            }
            if (((Fournisseur)listF.get(k)).nombreBois.size()==0){
                System.out.println("j enleve un fournisseur");
                listF.remove(k);
            }
            //ind++;
        }
        for (int j=0;j<listDcoupe.size();j++) {
            System.out.println("planche id " +listDcoupe.get(j).idPlanche+ " longueur planche "+listDcoupe.get(j).heightPlanche+" largeur "+listDcoupe.get(j).widthPlanche + " id panneau "+listDcoupe.get(j).idPanneau+" longueur panneau "+listDcoupe.get(j).heightPanneau+" largeur panneau "+listDcoupe.get(j).widthPanneau);
        }
        System.out.println(listDcoupe.size());
        this.listDcoupe=listDcoupe;
        return listDcoupe;
    }



    public ArrayList<Dcoupe> Etape3_1 (ArrayList <Generable> listC, ArrayList<Generable> listF) {
        listC = remove_client_zeros(listC);
        listF = remove_fournisseur_zeros(listF);
        ArrayList<Dcoupe> listDcoupe = new ArrayList<>();
        ArrayList<Bois> b = ((Client)listC.get(0)).bois;
        Bois bois;
        int ind;
        int k=0;
        int count=0;            //Position sur x sur le panneau
        int stop_boucle=0;
        System.out.println("-----------------------------------------------");

        while (listC.size()>=1 && listF.size()>=1){
            ind=0;
            for (int i=0;i<((Client) listC.get(0)).nombreBois.get(0).nombre;i++){
                System.out.println("longueur planche client " + (((Client)listC.get(0)).bois.get(0).dimensions.longueur+count) );
                System.out.println("longueur planche fournisseur " + ((Fournisseur) listF.get(k)).bois.get(ind).dimensions.longueur );
                if (((Fournisseur) listF.get(k)).bois.get(ind).dimensions.longueur >= ((Client)listC.get(0)).bois.get(0).dimensions.longueur+count && ((Fournisseur) listF.get(k)).bois.get(ind).dimensions.largeur >= ((Client)listC.get(0)).bois.get(0).dimensions.largeur) {
                    if (((Fournisseur) listF.get(k)).nombreBois.get(ind).nombre>=1 && ((Client)listC.get(0)).nombreBois.get(0).nombre>=1 ){
                        Dcoupe Decoupe2Do = new Dcoupe(((Fournisseur) listF.get(k)).id, ((Fournisseur) listF.get(k)).bois.get(ind).id, ((Fournisseur) listF.get(k)).bois.get(ind).dimensions.largeur, ((Fournisseur) listF.get(k)).bois.get(ind).dimensions.longueur, ((Client) listC.get(0)).id, ((Client) listC.get(0)).bois.get(0).id, ((Client) listC.get(0)).bois.get(0).dimensions.largeur, ((Client) listC.get(0)).bois.get(0).dimensions.longueur, count, 0);
                        listDcoupe.add(Decoupe2Do);
                        count=count+((Client) listC.get(0)).bois.get(0).dimensions.longueur;
                        System.out.println("Ajouter a la découpe panneau id : "+((Fournisseur) listF.get(k)).bois.get(ind).id+" planche id : "+((Client) listC.get(0)).bois.get(0).id);
                        ((Fournisseur) listF.get(k)).nombreBois.get(ind).nombre--;
                        ((Client)listC.get(0)).nombreBois.get(0).nombre--;
                        if (((Fournisseur) listF.get(k)).nombreBois.get(ind).nombre == 0){
                            ((Fournisseur) listF.get(k)).nombreBois.remove(ind);
                            ((Fournisseur) listF.get(k)).bois.remove(ind);
                            count=0;
                            stop_boucle =1;
                        }
                        if (((Client)listC.get(0)).nombreBois.get(0).nombre == 0){
                            ((Client)listC.get(0)).nombreBois.remove(0);
                            ((Client)listC.get(0)).bois.remove(0);
                            stop_boucle =1;
                        }
                        if (stop_boucle == 1){
                            System.out.println("je break");
                            stop_boucle=0;
                            break;
                        }
                    }
                }
                else{
                    ind++;
                    i--;
                    count=0;
                }
                if (ind == ((Fournisseur) listF.get(k)).bois.size()){
                    ind=0;
                    k++;
                }
                if (k == listF.size()){
                    System.out.println(" il n'y a pas de panneau possible pour cette planche");
                    ((Client)listC.get(0)).nombreBois.remove(0);
                    ((Client)listC.get(0)).bois.remove(0);
                    k=0;
                }
            }
            if (((Client) listC.get(0)).nombreBois.size()==0){
                listC.remove(0);
            }
            if (((Fournisseur)listF.get(k)).nombreBois.size()==0){
                System.out.println("j enleve un fournisseur");
                listF.remove(k);
            }
            //ind++;
        }
        for (int j=0;j<listDcoupe.size();j++) {
            System.out.println("planche id " +listDcoupe.get(j).idPlanche+ " longueur planche "+listDcoupe.get(j).heightPlanche+" largeur "+listDcoupe.get(j).widthPlanche + " id panneau "+listDcoupe.get(j).idPanneau+" longueur panneau "+listDcoupe.get(j).heightPanneau+" largeur panneau "+listDcoupe.get(j).widthPanneau+ "     x="+listDcoupe.get(j).x+"  y="+listDcoupe.get(j).y);
        }
        System.out.println(listDcoupe.size());
        this.listDcoupe=listDcoupe;
        return listDcoupe;
    }

    public ArrayList<Dcoupe> Etape3_2 (ArrayList <Generable> listC, ArrayList<Generable> listF) {
        listC = remove_client_zeros(listC);
        listF = remove_fournisseur_zeros(listF);
        ArrayList<Dcoupe> listDcoupe = new ArrayList<>();
        ArrayList<Bois> b = ((Client)listC.get(0)).bois;
        Bois bois;
        int ind;
        int k=0;
        int count=0;            //Position sur x sur le panneau
        int stop_boucle=0;
        int larg_act=0;         //Position actuelle sur y sur le panneau
        int larg_max=0;         //Position max sur y sur le panneau
        System.out.println("-----------------------------------------------");

        while (listC.size()>=1 && listF.size()>=1){
            ind=0;
            for (int i=0;i<((Client) listC.get(0)).nombreBois.get(0).nombre;i++){
                System.out.println("longueur planche client " + (((Client)listC.get(0)).bois.get(0).dimensions.longueur+count) );
                System.out.println("longueur planche fournisseur " + ((Fournisseur) listF.get(k)).bois.get(ind).dimensions.longueur );
                System.out.println("largeur planche client " + (((Client)listC.get(0)).bois.get(0).dimensions.largeur+larg_act) );
                System.out.println("largeur planche fournisseur " + ((Fournisseur) listF.get(k)).bois.get(ind).dimensions.largeur );
                if (((Fournisseur) listF.get(k)).bois.get(ind).dimensions.longueur >= ((Client)listC.get(0)).bois.get(0).dimensions.longueur+count && ((Fournisseur) listF.get(k)).bois.get(ind).dimensions.largeur >= ((Client)listC.get(0)).bois.get(0).dimensions.largeur+larg_act) {
                    if (((Fournisseur) listF.get(k)).nombreBois.get(ind).nombre>=1 && ((Client)listC.get(0)).nombreBois.get(0).nombre>=1 ){
                        Dcoupe Decoupe2Do = new Dcoupe(((Fournisseur) listF.get(k)).id, ((Fournisseur) listF.get(k)).bois.get(ind).id, ((Fournisseur) listF.get(k)).bois.get(ind).dimensions.largeur, ((Fournisseur) listF.get(k)).bois.get(ind).dimensions.longueur, ((Client) listC.get(0)).id, ((Client) listC.get(0)).bois.get(0).id, ((Client) listC.get(0)).bois.get(0).dimensions.largeur, ((Client) listC.get(0)).bois.get(0).dimensions.longueur, count, 0);
                        listDcoupe.add(Decoupe2Do);
                        count=count+((Client) listC.get(0)).bois.get(0).dimensions.longueur;
                        System.out.println("Ajouter a la découpe panneau id : "+((Fournisseur) listF.get(k)).bois.get(ind).id+" planche id : "+((Client) listC.get(0)).bois.get(0).id);
                        ((Fournisseur) listF.get(k)).nombreBois.get(ind).nombre--;
                        ((Client)listC.get(0)).nombreBois.get(0).nombre--;
                        if(((Client)listC.get(0)).bois.get(0).dimensions.largeur>larg_max){
                            larg_max=((Client)listC.get(0)).bois.get(0).dimensions.largeur;
                            System.out.println("larg_max "+larg_max);
                        }
                        if (((Fournisseur) listF.get(k)).nombreBois.get(ind).nombre == 0){
                            ((Fournisseur) listF.get(k)).nombreBois.remove(ind);
                            ((Fournisseur) listF.get(k)).bois.remove(ind);
                            larg_act=0;
                            larg_max=0;
                            count=0;
                            stop_boucle =1;
                        }
                        if (((Client)listC.get(0)).nombreBois.get(0).nombre == 0){
                            ((Client)listC.get(0)).nombreBois.remove(0);
                            ((Client)listC.get(0)).bois.remove(0);
                            stop_boucle =1;
                        }
                        if (stop_boucle == 1){
                            System.out.println("je break");
                            stop_boucle=0;
                            break;
                        }
                    }
                }

                else if(((Fournisseur) listF.get(k)).bois.get(ind).dimensions.longueur < ((Client)listC.get(0)).bois.get(0).dimensions.longueur+count && ((Fournisseur) listF.get(k)).bois.get(ind).dimensions.largeur >= ((Client)listC.get(0)).bois.get(0).dimensions.largeur+larg_act) {
                    count=0;
                    larg_act=larg_act+larg_max;
                    System.out.println("larg_act "+larg_act);
                    larg_max=0;
                }

                else{
                    ind++;
                    i--;
                    count=0;
                    larg_act=0;
                    larg_max=0;
                }
                if (ind == ((Fournisseur) listF.get(k)).bois.size()){
                    ind=0;
                    k++;
                }
                if (k == listF.size()){
                    System.out.println(" il n'y a pas de panneau possible pour cette planche");
                    ((Client)listC.get(0)).nombreBois.remove(0);
                    ((Client)listC.get(0)).bois.remove(0);
                    k=0;
                }
            }
            if (((Client) listC.get(0)).nombreBois.size()==0){
                listC.remove(0);
            }
            if (((Fournisseur)listF.get(k)).nombreBois.size()==0){
                System.out.println("j enleve un fournisseur");
                listF.remove(k);
            }
            //ind++;
        }
        for (int j=0;j<listDcoupe.size();j++) {
            System.out.println("planche id " +listDcoupe.get(j).idPlanche+ " longueur planche "+listDcoupe.get(j).heightPlanche+" largeur "+listDcoupe.get(j).widthPlanche + " id panneau "+listDcoupe.get(j).idPanneau+" longueur panneau "+listDcoupe.get(j).heightPanneau+" largeur panneau "+listDcoupe.get(j).widthPanneau+ "     x="+listDcoupe.get(j).x+"  y="+listDcoupe.get(j).y);
        }
        System.out.println(listDcoupe.size());
        this.listDcoupe=listDcoupe;
        return listDcoupe;
    }


    /*order_dcoupe(ArrayList<Dcoupe> listDcoupe){



    }


    /*public ArrayList<Integer> AlgoEtapeUne(ArrayList<Client> listClient, ArrayList<Fournisseur> listFournisseur){

    }*/
}