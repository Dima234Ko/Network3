package org.example;

public enum Country {

    Мантурово("1111"),
    Шарья("2222"),
     Вохма("3333");


    private final String vlan;
    Country(String vlan) {
        this.vlan = vlan;
    }

    public String getVlan() {
        return vlan;
    }

}
