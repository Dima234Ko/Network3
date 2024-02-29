package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Polls {

    public String city;
    boolean QNQ;
    String NumberQNQ;
    String QNQVlan;

    public String getCity() {

        while (true) {

            city = getRegion();

            if (city.equals("Костромская область")) {
                QNQ = yesQNQ();
            } else
                break;

            if (QNQ) {

                System.out.println("Уточните населенный пункт из списка");
                System.out.println(Arrays.toString(Country.values()));
                Scanner scannerCountry = new Scanner(System.in);
                city = scannerCountry.nextLine();
                break;
            } else
                break;
        }
        return city;
    }

    public String getRegion() {

        while (true) {
            System.out.println("Выберите населенный пункт где нужно выделить интерфейс \n" +
                    "1 - Западная Якутия \n" +
                    "2 - Костромская область");
            Scanner scanner = new Scanner(System.in);
            city = scanner.nextLine();

            if (city.equals("1")) {
                city = "Западная Якутия";
                return city;
            } else if (city.equals("2")) {
                city = "Костромская область";
                return city;
            } else
                System.out.println("Введите верное значение");
            continue;
        }
    }

    public String getQnqVlan(String city) {

        switch (city) {
            case ("Мантурово"):
                QNQVlan = Country.Мантурово.getVlan();
                break;

            case ("Нерехта"):
                QNQVlan = Country.Нерехта.getVlan();
                break;

            case ("Макарьев"):
                QNQVlan = Country.Макарьев.getVlan();
                break;

            case ("Вохма"):
                QNQVlan = Country.Вохма.getVlan();
                break;

            case ("Поназырево"):
                QNQVlan = Country.Поназырево.getVlan();
                break;

            case ("Галич"):
                QNQVlan = Country.Галич.getVlan();
                break;

            case ("Солигалич"):
                QNQVlan = Country.Солигалич.getVlan();
                break;

            case ("Межа"):
                QNQVlan = Country.Межа.getVlan();
                break;

            case ("Шарья"):
                QNQVlan = Country.Шарья.getVlan();
                break;

            case ("Павино"):
                QNQVlan = Country.Павино.getVlan();
                break;

            case ("Кологрив"):
                QNQVlan = Country.Кологрив.getVlan();
                break;
            default:
                break;
        }


        return QNQVlan;

    }

    public  boolean yesQNQ() {

        boolean YesQNQ;

        while (true) {

            System.out.println("Уточните используется ли QNQ \n" +
                    "1 - да \n" +
                    "2 - нет");
            Scanner scannerQNQ = new Scanner(System.in);

            int Number = 0;

            try {Number = Integer.parseInt(scannerQNQ.nextLine());
            } catch (NumberFormatException e){
            }

            if (Number == 1) {
                YesQNQ = true;
                break;
            } else if (Number == 2) {
                YesQNQ = false;
                break;
            } else
                System.out.println("Введите верное значение");
            continue;
        }

        return YesQNQ;
    }
}
