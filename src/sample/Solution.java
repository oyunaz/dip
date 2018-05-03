package sample;

import com.maplesoft.externalcall.MapleException;
import com.maplesoft.openmaple.Engine;
import com.maplesoft.openmaple.EngineCallBacksDefault;

public class Solution {


    public String getSolution(String function){
        String a[];

        Engine t;

        int i;

        a = new String[1];

        a[0] = "java";

        try {
            t = new Engine(a, new EngineCallBacksDefault(), null, null);

            String solution;
            String mapleFunction = "(diff(" + function + ",x));";
            solution = t.evaluate(mapleFunction).toString();
            return solution;

        } catch (MapleException e) {
            System.out.println("An exception occurred\n");
            e.printStackTrace();
            return "null";
        }

    }
}
