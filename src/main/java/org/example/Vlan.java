package org.example;

import org.apache.poi.ss.usermodel.Workbook;

public class Vlan {

public String getNewVlan (String Vlan) {

    int NewVlan = Integer.parseInt(Vlan) + 1;
    Vlan = Integer.toString(NewVlan);
    return Vlan;

}
}
