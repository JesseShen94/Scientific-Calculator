package com.example.sccl;

public class Transformation {
    /**
     * Determing the number of variables contained in the input function
     * @param function
     * @return "ERROR!!!" if there is no X or Y in the function
     * @return "input X"  if there is only X in the function
     * @return "input Y" if there is only Y in the function
     * @return "input X,Y " if there are both X and Y in the function
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

    /**
     * Replace all the X characters in function with the String form of num
     * @param function
     * @param num
     * @return replaced formula without X
     */
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

    /**
     * Replace all the Y characters in function with the String form of y
     * @param function
     * @param y
     * @return replaced formula without Y
     */
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
    /**
     * Replace all the X and Y characters in function with the String form of x, y
     * @param function
     * @param x
     * @param y
     * @return replaced formula without X Y
     */

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

    /**
     * Convert input to postfix expression according to established rules
     * The rules:
     * '×'-->'_*_'
     * '÷'-->'_/_'
     * '－'-->'_－_'
     * '+'-->'_+_'
     * 'π'-->'_pi_'
     * 'e'-->'_E_'
     * '('-->'_(_'
     * ')'-->'_)_'
     * '√'-->'_root_'
     * 'sin'-->'_sin_'
     * 'cos'-->'_cos_'
     * 'tan'-->'_tan_'
     * '^'-->'_^_'
     * 'lg'-->'_lg_'
     * 'ln'-->'_ln_'
     * @param input
     * @return rearranged formula.
     */
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
