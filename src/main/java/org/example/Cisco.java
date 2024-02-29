package org.example;

import java.util.Scanner;

public class Cisco {

    String description;
    String speed;

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

    public void requestResult(String NewIP, String QNQVlan, String NewVlan) {

        description = requestDescription();
        speed = requestSpeed();

        System.out.println("interface TenGigabitEthernet0/0/1." + QNQVlan+NewVlan + "\n" +
                "description " + description + "\n" +
        "encapsulation dot1Q " + QNQVlan + " " + "second-dot1q " + NewVlan + "\n" +
        "ip unnumbered Loopback109236223" +"\n" +
                "no ip redirects" + "\n" +
                "no ip unreachables" + "\n" +
                "service-policy input " + speed + "M" + "\n" +
                "service-policy output " + speed + "M" + "\n" +
                "ip route " + NewIP + " " + "255.255.255.255 TenGigabitEthernet0/0/1." + QNQVlan+NewVlan);
    }

}
