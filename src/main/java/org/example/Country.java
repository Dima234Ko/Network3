package org.example;

public enum Country {

    Мантурово("1026"),
    Нерехта("1042"),
    Макарьев("1028"),
    Вохма("1036"),
    Поназырево("1039"),
    Галич("1023"),
    Солигалич("1032"),
    Межа ("1034"),
    Шарья("1025"),
    Павино("1037"),
    Кологрив("1033");

    private final String vlan;
    Country(String vlan) {
        this.vlan = vlan;
    }

    public String getVlan() {
        return vlan;
    }

}
