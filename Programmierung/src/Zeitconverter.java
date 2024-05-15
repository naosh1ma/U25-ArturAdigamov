public class Zeitconverter {
    public static void main(String[] args) {

        int jahr, mont, woch, tag, std, rest;
        int min, min_jahr, min_mont, min_woch, min_tag, min_std;

        min = 17402214;
        min_jahr = 365 * 24 * 60;
        min_mont = 30 * 24 * 60;
        min_woch = 7 * 24 * 60;
        min_tag = 24 * 60;
        min_std = 60;

        jahr = min / min_jahr;
        rest = min % min_jahr;

        mont = rest / min_mont;
        rest = rest % min_mont;

        woch = rest / min_woch;
        rest = rest % min_woch;

        tag = rest / min_tag;
        rest = rest % min_tag;

        std = rest / min_std;
        rest = rest % min_std;

        System.out.println(min + " Minuten sind: ");
        System.out.println(jahr + " Jahre, " + mont + " Monate, " + woch + " Wochen,");
        System.out.println(tag + " Tage, " + std + " Stunden" + rest + " Minuten");

    }
}
