import java.util.*;

public class Utils {
    public static String generateAccountNumber() {
        Random rand = new Random();
        return "CB" + (100000 + rand.nextInt(900000));
    }
}