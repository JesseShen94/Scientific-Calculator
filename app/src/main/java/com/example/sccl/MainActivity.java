package com.example.sccl;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

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
    public Button negNum;
    //set up buttons for operations
    //authored by Bojie Jia
    public Button cos;
    public Button tan;
    public Button lg;
    public Button power;
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

    public Button ass;
    public TextView inputview;
    //set up button for assignment
    public TextView outputview;
    public String value = "";
    public String valueY = "";
    int flag = 0;
    String input = "";// input will showed in inputView window
    String function = "";//String function for save,load and assign




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num0 = findViewById(R.id.button51);
        num1 = findViewById(R.id.button53);
        num2 = findViewById(R.id.button52);
        num3 = findViewById(R.id.button71);
        num4 = findViewById(R.id.button48);
        num5 = findViewById(R.id.button40);
        num6 = findViewById(R.id.button70);
        num7 = findViewById(R.id.button39);
        num8 = findViewById(R.id.button23);
        num9 = findViewById(R.id.button69);

        //number instantiation
        //authored by Bojie Jia

        pi = findViewById(R.id.button5);
        X = findViewById(R.id.button73);
        Y = findViewById(R.id.button67);
        E = findViewById(R.id.e);
        // instants and variables instantiation
        //authored by Bojie Jia

        dot = findViewById(R.id.button68);
        //dot instantiation
        //authored by Bojie Jia

        plus = findViewById(R.id.button55);
        minus = findViewById(R.id.button37);
        divide = findViewById(R.id.button63);
        multipy = findViewById(R.id.button75);
        equal = findViewById(R.id.button28);
        delete = findViewById(R.id.button65);
        allClear = findViewById(R.id.button64);
        leftParen = findViewById(R.id.button21);
        rightParen = findViewById(R.id.button3);
        pi = findViewById(R.id.button5);
        root = findViewById(R.id.button4);
        negNum = findViewById(R.id.button666);

        // operations instantiation
        //authored by Bojie Jia

        sin = findViewById(R.id.button9);
        cos = findViewById(R.id.button35);
        tan = findViewById(R.id.button31);
        lg = findViewById(R.id.button26);
        LN = findViewById(R.id.ln);
        power = findViewById(R.id.button25);

        //normal functions instantiation
        //authored by Bojie Jia

        LOAD = findViewById(R.id.button32);
        SAVE = findViewById(R.id.button10);
        ass = findViewById(R.id.assgin);

        // special functions instantiation
        //authored by Bojie Jia

        inputview = findViewById(R.id.input);
        outputview = findViewById(R.id.output);
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
        negNum.setOnClickListener(this);

        sin.setOnClickListener(this);
        cos.setOnClickListener(this);
        tan.setOnClickListener(this);
        lg.setOnClickListener(this);
        power.setOnClickListener(this);



        LOAD.setOnClickListener(this);
        SAVE.setOnClickListener(this);

        LN.setOnClickListener(this);
        E.setOnClickListener(this);

        ass.setOnClickListener(this);

        //add time click time
        //authored by Bojie Jia

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button64://allclear
            {
                input = "";
                value = "";
                valueY="";
                function = "";
                inputview.setText(input);
                outputview.setText("");


            }
            break;

            case R.id.button65:// first judge it is null or not, than delete
                //reference:
            {
                if (input.indexOf(" ") == input.length() - 3) {
                    input = input.substring(0, input.length() - 2);
                }
                if (input.length() > 0) {
                    input = input.substring(0, input.length() - 1);
                }
                inputview.setText(input);
            }
            break;

            case R.id.button666://negative number
                if (flag == 1) {
                    value += "-";

                    outputview.setText(value);

                } else if (flag == 2) {
                    valueY += "-";

                    outputview.setText(valueY);
                } else {
                    input += "-";
                    inputview.setText(input);
                }
                break;

            case R.id.button75:// multiply
            {
                if (flag == 1) {
                    value += "×";

                    outputview.setText(input);
                } else if (flag == 2) {
                    valueY += "×";
                    input += "×";
                    outputview.setText(input);
                } else

                    input += "×";
                inputview.setText(input);
            }
            break;

            case R.id.button63://divide

            {
                if (flag == 1) {
                    value += "÷";
                    outputview.setText(value);
                } else if (flag == 2) {
                    valueY += "÷";
                    outputview.setText(valueY);
                } else
                    input += "÷";
                inputview.setText(input);
            }
            break;

            case R.id.button37://minus
            {
                if (flag == 1) {
                    value += "－";
                    outputview.setText(value);
                } else if (flag == 2) {
                    valueY += "－";
                    outputview.setText(valueY);
                } else
                    input += "－";
                inputview.setText(input);
            }
            break;

            case R.id.button55://add
            {
                if (flag == 1) {
                    value += "+";
                    outputview.setText(value);
                } else if (flag == 2) {
                    valueY += "+";
                    outputview.setText(valueY);
                } else
                    input += "+";

                inputview.setText(input);
            }
            break;

            case R.id.button68://"."
            {
                if (flag == 1) {
                    value += ".";
                    outputview.setText(value);
                } else if (flag == 2) {
                    valueY += ".";
                    outputview.setText(valueY);
                } else
                    input += ".";
                inputview.setText(input);

            }
            break;

            case R.id.button51://"0"
            {
                if (flag == 1) {
                    value += "0";
                    outputview.setText(value);
                } else if (flag == 2) {
                    valueY += "0";
                    outputview.setText(valueY);
                } else

                    input += "0";
                inputview.setText(input);

            }
            break;

            case R.id.button53://"1"
            {
                if (flag == 1) {
                    value += "1";
                    outputview.setText(value);
                } else if (flag == 2) {
                    valueY += "1";
                    outputview.setText(valueY);
                } else

                    input += "1";
                inputview.setText(input);

            }
            break;

            case R.id.button52://"2"
            {
                if (flag == 1) {
                    value += "2";
                    outputview.setText(value);
                } else if (flag == 2) {
                    valueY += "2";
                    outputview.setText(valueY);
                } else

                    input += "2";
                inputview.setText(input);

            }
            break;

            case R.id.button71://"3"
            {
                if (flag == 1) {
                    value += "3";
                    outputview.setText(value);
                } else if (flag == 2) {
                    valueY += "3";
                    outputview.setText(valueY);
                } else
                    input += "3";
                inputview.setText(input);

            }
            break;

            case R.id.button48://"4"
            {
                if (flag == 1) {
                    value += "4";
                    outputview.setText(value);
                } else if (flag == 2) {
                    valueY += "4";
                    outputview.setText(valueY);
                } else
                    input += "4";
                inputview.setText(input);

            }
            break;

            case R.id.button40://"5"
            {
                if (flag == 1) {
                    value += "5";
                    outputview.setText(value);
                } else if (flag == 2) {
                    valueY += "5";
                    outputview.setText(valueY);
                } else
                    input += "5";
                inputview.setText(input);

            }
            break;

            case R.id.button70://"6"
            {
                if (flag == 1) {
                    value += "6";
                    outputview.setText(value);
                } else if (flag == 2) {
                    valueY += "6";
                    outputview.setText(valueY);
                } else
                    input += "6";
                inputview.setText(input);
            }
            break;

            case R.id.button39://"7"
            {
                if (flag == 1) {
                    value += "7";
                    outputview.setText(value);
                } else if (flag == 2) {
                    valueY += "7";
                    outputview.setText(valueY);
                } else
                    input += "7";
                inputview.setText(input);

            }
            break;

            case R.id.button23://"8"
            {
                if (flag == 1) {
                    value += "8";
                    outputview.setText(value);
                } else if (flag == 2) {
                    valueY += "8";
                    outputview.setText(valueY);
                } else
                    input += "8";
                inputview.setText(input);

            }
            break;

            case R.id.button69://"9"
            {
                if (flag == 1) {
                    value += "9";
                    outputview.setText(value);
                } else if (flag == 2) {
                    valueY += "9";
                    outputview.setText(valueY);
                } else {
                    input += "9";
                    inputview.setText(input);
                }
            }
            break;


            case R.id.button5://"π"
            {
                if (flag == 1) {
                    value += "π";
                    outputview.setText(value);
                } else if (flag == 2) {
                    valueY += "π";
                    outputview.setText(valueY);
                } else
                    input += "π";
                inputview.setText(input);

            }
            break;

            case R.id.e://"e"
            {

                if (flag == 1) {
                    value += "e";
                    outputview.setText(value);
                } else if (flag == 2) {
                    valueY += "e";
                    outputview.setText(valueY);
                } else
                    input += "e";
                inputview.setText(input);

            }
            break;

            case R.id.button73://"X"
            {
                input += "X";

                inputview.setText(input);
            }
            break;


            case R.id.button67: {
                input += "Y";
                inputview.setText(input);
            }
            break;


            case R.id.button21://"("
            {
                if (flag == 1) {
                    value += "(";
                    outputview.setText(value);
                } else if (flag == 2) {
                    valueY += "(";
                    outputview.setText(valueY);
                } else
                    input += "(";
                inputview.setText(input);
            }
            break;


            case R.id.button3://")"
            {
                if (flag == 1) {
                    value += ")";
                    outputview.setText(value);
                } else if (flag == 2) {
                    valueY += ")";
                    outputview.setText(valueY);
                } else
                    input += ")";
                inputview.setText(input);
            }
            break;


            case R.id.button4://root
            {
                if (flag == 1) {
                    value += "√";
                    outputview.setText(value);
                } else if (flag == 2) {
                    valueY += "√";
                    outputview.setText(valueY);
                } else
                    input += "√";
                inputview.setText(input);
            }
            break;


            case R.id.button9://sin
            {
                if (flag == 1) {
                    value += "sin";
                    outputview.setText(value);
                } else if (flag == 2) {
                    valueY += "sin";
                    outputview.setText(valueY);
                } else
                    input += "sin";
                inputview.setText(input);
            }
            break;

            case R.id.button35://cos
            {
                if (flag == 1) {
                    value += "cos";
                    outputview.setText(value);
                } else if (flag == 2) {
                    valueY += "cos";
                    outputview.setText(valueY);
                } else
                    input += "cos";
                inputview.setText(input);
            }
            break;

            case R.id.button31://tan
            {
                if (flag == 1) {
                    value += "tan";
                    outputview.setText(value);
                } else if (flag == 2) {
                    valueY += "tan";
                    outputview.setText(valueY);
                } else
                    input += "tan";
                inputview.setText(input);
            }
            break;

            case R.id.button25://power
            {
                if (flag == 1) {
                    value += "^";
                    outputview.setText(value);
                } else if (flag == 2) {
                    valueY += "^";
                    outputview.setText(valueY);
                } else
                    input += "^";
                inputview.setText(input);
            }
            break;

            case R.id.button26://log
            {
                if (flag == 1) {
                    value += "lg";
                    outputview.setText(value);
                } else if (flag == 2) {
                    valueY += "lg";
                    outputview.setText(valueY);
                } else
                    input += "lg";

                inputview.setText(input);
            }
            break;

            case R.id.ln://ln
            {
                if (flag == 1) {
                    value += "ln";
                    outputview.setText(value);
                } else if (flag == 2) {
                    valueY += "ln";
                    outputview.setText(valueY);
                } else
                    input += "ln";
                inputview.setText(input);
            }
            break;



            case R.id.button10://save function
                //reference from: https://blog.csdn.net/andanwubian/article/details/81974194
            {
                try{
                    function = input;
                    FileOutputStream outputStream = this.openFileOutput("functions.txt",Context.MODE_PRIVATE);
                    outputStream.write(function.getBytes());
                    outputStream.close();
                }catch (FileNotFoundException e){
                    return;
                } catch (IOException e){
                    return;
                }
                inputview.setText(input);
            }
            break;

            case R.id.button32://load function
            {
                try {
                    FileInputStream fileInputStream = this.openFileInput("functions.txt");
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    byte[] buffer = new byte[1024];
                    int length = -1;
                    while ((length = fileInputStream.read(buffer))!=-1){
                        stream.write(buffer,0,length);
                    }
                    stream.close();
                    fileInputStream.close();
                    function = stream.toString();
                } catch (FileNotFoundException e){
                    e.printStackTrace();
                } catch (IOException e){
                    return;
                }
                input=function;
                inputview.setText(input);
            }
            break;

            case R.id.assgin: //assign value for function
            {
                if (flag == 0) {
                    inputview.setText(Transformation.AssignNumber(input));
                    flag = 1;
                    if(Transformation.AssignNumber(input).equals("ERROR!!!")){
                        flag=0;
                    }
                } else if (flag == 1) {

                    if (Transformation.AssignNumber(input).equals("input X")) {
                        String text = "X=" + value;
                        inputview.setText(text);
                        double x = Double.parseDouble(value);
                        input = Transformation.assignX(input, x);
                        outputview.setText(input);
                        flag = 0;
                    } else if (Transformation.AssignNumber(input).equals("input Y")) {
                        String text = "Y=" + value;
                        inputview.setText(text);
                        double y = Double.parseDouble(value);
                        input = Transformation.assignY(input, y);
                        outputview.setText(input);
                        flag = 0;
                    } else if (Transformation.AssignNumber(input).equals("input X,Y")) {
                        String text = "X=" + value+"， input Y";

                        double x = Double.parseDouble(Calculate.getResult(value));
                        input=Transformation.assignX(input,x);

                        inputview.setText(text);
                        flag = 2;
                    }
                    else if(Transformation.AssignNumber(input).equals("ERROR!!!")){
                        flag=0;
                    }
                }
                else if (flag == 2) {
                    String text = "X=" + value + ", Y=" + valueY;
                    inputview.setText(text);
                    if (Transformation.transfer(Calculate.getResult(value)).equals("error")||Transformation.transfer(Calculate.getResult(valueY)).equals("error")||(Transformation.transfer(Calculate.getResult(text))).equals("error")) {
                        inputview.setText("input error, check your format plz");
                        flag = 0;
                    } else {

                        double y = Double.parseDouble(Calculate.getResult(valueY));
                        input = Transformation.assignY(input, y);
                        outputview.setText(input);
                        flag = 0;
                    }
                    }

            }
            break;

            case R.id.button28://equal
            {
                String innerfunciton = Transformation.transfer(input);
                inputview.setText(input);
                String out = Calculate.getResult(innerfunciton) + "";
                outputview.setText(out);

            }
            break;
        }
    }

}
