package fakeData;


import net.datafaker.Faker;

import java.util.Locale;

public class Topic_02_Faker {
    public static void main(String[] args) {
        Faker fakeUS = new Faker();
        System.out.println(fakeUS.address().city());
        System.out.println(fakeUS.address().cityName());
        System.out.println(fakeUS.address().country());
        System.out.println(fakeUS.address().countryCode());
        System.out.println(fakeUS.address().state());
        System.out.println(fakeUS.address().longitude());
        System.out.println(fakeUS.address().latitude());
        System.out.println(fakeUS.address().fullAddress());
        System.out.println(fakeUS.internet().emailAddress());


        Faker fakeVN = new Faker(new Locale("vi-VN"));

        System.out.println(fakeVN.address().city());
        System.out.println(fakeVN.address().cityName());
        System.out.println(fakeVN.address().country());
        System.out.println(fakeVN.address().countryCode());
        System.out.println(fakeVN.address().state());
        System.out.println(fakeVN.address().longitude());
        System.out.println(fakeVN.address().latitude());
        System.out.println(fakeVN.address().fullAddress());



    }
}
