package commande;

import ui.Reader;
import ui.XmlRead;

class BonDeCommande implements Reader {
    public BonDeCommande(){
        XmlRead test =newInstance();
    }


    @Override
    public XmlRead newInstance() {
        return null;
    }

    @Override
    public int getDay(XmlRead a) {
        return 0;
    }

    @Override
    public int getMonth(XmlRead a) {
        return 0;
    }

    @Override
    public int getYear(XmlRead a) {
        return 0;
    }

    @Override
    public int getCost(XmlRead a) {
        return 0;
    }
}
