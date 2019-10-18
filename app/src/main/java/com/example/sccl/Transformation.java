package com.example.sccl;

public class Transformation {
    /**
     * \
     * @param function
     * @return
     */
    public static String AssignNumber(String function) {
        Boolean X = false;
        Boolean Y = false;
        for (int i = 0; i < function.length(); i++) {
            if (function.charAt(i) == 'X') {
                X = true;
            }
            if (function.charAt(i) == 'Y') {
                Y = true;
            }
        }
        if (!X && !Y) {
            return "ERROR!!!";
        }
        if (X && !Y) {
            return "input X";
        }
        if (!X && Y) {
            return "input Y";
        }
        if (X && Y) {
            return "input X,Y";
        }
        return "ERROR!!!";
    }

    public static String assignX(String function, double num) {
        try{
            String newf = "";
            for (int i = 0; i < function.length(); i++) {
                if (function.charAt(i) != 'X') {
                    newf += function.charAt(i);
                } else newf += num;

            }
            return newf;
        }catch (Exception e){
            return "ERROR: Illegal formatX";
        }



    }

    public static String assignY(String function, double y) {
        try{
            String newf = "";
            for (int i = 0; i < function.length(); i++) {
                if (function.charAt(i) != 'Y') {
                    newf += function.charAt(i);
                } else newf += y;

            }
            return newf;
        }catch (Exception e){
            return "ERROR: Illegal formatY";
        }




    }

    public static String assignXY(String function, double x, double y) {
        try{
            String newf = "";
            for (int i = 0; i < function.length(); i++) {
                if (function.charAt(i) == 'X') {
                    newf += x;
                } else if (function.charAt(i) == 'Y') {
                    newf += y;
                } else newf += function.charAt(i);

            }
            return newf;
        }catch (Exception e){
            return "ERROR:Illegal format XY";
        }
    }

    public static String transfer(String input) {
        String innerFuction = "";
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '×') {
                innerFuction += "_*_";
            } else if (input.charAt(i) == '÷') {
                innerFuction += "_/_";
            } else if (input.charAt(i) == '－') {
                innerFuction += "_-_";
            } else if (input.charAt(i) == '+') {
                innerFuction += "_+_";
            } else if (input.charAt(i) == '-') {
                innerFuction += "_Ne_";
            } else if (input.charAt(i) == 'π') {
                innerFuction += "_pi_";//
            } else if (input.charAt(i) == 'e') {
                innerFuction += "_E_";
            } else if (input.charAt(i) == '(') {
                innerFuction += "_(_";
            } else if (input.charAt(i) == ')') {
                innerFuction += "_)_";
            } else if (input.charAt(i) == '√') {
                innerFuction += "_root_";
            } else if (input.charAt(i) == 's' && input.charAt(i + 1) == 'i' && input.charAt(i + 2) == 'n') {
                innerFuction += "_sin_";
                i = i + 2;
                continue;
            } else if (input.charAt(i) == 'c' && input.charAt(i + 1) == 'o' && input.charAt(i + 2) == 's') {
                innerFuction += "_cos_";
                i = i + 2;
                continue;
            } else if (input.charAt(i) == 't' && input.charAt(i + 1) == 'a' && input.charAt(i + 2) == 'n') {
                innerFuction += "_tan_";
                i = i + 2;
                continue;
            } else if (input.charAt(i) == '^') {
                innerFuction += "_^_";


            } else if (input.charAt(i) == 'l' && input.charAt(i + 1) == 'g' ) {
                innerFuction += "_lg_";
                i = i + 1;
                continue;
            } else if (input.charAt(i) == 'l' && input.charAt(i + 1) == 'n') {
                innerFuction += "_ln_";
                i = i + 1;
                continue;
            } else innerFuction += input.charAt(i);
        }
        return innerFuction;
    }
}
