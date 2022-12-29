
package enterprise.statics;

import java.util.Random;

public class Generator {

    public static int generateAccountNumber() {

        Random random = new Random();

        int max = 1_000_000_000;
        int min = 100_000_000;

        return random.nextInt(max - min) + min;
    }
}
