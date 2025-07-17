package fakeData;

import java.util.Calendar;
import java.util.Random;

public class Topic_01_Random {
    public static void main(String[] args) {
        Random rand = new Random();
        System.out.println(rand.nextFloat());
        System.out.println(rand.nextLong());
        System.out.println(rand.nextInt(999));
        //Email random:
        System.out.println("phuong"+getRandomNumberByDateTime()+"@automationtest.vn");
        // Không muốn trùng thì kết hợp ngay, giờ, phút giây
    }


    public static int getRandomNumber() {
        int uLimit = 999;
        int lLimit = 100;
        Random rand = new Random();
        return lLimit + rand.nextInt(uLimit - lLimit);
    }

    public static int getRandomNumber(int minimum, int maximum) {
        Random rand = new Random();
        return minimum + rand.nextInt(maximum - minimum);
    }

    public static String getRandomEmail() {
        return "automation" + getRandomNumberByDateTime() + "@live.com";
    }

    // Get random number by date time minute second (no duplicate)
    public static long getRandomNumberByDateTime() {
        return Calendar.getInstance().getTimeInMillis() % 100000;
    }
}
