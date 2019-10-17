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
    //set up buttons for number,
    //authored by Bojie Jia

    public Button pi;
    public Button X;
    public Button Y;
    //set up buttons for constants and variables
    //authored by Bojie Jia

    public Button dot;
    //set up buttons for dot
    //authored by Bojie Jia


    public Button root;
    public Button leftParen;
    public Button rightParen;
    public Button equal;
    public Button plus;
    public Button minus;
    public Button divide;
    public Button multipy;
    public Button delete;
    public Button allClear;
    public Button sin;

    //set up buttons for operations
    //authored by Bojie Jia
    public Button cos;
    public Button tan;
    public Button log;
    public Button power;
    public Button FUNCTION;
    // set up buttons for normal functions
    //authored by Bojie Jia
    public Button LOAD;
    public Button SAVE;
    public Button LN;
    // set up buttons for special functions
    //authored by Bojie Jia
    //set up button for Natural logarithm；
    public Button E;
    //set up button for Euler's number;
    public Button pic;
    //set up button for picture
    public Button ass;
    public EditText inputview;
    //set up button for assignment
    public EditText outputview;
    boolean clean;
    int flag=0;
    String input="";// input will showed in inputView window
    String dealWith="";//String dealWith is a String would be processed in the function section
    String function="";//String function for save,load and assign
    String valueX;
    String valueY;

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

    private static String Assignnumber(String function){
        Boolean X=false;
        Boolean Y=false;
        for(int i=0;i<function.length();i++){
            if(function.charAt(i)=='X'){
                X=true;
            }
            if(function.charAt(i)=='Y'){
                Y=true;
            }
        }
        if(!X&&!Y){
            return "ERROR!!!";
        }
        if(X&&!Y){
            return "input X";
        }
        if(!X&&Y){
            return "input Y";
        }
        if(X&&Y){
            return "input X,Y";
        }
        return "ERROR!!!";
    }

    private static String assignX(String function, double x){
        String newf="";
        for(int i=0;i<function.length();i++){
            if(function.charAt(i)!='X'){
                newf+=function.charAt(i);
            }
            else newf+=x;

        }
        return newf;

    }

    private static String assignY(String function, double y){
        String newf="";
        for(int i=0;i<function.length();i++){
            if(function.charAt(i)!='Y'){
                newf+=function.charAt(i);
            }
            else newf+=y;

        }
        return newf;


    }

    private static String assignXY(String function, double x, double y){
        String newf="";
        for(int i=0;i<function.length();i++){
            if(function.charAt(i)=='X'){
                newf+=x;
            }
            else if(function.charAt(i)=='Y'){
                newf+=y;
            }
            else newf+=function.charAt(i);

        }
        return newf;

    }

    private static String transfer(String input){
        String innerFuction="";
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)=='×'){
                innerFuction+="_*_";
            }
            else if(input.charAt(i)=='÷'){
                innerFuction+="_/_";
            }
            else if(input.charAt(i)=='－'){
                innerFuction+="_-_";
            }
            else if(input.charAt(i)=='+'){
                innerFuction+="_+_";
            }
            else if(input.charAt(i)=='π'){
                innerFuction+="_pi_";//
            }
            else if(input.charAt(i)=='e'){
                innerFuction+="_E_";
            }
            else if(input.charAt(i)=='('){
                innerFuction+="_(_";
            }
            else if(input.charAt(i)==')'){
                innerFuction+="_)_";
            }
            else if(input.charAt(i)=='√'){
                innerFuction+="_root_";
            }
            else if(input.charAt(i)=='s'&&input.charAt(i+1)=='i'&&input.charAt(i+2)=='n'){
                innerFuction+="_sin_";
                i=i+2;
                continue;
            }
            else if(input.charAt(i)=='c'&&input.charAt(i+1)=='o'&&input.charAt(i+2)=='s'){
                innerFuction+="_cos_";
                i=i+2;
                continue;
            }
            else if(input.charAt(i)=='t'&&input.charAt(i+1)=='a'&&input.charAt(i+2)=='n'){
                innerFuction+="_tan_";
                i=i+2;
                continue;
            }
            else if(input.charAt(i)=='^'){
                innerFuction+="_^_";


            }
            else if(input.charAt(i)=='l'&&input.charAt(i+1)=='o'&&input.charAt(i+2)=='g'){
                innerFuction+="_log_";
                i=i+2;
                continue;
            }
            else if(input.charAt(i)=='l'&&input.charAt(i+1)=='n'){
                innerFuction+="_ln_";
                i=i+1;
                continue;
            }
            else innerFuction+=input.charAt(i);
        }
        return innerFuction;
    }

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

        pi=findViewById(R.id.button5);
        X=findViewById(R.id.button73);
        Y=findViewById(R.id.button67);
        E=findViewById(R.id.e);
        // instants and variables instantiation
        //authored by Bojie Jia

        dot=findViewById(R.id.button68);
        //dot instantiation
        //authored by Bojie Jia

        plus=findViewById(R.id.button55);
        minus=findViewById(R.id.button37);
        divide=findViewById(R.id.button63);
        multipy=findViewById(R.id.button75);
        equal=findViewById(R.id.button28);
        delete=findViewById(R.id.button65);
        allClear=findViewById(R.id.button64);
        leftParen=findViewById(R.id.button21);
        rightParen=findViewById(R.id.button3);
        pi=findViewById(R.id.button5);
        root=findViewById(R.id.button4);

        // operations instantiation
        //authored by Bojie Jia

        sin=findViewById(R.id.button9);
        cos=findViewById(R.id.button35);
        tan=findViewById(R.id.button31);
        log=findViewById(R.id.button26);
        LN=findViewById(R.id.ln);
        power=findViewById(R.id.button25);

        //normal functions instantiation
        //authored by Bojie Jia

        FUNCTION=findViewById(R.id.button38);
        LOAD=findViewById(R.id.button32);
        SAVE=findViewById(R.id.button10);
//
        pic=findViewById(R.id.pic);
        ass=findViewById(R.id.assgin);

        // special functions instantiation
        //authored by Bojie Jia

        inputview=findViewById(R.id.textView2);
        outputview=findViewById(R.id.textView);
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
        pi.setOnClickListener(this);
        X.setOnClickListener(this);
        Y.setOnClickListener(this);
        dot.setOnClickListener(this);

        equal.setOnClickListener(this);
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        divide.setOnClickListener(this);
        multipy.setOnClickListener(this);
        delete.setOnClickListener(this);
        allClear.setOnClickListener(this);
        leftParen.setOnClickListener(this);
        rightParen.setOnClickListener(this);
        root.setOnClickListener(this);

        sin.setOnClickListener(this);
        cos.setOnClickListener(this);
        tan.setOnClickListener(this);
        log.setOnClickListener(this);
        power.setOnClickListener(this);


        FUNCTION.setOnClickListener(this);
        LOAD.setOnClickListener(this);
        SAVE.setOnClickListener(this);

        LN.setOnClickListener(this);
        E.setOnClickListener(this);
        pic.setOnClickListener(this);
        ass.setOnClickListener(this);

        //add time click time
        //authored by Bojie Jia

    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.button64://allclear
            {
                input="";
                dealWith="";
                inputview.setText(input);
                outputview.setText("");


            }
            break;

            case R.id.button65:// first judge it is null or not, than delete
            {
                if(input.indexOf(" ")==input.length()-3){
                    input=input.substring(0,input.length()-2);
                }
                if(input.length()>0){
                    input=input.substring(0,input.length()-1);
                }
                inputview.setText(input);
            }
            break;

            case R.id.button75:// multiply
            {

                input+="×";
                ;
                inputview.setText(input);
            }
            break;

            case R.id.button63://divide
            {

                input+="÷";

                inputview.setText(input);
            }
            break;

            case R.id.button37://minus
            {

                input+="－";

                inputview.setText(input);
            }
            break;

            case R.id.button55://add
            {

                input+="+";

                inputview.setText(input);
              }
            break;

            case R.id.button68://"."
            {


                    input += ".";
                    inputview.setText(input);

            }
            break;

            case R.id.button51://"0"
            {

                    input += "0";
                    inputview.setText(input);

            }
            break;

            case R.id.button53://"1"
            {

                    input += "1";
                    inputview.setText(input);

            }
            break;

            case R.id.button52://"2"
            {

                    input += "2";
                    inputview.setText(input);

            }
            break;

            case R.id.button71://"3"
            {

                    input += "3";
                    inputview.setText(input);

            }
            break;

            case R.id.button48://"4"
            {

                    input += "4";
                    inputview.setText(input);

            }
            break;

            case R.id.button40://"5"
            {

                    input += "5";
                    inputview.setText(input);

            }
            break;

            case R.id.button70://"6"
            {

                    input += "6";
                    inputview.setText(input);

            }
            break;

            case R.id.button39://"7"
            {

                    input += "7";
                    inputview.setText(input);

            }
            break;

            case R.id.button23://"8"
            {
                    input += "8";
                    inputview.setText(input);

            }
            break;

            case R.id.button69://"9"
            {
                    input += "9";
                    inputview.setText(input);

            }
            break;


            case R.id.button5://"π"
            {
                    input += "π";
                    inputview.setText(input);

            }
            break;

            case R.id.e://"e"
            {

                    input += "e";
                    inputview.setText(input);

            }
            break;

            case R.id.button73://"X"
            {
                input+="X";

                inputview.setText(input);
            }
            break;



            case R.id.button67:
            {
                input+="Y";
                inputview.setText(input);
            }
            break;




            case R.id.button21://"("
            {
                input+="(";
                inputview.setText(input);
            }
            break;


            case R.id.button3://")"
            {
                input+=")";
                inputview.setText(input);
            }
            break;


            case R.id.button4://root
            {
                input+="√";
                inputview.setText(input);
            }
            break;


            case R.id.button9://sin
            {
                input+="sin";
                inputview.setText(input);
            }
            break;

            case R.id.button35://cos
            {
                input+="cos";
                inputview.setText(input);
            }
            break;

            case R.id.button31://tan
            {
                input+="tan";
                inputview.setText(input);
            }
            break;

            case R.id.button25://power
            {
                input+="^";
                inputview.setText(input);
            }
            break;

            case R.id.button26://log
            {
                input+="log";

                inputview.setText(input);
            }
            break;

            case R.id.ln://ln
            {
                input+="ln";
                inputview.setText(input);
            }
            break;

            case R.id.button38://F=
            {
                input+="F=";
                inputview.setText(input);
            }
            break;

            case R.id.button10://save function
            {
                function=input;
                inputview.setText(input);
            }
            break;

            case R.id.button32://load function
            {


                inputview.setText(function);
            }
            break;

            case R.id.assgin: //assign value for function
                {
                    if(flag==0) {
                        inputview.setText(Assignnumber(function));
                        flag=1;
                    }
                    else {
                        if(Assignnumber(function).equals("input X")){

                            double x=Double.parseDouble(valueX);
                            input=assignX(function,x);
                            inputview.setText(input);
                        }
                        else if(Assignnumber(function).equals("input Y")){
                            double y=Double.parseDouble(valueY);
                            input=assignY(function,y);
                            inputview.setText(input);
                        }
                        else if(Assignnumber(function).equals("input X,Y")){
                            double x=Double.parseDouble(valueX);
                            double y=Double.parseDouble(valueY);
                            input=assignXY(function,x,y);
                            inputview.setText(input);
                        }
                        flag=0;
                    }
            }
            break;

            case R.id.button28://equal
            {
                String innerfunciton=transfer(input);
                //inputview.setText(input);
                inputview.setText(innerfunciton);
                String out= Calculate.getResult(innerfunciton)+"";
                outputview.setText(out);

            }
            break;
        }
    }

}
