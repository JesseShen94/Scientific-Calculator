package com.example.sccl;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TransformationTest {

    final String[] functionWithX=new String[]{
            "5-X+6*X/(8^X)", "√(lnX)", "X-π/e", "sinX-(cosX+tanX)","lgX+(-)lnX"
    };
    final String[] functionWithY=new String[]{
            "5-Y+6*Y/(8^Y)", "√(lnY)", "Y-π/e", "sinY-(cosY+tanY)","lgY+(-)lnY"
    };
    final String[] functionWithXY=new String[]{
            "5-X+6*Y/(8^X)", "√(lnY)+X^Y", "Y-π/e*X", "sinY-(cosX+tanY)","lgX+(-)lnY"

    };
    final String[] functionWithNovariable=new String[]{
            "5+3/4", "3^9", "43214*lg1232312"
    };

    @Test
    public void assignNumber() {
        for(String s:functionWithX){
            assertTrue("Something wrong in judge whether there is any X: "+s,Transformation.AssignNumber(s).equals("input X"));
            assertTrue("Something wrong in judge whether there is any Y: "+s,!Transformation.AssignNumber(s).equals("input Y"));
            assertTrue("Something wrong in judge whether there is any X and Y: "+s,!Transformation.AssignNumber(s).equals("input X,Y"));
            assertTrue("Something wrong in judge whether there is no X or Y: "+s,!Transformation.AssignNumber(s).equals("ERROR!!!"));

        }
        for(String s:functionWithY){
            assertTrue("Something wrong in judge whether there is any X",!Transformation.AssignNumber(s).equals("input X"));
            assertTrue("Something wrong in judge whether there is any Y: "+s,Transformation.AssignNumber(s).equals("input Y"));
            assertTrue("Something wrong in judge whether there is any X and Y: "+s,!Transformation.AssignNumber(s).equals("input X,Y"));
            assertTrue("Something wrong in judge whether there is no X or Y: "+s,!Transformation.AssignNumber(s).equals("ERROR!!!"));
        }
        for(String s:functionWithXY){
            assertTrue("Something wrong in judge whether there is any X",!Transformation.AssignNumber(s).equals("input X"));
            assertTrue("Something wrong in judge whether there is any Y: "+s,!Transformation.AssignNumber(s).equals("input Y"));
            assertTrue("Something wrong in judge whether there is any X and Y: "+s,Transformation.AssignNumber(s).equals("input X,Y"));
            assertTrue("Something wrong in judge whether there is no X or Y: "+s,!Transformation.AssignNumber(s).equals("ERROR!!!"));
        }
        for(String s:functionWithNovariable){
            assertTrue("Something wrong in judge whether there is any X",!Transformation.AssignNumber(s).equals("input X"));
            assertTrue("Something wrong in judge whether there is any Y: "+s,!Transformation.AssignNumber(s).equals("input Y"));
            assertTrue("Something wrong in judge whether there is any X and Y: "+s,!Transformation.AssignNumber(s).equals("input X,Y"));
            assertTrue("Something wrong in judge whether there is no X or Y: "+s,Transformation.AssignNumber(s).equals("ERROR!!!"));
        }

    }

    @Test
    public void assignX() {
        assertTrue("Something wrong in assign value to X: "+functionWithX[0],Transformation.assignX(functionWithX[0],999).equals("5-999.0+6*999.0/(8^999.0)"));
        assertTrue("Something wrong in assign value to X: "+functionWithX[1],Transformation.assignX(functionWithX[1],999).equals("√(ln999.0)"));
        assertTrue("Something wrong in assign value to X: "+functionWithX[1],Transformation.assignX(functionWithX[2],999).equals("999.0-π/e"));
        assertTrue("Something wrong in assign value to X: "+functionWithX[1],Transformation.assignX(functionWithX[3],999).equals("sin999.0-(cos999.0+tan999.0)"));
        assertTrue("Something wrong in assign value to X: "+functionWithX[1],Transformation.assignX(functionWithX[4],999).equals("lg999.0+(-)ln999.0"));

        for(int i=0;i<functionWithY.length;i++){
            assertTrue("Something wrong in assign value to X: "+functionWithY[i],!Transformation.assignX(functionWithY[i],999).equals(functionWithY));
        }

        for(int i=0;i<functionWithXY.length;i++){
            assertTrue("Something wrong in assign value to X: "+functionWithXY[i],!Transformation.assignX(functionWithXY[i],999).equals(functionWithXY));
        }

        for(int i=0;i<functionWithNovariable.length;i++){
            assertTrue("Something wrong in assign value to X: "+functionWithNovariable[i],!Transformation.assignX(functionWithNovariable[i],999).equals(functionWithNovariable));
        }
    }

    @Test
    public void assignY() {
        for(int i=0;i<functionWithX.length;i++){
            assertTrue("Something wrong in assign value to Y: "+functionWithX[i],!Transformation.assignY(functionWithX[i],999).equals(functionWithX));
        }

        assertTrue("Something wrong in assign value to Y: "+functionWithX[0],Transformation.assignY(functionWithY[0],999).equals("5-999.0+6*999.0/(8^999.0)"));
        assertTrue("Something wrong in assign value to Y: "+functionWithX[1],Transformation.assignY(functionWithY[1],999).equals("√(ln999.0)"));
        assertTrue("Something wrong in assign value to Y: "+functionWithX[1],Transformation.assignY(functionWithY[2],999).equals("999.0-π/e"));
        assertTrue("Something wrong in assign value to Y: "+functionWithX[1],Transformation.assignY(functionWithY[3],999).equals("sin999.0-(cos999.0+tan999.0)"));
        assertTrue("Something wrong in assign value to Y: "+functionWithX[1],Transformation.assignY(functionWithY[4],999).equals("lg999.0+(-)ln999.0"));

        for(int i=0;i<functionWithXY.length;i++){
            assertTrue("Something wrong in assign value to Y: "+functionWithXY[i],!Transformation.assignY(functionWithXY[i],999).equals(functionWithXY));
        }

        for(int i=0;i<functionWithNovariable.length;i++){
            assertTrue("Something wrong in assign value to Y: "+functionWithNovariable[i],!Transformation.assignY(functionWithNovariable[i],999).equals(functionWithNovariable));
        }
    }

    @Test
    public void assignXY() {

        assertTrue("Something wrong in assign value to X and Y: "+functionWithXY[0],Transformation.assignXY(functionWithXY[0],999,111).equals("5-999.0+6*111.0/(8^999.0)"));
        assertTrue("Something wrong in assign value to X and Y: "+functionWithXY[1],Transformation.assignXY(functionWithXY[1],999,111).equals("√(ln111.0)+999.0^111.0"));
        assertTrue("Something wrong in assign value to X and Y: "+functionWithXY[2],Transformation.assignXY(functionWithXY[2],999,111).equals("111.0-π/e*999.0"));
        assertTrue("Something wrong in assign value to X and Y: "+functionWithXY[3],Transformation.assignXY(functionWithXY[3],999,111).equals("sin111.0-(cos999.0+tan111.0)"));
        assertTrue("Something wrong in assign value to X and Y: "+functionWithXY[4],Transformation.assignXY(functionWithXY[4],999,111).equals("lg999.0+(-)ln111.0"));
    }

    @Test
    public void transfer() {

        ArrayList<String> transferedF0=new ArrayList<>();
        for(int i=0;i<functionWithX.length;i++){
            transferedF0.add(Transformation.transfer(functionWithX[i]));
        }
        ArrayList<String> expectedF0=new ArrayList<>();
        expectedF0.add("5_Ne_X_+_6*X/_(_8_^_X_)_");
        expectedF0.add("_root__(__ln_X_)_");
        expectedF0.add("X_Ne__pi_/_E_");
        expectedF0.add("_sin_X_Ne__(__cos_X_+__tan_X_)_");
        expectedF0.add("_lg_X_+__(__Ne__)__ln_X");


        ArrayList<String> transferedF1=new ArrayList<>();
        for(int i=0;i<functionWithY.length;i++){
            transferedF1.add(Transformation.transfer(functionWithY[i]));
        }
        ArrayList<String> expectedF1=new ArrayList<>();
        expectedF1.add("5_Ne_Y_+_6*Y/_(_8_^_Y_)_");
        expectedF1.add("_root__(__ln_Y_)_");
        expectedF1.add("Y_Ne__pi_/_E_");
        expectedF1.add("_sin_Y_Ne__(__cos_Y_+__tan_Y_)_");
        expectedF1.add("_lg_Y_+__(__Ne__)__ln_Y");




        ArrayList<String> transferedF2=new ArrayList<>();
        for(int i=0;i<functionWithXY.length;i++){
            transferedF2.add(Transformation.transfer(functionWithXY[i]));
        }
        ArrayList<String> expectedF2=new ArrayList<>();

        expectedF2.add("5_Ne_X_+_6*Y/_(_8_^_X_)_");
        expectedF2.add("_root__(__ln_Y_)__+_X_^_Y");
        expectedF2.add("Y_Ne__pi_/_E_*X");
        expectedF2.add("_sin_Y_Ne__(__cos_X_+__tan_Y_)_");
        expectedF2.add("_lg_X_+__(__Ne__)__ln_Y");


        ArrayList<String> transferedF3=new ArrayList<>();
        for(int i=0;i<functionWithNovariable.length;i++){
            transferedF3.add(Transformation.transfer(functionWithNovariable[i]));
        }
        ArrayList<String> expectedF3=new ArrayList<>();

        expectedF3.add("5_+_3/4");
        expectedF3.add("3_^_9");
        expectedF3.add("43214*_lg_1232312");

        for(int i=0;i<transferedF0.size();i++) {
            assertTrue("Something wrong in transfer function" + functionWithX[i], transferedF0.get(i).equals(expectedF0.get(i)));
        }

        for(int i=0;i<transferedF1.size();i++) {
            assertTrue("Something wrong in transfer function" + functionWithY[i], transferedF1.get(i).equals(expectedF1.get(i)));
        }

        for(int i=0;i<transferedF2.size();i++) {
            assertTrue("Something wrong in transfer function" + functionWithXY[i], transferedF2.get(i).equals(expectedF2.get(i)));

        }

        for(int i=0;i<transferedF3.size();i++) {
            assertTrue("Something wrong in transfer function" + functionWithNovariable[i], transferedF3.get(i).equals(expectedF3.get(i)));
        }
    }
}