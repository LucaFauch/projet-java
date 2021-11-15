package ui;

public interface Reader{
    XmlRead XmlRead();
    int getDay(XmlRead a);
    int getMonth(XmlRead a);
    int getYear(XmlRead a);
    int getCost(XmlRead a);
}
