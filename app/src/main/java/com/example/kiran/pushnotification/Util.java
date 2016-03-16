package com.example.kiran.pushnotification;

import java.util.ArrayList;

/**
 * Created by Kiran on 14-03-2016.
 */
public class Util {
    public static String[] name = {"one", "two", "three", "four", "five", "six","seven","eight","Nine","ten","Eleven"};
    public static ArrayList<NameModel> getNames(){
        ArrayList<NameModel> arrNames = new ArrayList<NameModel>();
        for(int i=0; i<20; i++){
            NameModel nameModel = new NameModel();
            nameModel.name= "Name is: "+i;
            nameModel.isChecked = false;
            arrNames.add(nameModel);
        }
        return arrNames;
    }

}
