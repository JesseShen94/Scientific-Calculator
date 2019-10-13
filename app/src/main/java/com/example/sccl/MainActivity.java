package com.example.sccl;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MainActivity extends Activity implements View.OnClickListener {


    public Button num0;
    public Button num1;
    public Button num2;
    public Button num3;
    public Button num4;
    public Button num5;
    public Button num6;
    public Button num7;
    public Button num8;
    public Button num9;
    //set up buttons for num0-9
    //authored by Bojie Jia

    public Button leftParen;
    public Button rightParen;
    public Button leftBrace;
    public Button rightBrace;
    public Button leftBracket;
    public Button rightBracket;
    //set up buttons for brackets
    //authored by Bojie Jia

    public Button sin;
    public Button cos;
    public Button tan;
    public Button log;
    public Button power;
    public Button FUNCTION;
    public Button LOAD;
    public Button SAVE;
    // set up buttons for functions
    //authored by Bojie Jia

    public Button X;
    public Button Y;
    //set up buttons for variable;
    //authored by Bojie Jia

    public Button leftArrow;
    public Button rightArrow;
    //set up buttons for arrows
    //authored by Bojie Jia

    public Button dot;
    public Button equal;
    public Button plus;
    public Button minus;
    public Button divide;
    public Button multipy;
    public Button delete;
    boolean clean;
    public Button allClear;
    //set up buttons for operations
    //authored by Bojie Jia

    public EditText editText;
    public EditText editText2;
//    boolean clear_flag;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num0=findViewById(R.id.button51);
        num1=findViewById(R.id.button53);
        num2=findViewById(R.id.button52);
        num3=findViewById(R.id.button71);
        num4=findViewById(R.id.button48);
        num5=findViewById(R.id.button40);
        num6=findViewById(R.id.button70);
        num7=findViewById(R.id.button39);
        num8=findViewById(R.id.button23);
        num9=findViewById(R.id.button69);
        //number instantiation
        //authored by Bojie Jia

        leftParen=findViewById(R.id.button21);
        rightParen=findViewById(R.id.button3);
        leftBrace=findViewById(R.id.button33);
        rightBrace=findViewById(R.id.button34);
        leftBracket=findViewById(R.id.button29);
        rightBracket=findViewById(R.id.button30);
        //brackets instantiation
        //authored by Bojie Jia

        sin=findViewById(R.id.button9);
        cos=findViewById(R.id.button35);
        tan=findViewById(R.id.button31);
        log=findViewById(R.id.button26);
        power=findViewById(R.id.button25);
        FUNCTION=findViewById(R.id.button38);
        LOAD=findViewById(R.id.button32);
        SAVE=findViewById(R.id.button10);
        //functions instantiation
        //authored by Bojie Jia

        X=findViewById(R.id.button73);
        Y=findViewById(R.id.button67);
        // variables instantiation
        //authored by Bojie Jia

        leftArrow=findViewById(R.id.button78);
        rightArrow=findViewById(R.id.button77);
        // arrow instantiation
        //authored by Bojie Jia

        dot=findViewById(R.id.button68);

        plus=findViewById(R.id.button55);
        minus=findViewById(R.id.button37);
        divide=findViewById(R.id.button63);
        multipy=findViewById(R.id.button75);

        // operations instantiation
        //authored by Bojie Jia

        equal=findViewById(R.id.button28);
        delete=findViewById(R.id.button65);
        allClear=findViewById(R.id.button64);
        //sepecial operations
        //authored by Bojie Jia

        editText=findViewById(R.id.textView2);

        num0.setOnClickListener(this);
        num1.setOnClickListener(this);
        num2.setOnClickListener(this);
        num3.setOnClickListener(this);
        num4.setOnClickListener(this);
        num5.setOnClickListener(this);
        num6.setOnClickListener(this);
        num7.setOnClickListener(this);
        num8.setOnClickListener(this);
        num9.setOnClickListener(this);
        leftParen.setOnClickListener(this);
        rightParen.setOnClickListener(this);
        leftBracket.setOnClickListener(this);
        rightBracket.setOnClickListener(this);
        leftBrace.setOnClickListener(this);
        rightBrace.setOnClickListener(this);
        sin.setOnClickListener(this);
        cos.setOnClickListener(this);
        tan.setOnClickListener(this);
        log.setOnClickListener(this);
        power.setOnClickListener(this);
        FUNCTION.setOnClickListener(this);
        LOAD.setOnClickListener(this);
        SAVE.setOnClickListener(this);
        X.setOnClickListener(this);
        Y.setOnClickListener(this);
        leftArrow.setOnClickListener(this);
        rightArrow.setOnClickListener(this);
        dot.setOnClickListener(this);
        equal.setOnClickListener(this);
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        divide.setOnClickListener(this);
        multipy.setOnClickListener(this);
        delete.setOnClickListener(this);
        allClear.setOnClickListener(this);
        //add time click time
        //authored by Bojie Jia





    }
    //String inFunction = "";
    String input=editText.getText().toString();
    public void onClick(View view){


        switch (view.getId()){
            case R.id.button51:
                //inFunction+="0";
            case R.id.button53:
                //inFunction+="1";
            case R.id.button52:
                //inFunction+="2";
            case R.id.button71:
                //inFunction+="3";
            case R.id.button48:
                //inFunction+="4";
            case R.id.button40:
                //inFunction+="5";
            case R.id.button70:
                //inFunction+="6";
            case R.id.button39:
                //inFunction+="7";
            case R.id.button23:
                //inFunction+="8";
            case R.id.button69:
                //inFunction+="9";
                //for numbers
            case R.id.button68:
                //inFunction+=".";
                if(clean){
                    clean=false;
                    editText.setText("");//assign NULL
                }
                editText.setText(input+((Button)view).getText()+"");//The result set is itself
                break;
                //authored by Bojie Jia

            case R.id.button55:
                //inFunction+="+";
            case R.id.button37:
                //inFunction+="-";
            case R.id.button63:
                //inFunction+="_/_";
            case R.id.button75:
                //inFunction+="_*_";
                // for normal operations
                if(clean){
                    clean=false;
                    input="";
                    editText.setText("");
                }
                editText.setText(input+((Button)view).getText()+"");//The result set is itself
                break;
                //authored by Bojie Jia
            case R.id.button65:
                //clear function
                if(clean){
                    clean=false;
                    input="";
                    editText.setText("");
                }
                else if(input!=null||!input.equals("")){
                    editText.setText(input.substring(0,input.length()-1));
                    break;
                }
                break;
            case R.id.button28:
                getResult(input);
                break;






         /*   case R.id.button21:
                //inFunction+="(";
            case R.id.button3:
                //inFunction +=")";
            case R.id.button33:
                //inFunction+="{";
            case R.id.button34:
                //inFunction+="}";
            case R.id.button29:
                //inFunction+="[";
            case R.id.button30:
                //inFunction+="]";
                //for brackets
            case R.id.button73:
            case R.id.button67://for variables


                //normal signal
            case R.id.button64:
                input = "";
                //inFunction = "";
                //editText.setText("");
           */

                //break;
                //authored by Bojie Jia & Jiaxi Shen
        }
    }

    /**
     * the main process of calculation
     * @param formula
     * @return calculate result
     * @author Jiaxi Shen
     */
    public static Double getResult(String formula){
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
        return result;
    }

    /**
     *calculate two numbers with given operation
     * @param a
     * @param b
     * @param operation
     * @return
     * @author Jiaxi Shen
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
     * @author Jiaxi Shen
     */
    public static List<String> transform(String notation){
        List<String> element = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        notation = notation.replaceAll("(\\D)", "o$1o");
        String[] strings = notation.trim().split("o");

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
     * check the content of a String is number or not
     * @param string
     * @return
     * @author Jiaxi Shen
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
     * @author Jiaxi Shen
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
     * @author Jiaxi Shen
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



/*

    public void numberSeven(View view){
        Button button=(Button)view;
        String addContent=button.getText().toString();

    }
    //click "7" button, show "7" in the input text view
    public void numberEight (View view){

    }
    public void numberNine(View view){

    }
    public void numberFour(View view){

    }
    public void numberFive(View view){

    }
    public void numberSix(View view){

    }
    public void numberOne(View view){

    }
    public void numberTwo(View view){

    }
    public void numberThree(View view){

    }
    public void numberZero(View view){

    }
    public void dot(View view){

    }
    public void equal(View view){

    }
    public void plus(View view){

    }
    public void minus(View view){

    }
    public void multipy(View view){

    }
    public void divide(View view){

    }
    public void delete(View view){}
    public void allClear(View view){

    }
    public void variableX(View view){

    }
    public void variableY(View view){

    }
    public void function(View view){

    }
    public void sin(View view){

    }
    public void cos(View view){

    }
    public void tan(View view){

    }
    public void power(View view){

    }
    public void log(View view){

    }
    public void save(View view){

    }
    public void load(View view){

    }
    public void leftBracket(View view){

    }
    public void rightBracket(View view){

    }
    public void leftBrace(View view){

    }
    public void rightBrace(View view){

    }
    public void leftParentheses(View view){
    }

    public void rightParentheses(View view){

    }
*/




}
