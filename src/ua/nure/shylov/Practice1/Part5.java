package ua.nure.shylov.Practice1;

public class Part5 {

    private static final int BASE = 26;
    private static final int SHIFT = 64;

    public static void main(String[] args) {
        System.out.println(char2digits("A") + " A " + digits2chars(char2digits("A")));
        System.out.println(char2digits("B") + " B " + digits2chars(char2digits("B")));
        System.out.println(char2digits("Z") + " Z " + digits2chars(char2digits("Z")));
        System.out.println(char2digits("AA") + " AA " + digits2chars(char2digits("AA")));
        System.out.println(char2digits("AZ") + " AZ " + digits2chars(char2digits("AZ")));
        System.out.println(char2digits("BA") + " BA " + digits2chars(char2digits("BA")));
        System.out.println(char2digits("ZZ") + " ZZ " + digits2chars(char2digits("ZZ")));
        System.out.println(char2digits("AAA") + " AAA " + digits2chars(char2digits("AAA")));
    }

    public static int char2digits(String number) {
        StringBuilder sb = new StringBuilder(number);
        int result = 0;
        char[] chars = sb.reverse().toString().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            result = (int) (result + ((chars[i] - 64) * Math.pow(26, i)));
        }
        return result;
    }

    public static String digits2chars(int number) {
        StringBuilder sb = new StringBuilder();
        int modul;
        int divident = number;
        while (divident != 0) {
            modul = divident % 26;
            if (modul == 0) {
                sb.append("Z");
                divident = (divident - 1) / 26;
            } else {
                sb.append((char) (modul + 64));
                divident = (divident - modul) / 26;
            }
        }
        return sb.reverse().toString();
    }
}
