package level2.hey.i.already.did.that;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static int solution(String n, int b) {
        //Your code here

        List<String> minionIdList = new ArrayList<>();

        while (!minionIdList.contains(n)) {
            minionIdList.add(n);
            n = getNextMinionId(n, b);
        }

        return minionIdList.size() - minionIdList.indexOf(n);
    }

    private static String getNextMinionId(String n, int b) {

        char[] charArray = n.toCharArray();
        Arrays.sort(charArray);
        String ascString = new String(charArray);
        String descString = new StringBuilder().append(ascString).reverse().toString();

        int x = Integer.parseInt(descString, b);
        int y = Integer.parseInt(ascString, b);
        int k = n.length();

        String z = Integer.toString(x - y, b);
        String format = String.format("%%%ds", k);
        z = String.format(format, z).replace(' ', '0');

        return z;
    }
}
