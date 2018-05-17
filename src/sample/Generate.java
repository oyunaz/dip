package sample;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Generate {
    static final Map table = new HashMap<Integer, String>();

    static {

        table.put(0, "C");
        table.put(1, "x^C");
        table.put(2, "C^x");
        table.put(3, "e^x");
        table.put(4, "ln(x)");
        table.put(5, "sin(x)");
        table.put(6, "cos(x)");
        table.put(7, "sqrt(x)");
        table.put(8, "tg(x)");
        table.put(9, "ctg(x)");
        table.put(10, "arcsin(x)");
        table.put(11, "arccos(x)");
        table.put(12, "arctg(x)");
        table.put(13, "arcctg(x)");
        table.put(14, "sh(x)");
        table.put(15, "ch(x)");

    }

    public String generateSum() {
        Random random = new Random();
        int n = 2 + random.nextInt(4);                    //кол-во слагаемых
        String func;
        String function = "";
        int i;
        for (i = 0; i <= n; i++) {
            int m = 0;
            m += random.nextInt(16);                 // номер в таблице
            func = table.get(m).toString();

            if (func.contains("C")) {
                int l = random.nextInt(100);
                func = func.replace("C", String.valueOf(l));  //замена С
            }

            boolean signBool = random.nextBoolean();        //генерация знака
            String sign;

            if (signBool)
                sign = "+";
            else
                sign = "-";

            if (i == n) {
                func += "";
            } else {
                func += sign;
            }
            function += func;
        }
        return function;
    }

    public String generateMultiply() {
        Random random = new Random();
        int n = 2 + random.nextInt(4);                    //кол-во слагаемых
        String func;
        String function = "";
        int i;
        for (i = 0; i <= n; i++) {
            int m = 0;
            m += random.nextInt(16);                 // номер в таблице
            func = table.get(m).toString();

            if (func.contains("C")) {
                int l = random.nextInt(100);
                func = func.replace("C", String.valueOf(l));  //замена С
            }

            String sign = "*";

            if (i == n) {
                func += "";
            } else {
                func += sign;
            }
            function += func;
        }
        return function;

    }

    private String generate(){
        Random random = new Random();
        int n = 1 + random.nextInt(3);                    //кол-во слагаемых
        String func;
        String function1 = "";
        int i;
        for (i = 0; i <= n; i++) {
            int m = 0;
            m += random.nextInt(16);                 // номер в таблице
            func = table.get(m).toString();                 //NullPointerException

            if (func.contains("C")) {
                int l = random.nextInt(100);
                func = func.replace("C", String.valueOf(l));  //замена С
            }

            String sign = "";

            int s = 0;
            s += random.nextInt(3);         // генерация знака

            switch (s) {
                case 0:
                    sign = "+";
                    break;
                case 1:
                    sign = "-";
                    break;
                case 2:
                    sign = "*";
                    break;

            }
            if (i == n) {
                func += "";
            } else {
                func += sign;
            }
            function1 += func;
        }
        return function1;
    }

    public String generateDivision() {

        String function1 = generate();
        String function2 = generate();

        String function = "(" + function1 + ")" + "/" + "(" + function2 + ")";

        return function;
    }

    public String generateComplex(){
        Random random = new Random();
        int n = 1 + random.nextInt(16);
        int m = 1 + random.nextInt(16);
        String func1 = table.get(n).toString();
        String func2 = table.get(m).toString();
        String function = "";
        if(func1.contains("x")){
            function =  func1.replace("x", func2);
            if (function.contains("C")) {
                int l = random.nextInt(100);
                function = function.replace("C", String.valueOf(l));  //замена С
            }
        }
        return function;
    }
}
