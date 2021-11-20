package ui;

import commande.Generable;

public interface Reader{
    Generable readXml(String name);
}
