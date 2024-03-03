package org.example;

import java.util.Scanner;

import static org.example.Main.*;

public class Cisco {

    String description;
    String speed;
    String loopback;
    String interfaceCisco;

    public String requestDescription () {
        System.out.println("Введите имя нового абонента");
        Scanner scanner = new Scanner(System.in);
        String Description = scanner.nextLine();
        return Description;
    }
    public String requestSpeed () {
        System.out.println("Введите значение скорости");
        Scanner scanner = new Scanner(System.in);
        String Description = scanner.nextLine();
        return Description;
    }
    public void printYesQNQ (String NewIP, String QNQVlan, String NewVlan, String Loopback) {

        System.out.println("interface " + interfaceCisco + "." + QNQVlan+NewVlan + "\n" +
                "description " + description + "\n" +
                "encapsulation dot1Q " + QNQVlan + " " + "second-dot1q " + NewVlan + "\n" +
                "ip unnumbered " + Loopback + "\n" +
                "no ip redirects" + "\n" +
                "no ip unreachables" + "\n" +
                "service-policy input " + speed + "M" + "\n" +
                "service-policy output " + speed + "M" + "\n" +
                "ip route " + NewIP + " " + "255.255.255.255 " + interfaceCisco +"." + QNQVlan+NewVlan);
    }
    public void printNoQNQ (String NewIP, String NewVlan, String loopback) {

        System.out.println("interface " + interfaceCisco + "." + NewVlan + "\n" +
                "description " + description + "\n" +
                "encapsulation dot1Q " + NewVlan + "\n" +
                "ip unnumbered " + loopback + "\n" +
                "no ip redirects" + "\n" +
                "no ip unreachables" + "\n" +
                "service-policy input " + speed + "M" + "\n" +
                "service-policy output " + speed + "M" + "\n" +
                "ip route " + NewIP + " " + "255.255.255.255 " + interfaceCisco +"." + NewVlan);
    }
    public String getLoopback(String City) {

        if (City.equals("Западная Якутия")) {
            loopback = "Loopback4619114";
        } else
            loopback = "Loopback109236223";

        return loopback;
    }
    public String getInterfaceCisco(String City){

        System.out.println("");

        if (City.equals("Западная Якутия")) {
            interfaceCisco = "TenGigabitEthernet0/0/0";
        } else
            interfaceCisco = "TenGigabitEthernet0/0/1";

        return interfaceCisco;
    }
    public void requestResult(String NewIP, String QNQVlan, String NewVlan, String City) {

        description = requestDescription();
        speed = requestSpeed();
        loopback = getLoopback(City);
        interfaceCisco = getInterfaceCisco(City);

        if (!(QNQVlan == null)) {
            printYesQNQ(NewIP, QNQVlan, NewVlan, loopback);
        } else
            printNoQNQ(NewIP, NewVlan, loopback);
    }
    public void fillInTheDetails(String NewIP, String QNQVlan, String NewVlan, String City){

        UserSideAndMegaplan US = new UserSideAndMegaplan();

        while (true) {

            System.out.println("Заполнить данные Vlan в UserSide?" + "\n" +
                    "1 - да" + "\n" + "2 - нет");
            Scanner scanner = new Scanner(System.in);
            String printVlan = scanner.nextLine();

            if (printVlan.equals("1")) {
                US.printVlanUS(NewIP, QNQVlan, NewVlan, City, description, speed);
                break;
            } else if (printVlan.equals("2")) {
                break;
            } else
                System.out.println("Введите верное значение");
            continue;
        }
        //Записать данные в US

        System.out.println("");

        while (true) {

            System.out.println("Заполнить данные в Megaplan?" + "\n" +
                    "1 - да" + "\n" + "2 - нет");
            Scanner scanner = new Scanner(System.in);
            String printVlan = scanner.nextLine();

            if (printVlan.equals("1")) {
                US.printMegaplan(NewIP, QNQVlan, NewVlan, City, description, speed);
                break;
            } else if (printVlan.equals("2")) {
                break;
            } else
                System.out.println("Введите верное значение");
            continue;
        }
        //Записать данные в Megaplan
    }
    //Записать данные с Cisco
}
