package org.example;

public class Vlan {

public String getVlan(String country) {



    switch (country) {
        case ("Мантурово"):
            System.out.println("Верно");

            break;
        default:
            System.out.println("Не верно");

            break;
    }

    return null;
}
}
