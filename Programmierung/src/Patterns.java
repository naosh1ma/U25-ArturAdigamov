public class Patterns {
    public static void main(String[] args) {


        for (int i = 0; i < 5; i++) {
            // 1) System.out.print("* ");
            // 2) System.out.println("*");
            // 4)
            System.out.print("* ");
            for (int j = 0; j < i; j++) {
                // 3)
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();

        // 5 )
        for (int i = 0; i < 5; i++) {

            for (int j = 4; j > i; j--) {

                System.out.print(" ");
            }
            for (int k = 0; k <= i; k++) {

                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();

        // 6 )
        for (int i = 0; i < 6; i++) {

            for (int j = 5; j > i; j--) {

                System.out.print(" ");
            }
            for (int k = 0; k <= i * 2; k++) {

                System.out.print("*");
            }

            System.out.println();
        }
        System.out.println();

        //  7 )
        for (int i = 0; i < 6; i++) {

            for (int j = 0; j < 5; j++) {

                if (i == 0 || j == 0 || i == 5 || j == 4) {
                    System.out.print("*  ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println("");
        }
        System.out.println();

        // 8 )
        int a = 0;

        for (int i = 0; i < 4; i++) {

            a++;

            for (int j = 5; j > i; j--) {

                System.out.print(" ");
            }
            for (int k = 0; k <= i; k++) {

                System.out.print(a + " ");

            }

            System.out.println();
        }
        System.out.println();

        // 10 )
        for (int i = 3; i >= 0; i--) {

            int b = 1;
            System.out.print(b + " ");

            for (int j = 0; j < i; j++) {
                b++;
                System.out.print(b + " ");
            }
            System.out.println();
        }
        System.out.println();

        // 11 )
        int c = 1;

        for (int i = 1; i < 5; i++) {

            for (int j = 0; j < i; j++) {

                System.out.print(c + " ");
                c++;

            }
            System.out.println();
        }
        System.out.println();

        // 12 )
        char d = 'A';

        for (int i = 1; i < 6; i++) {

            for (int j = 0; j < i; j++) {

                System.out.print(d + " ");


            }
            d++;
            System.out.println();
        }
        System.out.println();

        // 13 )
        for (int i = 1; i <= 4; i++) {

            for (int j = 1; j <= i; j++) {

                if ((i + j) % 2 == 0) {
                    System.out.print(1 + " ");
                } else {
                    System.out.print(0 + " ");
                }
            }
            System.out.println();
        }
        System.out.println();

        // 14 )
        for (int i = 0; i < 6; i++) {

            for (int j = 5; j > i; j--) {

                System.out.print(" ");
            }
            for (int k = i; k >= 1; k--) {

                System.out.print(k);
            }
            for (int k = 2; k <= i; k++) {

                System.out.print(k);
            }
            System.out.println();
        }
        System.out.println();

        // 15 )
        for (int i = 0; i < 4; i++) {

            for (int j = 5; j > i; j--) {

                System.out.print(" ");
            }
            for (int k = 0; k <= i; k++) {

                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = 4; i >= 1; i--) {

            for (int j = 0; j <= 6 - i; j++) {

                System.out.print(" ");
            }
            for (int k = 1; k <= i - 1; k++) {

                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();

        // 16 )
        for (int i = 5; i >= 0; i--) {

            System.out.print(" ");

            for (int j = 0; j < i; j++) {

                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();

        // 17 )
        char e = 'B';
        System.out.println("            A");

        for (int i = 0; i < 4; i++) {

            for (int j = 5; j > i; j--) {

                System.out.print("  ");
            }
            System.out.print("" + e);

            for (int k = 0; k <= i * 2; k++) {

                System.out.print(" *");
            }
            System.out.print(" " + e);

            System.out.println();
            e++;
        }
        System.out.println();

        // 18 )
        for (int i = 0; i <= 4; i++) {

            for (int j = i; j < 4; j++) {

                System.out.print("  ");
            }
            for (int k = 0; k <= i * 2; k++) {

                if (k == 0 || i == 4 || k == i * 2) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println();

        // 19 )
        for (int i = 1; i < 4; i++) {

            for (int j = 0; j < i; j++) {

                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = 2; i < 4; i++) {

            for (int j = 4; j > i; j--) {

                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();

        // 20 )
        for (int i = 3; i >= 0; i--) {

            for (int j = 0; j <= i; j++) {

                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = 2; i <= 4; i++) {

            for (int j = 1; j <= i; j++) {

                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();

        // 23 )
        for (int i = 6; i >= 1; i--) {

            for (int j = 0; j <= 6 - i; j++) {

                System.out.print(" ");
            }
            for (int k = 1; k <= i - 1; k++) {

                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();

        // 22)
        for (int i = 3; i >= -3; i--) {

            for (int j = 0; j <= i; j++) {

                System.out.print("* ");

                if (i == 0 && j == 0) {

                    System.out.println();
                }
            }
            for (int j = 1; j > i; j--) {

                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
