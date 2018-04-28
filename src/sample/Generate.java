package sample;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Generate {
    static final Map table = new HashMap<Integer, String>();

    static {

        table.put(1, "c");
        table.put(2, "x^n");
        table.put(3, "c^x");
        table.put(4, "e^x");
        table.put(5, "ln(x)");
        table.put(6, "sin(x)");
        table.put(7, "cos(x)");
        table.put(8, "sqrt(x)");
        table.put(9, "tg(x)");
        table.put(10, "ctg(x)");
        table.put(11, "arcsin(x)");
        table.put(12, "arccos(x)");
        table.put(13, "arctg(x)");
        table.put(14, "arcctg(x)");
        table.put(15, "sh(x)");
        table.put(16, "ch(x)");

    }

    public String generateSum() {
        Random random = new Random();
        int n = random.nextInt(2) + 3;                    //кол-во слагаемых
        String func;
        String function = "";
        int i;
        for (i = 0; i <= n; i++) {
            int m = 0;
            m += random.nextInt(17);                 // номер в таблице
            func = table.get(m).toString();

            boolean signBool = random.nextBoolean();        //генерация знака
            String sign;

            if (signBool)
                sign = "+";
            else
                sign = "-";

            if (i == n) {
                func += " )'=";
            } else {
                func += sign;
            }
            function += func;
        }
        return "f(x)' = " + "( " + function;
    }

}
