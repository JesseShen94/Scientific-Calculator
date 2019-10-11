package com.example.sccl;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
    public Button allClear;
    //set up buttons for operations
    //authored by Bojie Jia

    public EditText editText;




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
    public void onClick(View view){
        String input=editText.getText().toString();
        switch (view.getId()){
            case R.id.button51:
            case R.id.button53:
            case R.id.button52:
            case R.id.button71:
            case R.id.button48:
            case R.id.button40:
            case R.id.button70:
            case R.id.button39:
            case R.id.button23:
            case R.id.button69://for numbers
            case R.id.button21:
            case R.id.button3:
            case R.id.button33:
            case R.id.button34:
            case R.id.button29:
            case R.id.button30://for brackets
            case R.id.button73:
            case R.id.button67://for variables
            case R.id.button68:
            case R.id.button55:
            case R.id.button37:
            case R.id.button63:
            case R.id.button75:// for normal operations
                //normal signal
                


                editText.setText(input+((Button)view).getText()+"");
                //authored by Bojie Jia
        }
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
