package com.example.sccl;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Calculate {
    /**
     * main function about calculating and get a result
     * @param formula
     * @return result or error
     */
    public static String getResult(String formula){
        try {
            List<String> num=transform(formula);
            Stack<Double> stack = new Stack<>();
            double result = 0;
            while (!num.isEmpty()) {
                String temp = String.valueOf(num.remove(0));
                if (isNumber(temp)) {
                    double s=Double.parseDouble(temp);
                    stack.push(s);
                } else {
                    double a=stack.pop();
                    double b=stack.pop();
                    double c=calculateTwo(b,a,temp);
                    stack.push(c);

                }
            }
            result=stack.pop();
            return Double.toString(result);
        } catch (Exception e){
            return "error";
        }

    }

    /**
     *calculate two numbers with given operation
     * @param a
     * @param b
     * @param operation
     * @return
     */
    private static Double calculateTwo(double a, double b, String operation){
        double res = 0;
        switch (operation){
            case "+":
                res = a+b;
                break;
            case "-":
                res = a-b;
                break;
            case "*":
                res = a*b;
                break;
            case "/":
                res = a/b;
                break;
        }
        return res;
    }



    /**
     * change Infix notation to postfix notation
     * @param notation
     * @return
     */
    public static List<String> transform(String notation){
        List<String> element = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        String[] strings = fixNotation(notation);

        for (int i = 0; i < strings.length; i++) {
            String s = strings[i].trim();
            if (isNumber(s)) {
                // output if s is number
                element.add(s);
            } else if (!s.isEmpty()) {
                if (s.charAt(0) == ')') {
                    while (stack.peek().charAt(0) != '(') {
                        element.add(stack.pop());
                    }
                    stack.pop();
                } else {
                    if (!stack.isEmpty() && !isMaxExp(s.charAt(0), stack.peek().charAt(0))) {
                        while (!stack.isEmpty() && !isMaxExp(s.charAt(0), stack.peek().charAt(0))) {
                            element.add(stack.pop());
                        }
                        stack.push(s);
                    } else {
                        stack.push(s);
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            element.add(stack.pop());
        }
        return element;
    }

    /**
     * fix the format of notation, including E, pi, sin, cos, tan, log, ln, lg, root, pow and negative
     * @param notation
     * @return
     */
    public static String[] fixNotation(String notation){
        String[] strings = notation.trim().split("_");
        for (int i=0; i<strings.length;i++){
            if (strings[i].equals("E")){
                strings[i] = String.valueOf(Math.E);
            } else if (strings[i].equals("pi")){
                strings[i] = String.valueOf(Math.PI);
            } else if (strings[i].equals("sin")){
                double ang = Math.toRadians(Double.parseDouble(strings[i+1]));
                strings[i] = String.valueOf(Math.sin(ang));
                strings[i+1] = " ";
                i++;
                continue;
            } else if (strings[i].equals("cos")) {
                double ang = Math.toRadians(Double.parseDouble(strings[i + 1]));
                strings[i] = String.valueOf(Math.cos(ang));
                strings[i + 1] = " ";
                i++;
                continue;
            } else if (strings[i].equals("tan")) {
                double ang = Math.toRadians(Double.parseDouble(strings[i + 1]));
                strings[i] = String.valueOf(Math.tan(ang));
                strings[i + 1] = " ";
                i++;
                continue;
            } else if (strings[i].equals("ln")) {
                double number = Double.parseDouble(strings[i+1]);
                strings[i] = String.valueOf(Math.log(number));
                strings[i + 1] = " ";
                i++;
                continue;
            } else if (strings[i].equals("log")) {
                double number = Double.parseDouble(strings[i + 1]);
                strings[i] = String.valueOf(Math.log(number) / Math.log(2));
                strings[i + 1] = " ";
                i++;
                continue;
            } else if (strings[i].equals("lg")) {
                double number = Double.parseDouble(strings[i + 1]);
                strings[i] = String.valueOf(Math.log(number)/Math.log(10));
                strings[i + 1] = " ";
                i++;
                continue;
            } else if (strings[i].equals("root")) {
                double number = Double.parseDouble(strings[i + 1]);
                strings[i] = String.valueOf(Math.sqrt(number));
                strings[i + 1] = " ";
                i++;
                continue;
            } else if (strings[i].equals("^")) {
                if (i!=0) {
                    double number1 = Double.parseDouble(strings[i - 1]);
                    double number2 = Double.parseDouble(strings[i + 1]);
                    strings[i] = String.valueOf(Math.pow(number1,number2));
                    strings[i - 1] = " ";
                    strings[i + 1] = " ";
                    i++;
                    continue;
                }
            } else if (strings[i].equals("Ne")) {
                    double number = Double.parseDouble(strings[i + 1]);
                    strings[i] = String.valueOf(0-number);
                    strings[i + 1] = " ";
                    i = i++;
                    continue;
            }
        }

        return strings;
    }

    /**
     * check the content of a String is number or not
     * @param string
     * @return
     */
    public static Boolean isNumber(String string){
        try {
            Double.parseDouble(string);

        } catch (RuntimeException e) {
            return false;
        }
        return true;
    }

    /**
     * check whether put into stack (i.e., "(" and ")")
     * @param char1
     * @param char2
     * @return
     */
    private static boolean isMaxExp(char char1, char char2){
        if (char1 == '(')
            return true;
        if (char2 == ')')
            return true;
        if (order(char1) > order(char2))
            return true;

        return false;
    }

    /**
     * get the execution order of operator
     * @param operator
     * @return
     */
    private static int order(char operator){
        int ord = 0;
        switch (operator){
            case '*':
            case '/':
                ord = 2;
                break;
            case '+':
            case '-':
                ord = 1;
                break;
        }
        return ord;
    }
}
