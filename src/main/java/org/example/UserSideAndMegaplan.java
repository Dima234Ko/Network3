package org.example;

public class UserSideAndMegaplan {

    String dns;
    public String externalTag(String City, String QNQVlan) {
        if (City.equals("Западная Якутия"))
            return "Якутия";
        else if (City.equals("Костромская область"))
            return "";
        else
            return QNQVlan;
    }

    public void printVlanUS(String NewIP, String QNQVlan, String NewVlan, String City, String description, String speed) {
        System.out.println("Vlan ID: " + NewVlan + "\n" +
                "Имя: " + description + "\n" +
                "Tag: " + NewVlan + "\n" +
                "Внешний Tag: " + externalTag(City, QNQVlan) + "\n" +
                "Сеть (IP/ mask): " + NewIP + "/24" + "\n" +
                "Скорость: " + speed + "Мбит/с");
    }

    public String getGW(String NewIP){
        int index = NewIP.lastIndexOf(".");
        return NewIP.substring(0, index) + ".1";
    }

    public void printMegaplan(String NewIP, String QNQVlan, String NewVlan, String City, String description, String speed) {

        if (!(QNQVlan == null)) {
            QNQVlan = "QNQ Vlan: " + externalTag(City, QNQVlan) + "\n";
        } else
            QNQVlan = "";

        if (City.equals("Западная Якутия")) {
            dns = "DNS1: 5.149.205.20\n" +
                    "DNS2: 5.149.204.20";
        } else
            dns = "DNS1: 109.236.208.14\n" +
                    "DNS2: 109.236.209.14";

        System.out.println("Имя: " + description + "\n" +
                "Vlan ID: " + NewVlan + "\n" +
                QNQVlan +
                "Заказанная скорость канала:  " + speed + "Мбит/с" + "\n" +
                "Настройки интернета:" + "\n" +
                "IP: " + NewIP + "\n" +
                "MASK: 255.255.255.0" + "\n" +
                "GW: " + getGW(NewIP) + "\n" + dns);
    }
}
