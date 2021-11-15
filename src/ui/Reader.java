package ui;

import commande.Generable;

public interface Reader{
    XmlRead newInstance();
    int getDay(XmlRead a);
    int getMonth(XmlRead a);
    int getYear(XmlRead a);
    int getCost(XmlRead a);
}
