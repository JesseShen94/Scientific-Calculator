package com.example.sccl;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Calculate {

    /**
     * main function about calculating and get a result
     * @param formula a String including split flag "_"
     * @return result or error. the result is a string whose value is the result of formula
     */
    public static String getResult(String formula){
        try {
            List<String> num=transform(formula);
            Stack<Double> stack = new Stack<>();
            double result = 0;
            while (!num.isEmpty()) {
                String temp = String.valueOf(num.remove(0));
                //the fisrt Stirng of num is " ".

                //if is number, into stack; else, it must be a operator.
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
     * @param notation: a String notation
     * @return element: a list of String which is elements of notation and have been changed to postfix notation order
     * @reference: part of this function is reference from: https://blog.csdn.net/qq_39456707/article/details/82690892
     */
    public static List<String> transform(String notation){
        List<String> element = new ArrayList<>();
        Stack<String> stack = new Stack<>();

        //simplify the notation by replace "__" by "_"
        for (int i = 0;i<notation.trim().length();i++){
            if (notation.charAt(i) == '_'&&i!=notation.length()-1){
                if (notation.charAt(i+1)=='_'){
                    int l = notation.length();
                    notation = notation.substring(0,i+1)+notation.substring(i+2,l);
                    if (i!=0){
                        i--;
                    }
                }
            }
        }

        //replace all special function such as sin by its calculate result.
        String[] strings = fixNotation(notation);

        //change the infix notation form into postfix notation form
        //use stack to get the order and ensure the ")" must meet the closest "("
        for (int i = 0; i < strings.length; i++) {
            String s = strings[i].trim();
            if (isNumber(s)) {
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
     * if find special function, calculate it with number after it. if it's not a number, return error.
     * @param notation
     * @return
     */
    public static String[] fixNotation(String notation){
        String[] strings = notation.trim().split("_");
        for (int i =0;i<strings.length;i++){
        }
        for (int i=0; i<strings.length;i++){
            if (strings[i].equals("E")){
                strings[i] = String.valueOf(Math.E);
            } else if (strings[i].equals("pi")){
                strings[i] = String.valueOf(Math.PI);
            } else if (strings[i].equals("sin")){
                if (strings[i+1].equals("(")){
                    //calculate the number if after sin is a equation with ()
                    String[] substrings = new String[strings.length-i-1];
                    for (int j = 0;j<substrings.length;j++){
                        substrings[j] = strings[i+j+1];
                    }
                    substrings = CalInSpeical(substrings);
                    for (int k = 0;k<strings.length-1-i;k++){
                        strings[i+k+1] = substrings[k];
                    }
                }
                double ang = Math.toRadians(Double.parseDouble(strings[i+1]));
                strings[i] = String.valueOf(Math.sin(ang));
                strings[i+1] = " ";
                i++;
                continue;
            } else if (strings[i].equals("cos")) {
                if (strings[i+1].equals("(")){
                    String[] substrings = new String[strings.length-i-1];
                    for (int j = 0;j<strings.length-i-1;j++){
                        substrings[j] = strings[i+j+1];
                    }
                    substrings = CalInSpeical(substrings);
                    for (int k = 0;k<strings.length-1-i;k++){
                        strings[i+k+1] = substrings[k];
                    }
                }
                double ang = Math.toRadians(Double.parseDouble(strings[i + 1]));
                strings[i] = String.valueOf(Math.cos(ang));
                strings[i + 1] = " ";
                i++;
                continue;
            } else if (strings[i].equals("tan")) {
                if (strings[i+1].equals("(")){
                    String[] substrings = new String[strings.length-i-1];
                    for (int j = 0;j<strings.length-i-1;j++){
                        substrings[j] = strings[i+j+1];
                    }
                    substrings = CalInSpeical(substrings);
                    for (int k = 0;k<strings.length-1-i;k++){
                        strings[i+k+1] = substrings[k];
                    }
                }
                double ang = Math.toRadians(Double.parseDouble(strings[i + 1]));
                strings[i] = String.valueOf(Math.tan(ang));
                strings[i + 1] = " ";
                i++;
                continue;
            } else if (strings[i].equals("ln")) {
                if (strings[i+1].equals("(")){
                    String[] substrings = new String[strings.length-i-1];
                    for (int j = 0;j<strings.length-i-1;j++){
                        substrings[j] = strings[i+j+1];
                    }
                    substrings = CalInSpeical(substrings);
                    for (int k = 0;k<strings.length-1-i;k++){
                        strings[i+k+1] = substrings[k];
                    }
                }
                double number = Double.parseDouble(strings[i+1]);
                strings[i] = String.valueOf(Math.log(number));
                strings[i + 1] = " ";
                i++;
                continue;
            } else if (strings[i].equals("log")) {
                if (strings[i+1].equals("(")){
                    String[] substrings = new String[strings.length-i-1];
                    for (int j = 0;j<strings.length-i-1;j++){
                        substrings[j] = strings[i+j+1];
                    }
                    substrings = CalInSpeical(substrings);
                    for (int k = 0;k<strings.length-1-i;k++){
                        strings[i+k+1] = substrings[k];
                    }
                }
                double number = Double.parseDouble(strings[i + 1]);
                strings[i] = String.valueOf(Math.log(number) / Math.log(2));
                strings[i + 1] = " ";
                i++;
                continue;
            } else if (strings[i].equals("lg")) {
                if (strings[i+1].equals("(")){
                    String[] substrings = new String[strings.length-i-1];
                    for (int j = 0;j<strings.length-i-1;j++){
                        substrings[j] = strings[i+j+1];
                    }
                    substrings = CalInSpeical(substrings);
                    for (int k = 0;k<strings.length-1-i;k++){
                        strings[i+k+1] = substrings[k];
                    }
                }
                double number = Double.parseDouble(strings[i + 1]);
                strings[i] = String.valueOf(Math.log(number)/Math.log(10));
                strings[i + 1] = " ";
                i++;
                continue;
            } else if (strings[i].equals("root")) {
                if (strings[i+1].equals("(")){
                    String[] substrings = new String[strings.length-i-1];
                    for (int j = 0;j<strings.length-i-1;j++){
                        substrings[j] = strings[i+j+1];
                    }
                    substrings = CalInSpeical(substrings);
                    for (int k = 0;k<strings.length-1-i;k++){
                        strings[i+k+1] = substrings[k];
                    }
                }

                double number = Double.parseDouble(strings[i + 1]);
                strings[i] = String.valueOf(Math.sqrt(number));
                strings[i + 1] = " ";
                i++;
                continue;

            } else if (strings[i].equals("^")) {
                if (i!=0) {
                    if (strings[i-1].equals(")")){
                        String pre = new String();
                        int flag1 = 0;
                        int flag2 = 0;
                        for (int j = i-1;j>=0;j--){
                            if (isNumber(strings[j])){
                                pre = strings[j] + pre;
                            } else {
                                pre = "_" + strings[j] + "_" +pre;
                                if (strings[j].equals("(")){
                                    flag1++;
                                    if (flag1==flag2){
                                        String pres = getResult(pre);
                                        strings[i-1] = pres;
                                        for (int k = i-2;k>j-1;k--){
                                            strings[k] = " ";
                                        }
                                    }
                                } else if (strings[j].equals(")")){
                                    flag2++;
                                }
                            }
                        }
                    }
                    if (strings[i+1].equals("(")){
                        String[] substrings = new String[strings.length-i-1];
                        for (int j = 0;j<strings.length-i-1;j++){
                            substrings[j] = strings[i+j+1];
                        }
                        substrings = CalInSpeical(substrings);
                        for (int k = 0;k<strings.length-1-i;k++){
                            strings[i+k+1] = substrings[k];
                        }
                    }
                    for (int h=i-1;h>=0;h--){
                        if (isNumber(strings[h])&&strings[h+1]==" "&&h!=i-1){
                            strings[i-1] = strings[h];
                            strings[h] = " ";
                            break;
                        }
                    }

                    double number1 = Double.parseDouble(strings[i - 1]);
                    double number2 = Double.parseDouble(strings[i + 1]);
                    strings[i] = String.valueOf(Math.pow(number1,number2));
                    strings[i - 1] = " ";
                    strings[i + 1] = " ";
                    i++;
                    continue;
                }
            } else if (strings[i].equals("Ne")) {
                if (strings[i+1].equals("(")){
                    String[] substrings = new String[strings.length-i-1];
                    for (int j = 0;j<strings.length-i-1;j++){
                        substrings[j] = strings[i+j+1];
                    }
                    substrings = CalInSpeical(substrings);
                    for (int k = 0;k<strings.length-1-i;k++){
                        strings[i+k+1] = substrings[k];
                    }
                }
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
     * calculate every functions inner of sin(),log(),etc...
     * @param substrings: which is the substring after a special operator and  its content is also a notation. (e.g., sin(...) ).
     * @return a String[] which's first string is replaced by the result of notation in a () and keep the remaining string[].
     */
    public static String[] CalInSpeical(String[] substrings){
        int flag1 = 0;
        int flag2 = 0;
        String s = new String();

        if (substrings[0].equals("(")&&substrings.length>1) {
            int flag = 0;
            for (int i = 0; i < substrings.length; i++) {
                if (isNumber(substrings[i])){
                    s = s+substrings[i];
                } else {
                    s = s+"_"+substrings[i]+"_";

                }
                if (substrings[i].equals(")")){
                    flag2++;

                    if (flag1==flag2){
                        String r = getResult(s);
                        substrings[0] = r;
                        for (int j = 1; j<i+1; j++){
                            substrings[j] = " ";
                        }
                        break;
                    }
                } else if (substrings[i].equals("(")){
                    flag1++;
                }
            }
        }
        return substrings;
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
     * @param operator: '+', '-', '*', '/'.
     * @return the int number of order (i.e., '*'&'/' = 2 > '+'&'-' = 1).
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
