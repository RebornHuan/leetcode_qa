package my.skypiea.punygod.LCS;

import java.util.Stack;

/**
 * Created by wanghuan on 16/11/14.
 */
public class longestCommonSubsequence {
    static int[][] martix;


    public static void main(String[] args) {
        String strA = "wanghuan";
        String strB = "maxiaoning";
        int lengthA = strA.length();
        int lengthB = strB.length();
        martix = new int[lengthA][lengthB];

        LCS(strA, strB);

        System.out.println("最长子序列:" + martix[lengthA - 1][lengthB - 1]);


        System.out.print("        ");
        for (int y = 0; y < lengthB; y++) {
            System.out.print(strB.charAt(y) + "       ");
        }

        System.out.println();
        System.out.println();
        for (int x = 0; x < lengthA; x++) {

            System.out.print(strA.charAt(x));
            for (int y = 0; y < lengthB; y++) {
                System.out.print("       " + martix[x][y]);
            }
            System.out.println();
        }

        Stack<String> stack = new Stack<>();
        SubSequence(lengthA-1,lengthB-1,stack,strA,strB);

        System.out.println();
        System.out.println();

        while (!stack.empty()) {
            System.out.print(stack.pop()+" ---> ");
        }

        System.out.print("end");


    }


    static void LCS(String strA, String strB) {
        for (int i = 0; i < strA.length(); i++) {
            martix[i][0] = 0;
        }

        for (int j = 0; j < strB.length(); j++) {
            martix[0][j] = 0;
        }
        for (int a = 1; a < strA.length(); a++) {
            for (int b = 1; b < strB.length(); b++) {
                if (strA.charAt(a) == strB.charAt(b)) {
                    martix[a][b] = martix[a - 1][b - 1] + 1;
                } else {
                    martix[a][b] = Math.max(martix[a - 1][b], martix[a][b - 1]);
                }

            }

        }
    }

    static void SubSequence(int lengthA, int lengthB, Stack<String> stack,String strA,String strB) {
        if(lengthA==0 || lengthB==0) return;
        if (strA.charAt(lengthA) == strB.charAt(lengthB)) {
            stack.push(strA.charAt(lengthA) + "");
            SubSequence(lengthA-1, lengthB-1, stack,strA,strB);
        }else {
            if(martix[lengthA - 1][lengthB] >= martix[lengthA][lengthB - 1]){
                SubSequence(lengthA-1, lengthB, stack,strA,strB);
            }else {
                SubSequence(lengthA, lengthB-1, stack,strA,strB);
            }

        }



    }


}
