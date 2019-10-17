package com.example.sccl;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculateTest {

    @Test
    public void getResult() {
    }

    @Test
    public void transform() {
    }

    @Test
    public void fixNotation() {
        String[] oneNotation=new String[]{"_E_+5","_pi_-6","_sin_50","_cos_30","_tan_45","_ln_7","_lg_9","_root_121","7.4_^_9.8","_Ne_432"};
        String[] twoNotation=new String[]{"_(_sin_30_)_*_(__root_121_)_",  "7_^_9_-__Ne_432"};
        String[] threeNotation=new String[]{"_E_+5+_pi_-6+_sin_50","_Ne_432_/__(__E__+__pi__)_" };
        String fourNotation="_E__+__pi__*__sin_50_/__cos_30";


        String tenNotation= " _E__+__pi__-___sin_50_+__cos_60_/__tan_45_+__ln_7_/__lg_9_+__root_121_+_9_^_7_/__Ne_432";

        //test "_E_+5"
        String[] string00=Calculate.fixNotation(oneNotation[0]);
        assertTrue("_E_ cannot be fixed correctly", string00[1].equals(String.valueOf(Math.E)));
        assertTrue("+5  cannot be fixed correctly", string00[2].equals("+5"));

        //test "_pi_-6"
        String[] string01=Calculate.fixNotation(oneNotation[1]);
        assertTrue("_E_ cannot be fixed correctly", string01[1].equals(String.valueOf(Math.PI)));
        assertTrue("+5  cannot be fixed correctly", string01[2].equals("-6"));

        //test "_sin_50"
        String[] string02=Calculate.fixNotation(oneNotation[2]);
        assertTrue("_sin_50 cannot be fixed correctly", string02[1].equals(String.valueOf(Math.sin(Math.toRadians(50)))));

        //test "_cos_30"
        String[] string03=Calculate.fixNotation(oneNotation[3]);
        assertTrue("_cos_30 cannot be fixed correctly", string03[1].equals(String.valueOf(Math.cos(Math.toRadians(30)))));

        //test"_tan_45"
        String[] string04=Calculate.fixNotation(oneNotation[4]);
        assertTrue("_tan_45 cannot be fixed correctly", string04[1].equals(String.valueOf(Math.tan(Math.toRadians(45)))));

        //test "_ln_7"
        String[] string05=Calculate.fixNotation(oneNotation[5]);
        assertTrue("_ln_7 cannot be fixed correctly", string05[1].equals(String.valueOf(Math.log(7)/Math.log(Math.E))));

        //test "_lg_9"
        String[] string06=Calculate.fixNotation(oneNotation[6]);
        assertTrue("_lg_9 cannot be fixed correctly", string06[1].equals(String.valueOf(Math.log(9)/Math.log(10))));

        //test"_root_121"
        String[] string07=Calculate.fixNotation(oneNotation[7]);
        assertTrue("_root_121 cannot be fixed correctly", string07[1].equals(String.valueOf(Math.sqrt(121))));

        //test"7.4_^_9.8"
        String[] string08=Calculate.fixNotation(oneNotation[8]);
        assertTrue("7.4_^_9.8 cannot be fixed correctly", string08[1].equals(String.valueOf(Math.pow(7.4,9.8))));

        //test"_Ne_432"
        String[] string09 =Calculate.fixNotation(oneNotation[9]);
        assertTrue("_Ne_432 cannot be fixed correctly", string09[1].equals(String.valueOf((double)(0-432))));


        //test"_(_sin_30_)_*_(__root_121_)_"
        String[] string10=Calculate.fixNotation(twoNotation[0]);
        assertTrue("_(_sin_30_)_*_(__root_121_)_ cannot be fixed correctly", string10[1].equals("("));
        assertTrue("_(_sin_30_)_*_(__root_121_)_ cannot be fixed correctly", string10[2].equals(String.valueOf(Math.sin(Math.toRadians(30)))));
        assertTrue("_(_sin_30_)_*_(__root_121_)_ cannot be fixed correctly", string10[4].equals(")"));
        assertTrue("_(_sin_30_)_*_(__root_121_)_ cannot be fixed correctly", string10[5].equals("*"));
        assertTrue("_(_sin_30_)_*_(__root_121_)_ cannot be fixed correctly", string10[6].equals("("));
        assertTrue("_(_sin_30_)_*_(__root_121_)_ cannot be fixed correctly", string10[8].equals(String.valueOf(Math.sqrt(121))));
        assertTrue("_(_sin_30_)_*_(__root_121_)_ cannot be fixed correctly", string10[10].equals(")"));

        //test"7_^_9_-__Ne_432"
        String[] string11=Calculate.fixNotation(twoNotation[1]);
        assertTrue("7_^_9_-__Ne_432 cannot be fixed correctly",string11[1].equals(String.valueOf(Math.pow(7,9))));
        assertTrue("7_^_9_-__Ne_432 cannot be fixed correctly",string11[3].equals("-"));
        assertTrue("7_^_9_-__Ne_432 cannot be fixed correctly",string11[5].equals(String.valueOf((double) 0-432)));

        //test "_E_+5+_pi_-6+_sin_50"
        String[] string20=Calculate.fixNotation(threeNotation[0]);
        assertTrue("_E_+5+_pi_-6+_sin_50 cannot be fixed correctly", string20[1].equals(String.valueOf(Math.E)));
        assertTrue("_E_+5+_pi_-6+_sin_50 cannot be fixed correctly", string20[2].equals("+5+"));
        assertTrue("_E_+5+_pi_-6+_sin_50 cannot be fixed correctly", string20[3].equals(String.valueOf(Math.PI)));
        assertTrue("_E_+5+_pi_-6+_sin_50 cannot be fixed correctly", string20[4].equals("-6+"));
        assertTrue("_E_+5+_pi_-6+_sin_50 cannot be fixed correctly", string20[5].equals(String.valueOf(Math.sin(Math.toRadians(50)))));


        //test "_Ne_432_/__(__E__+__pi__)_"
        String[] string21=Calculate.fixNotation(threeNotation[1]);
        assertTrue("_Ne_432_/__(__E__+__pi__)_ cannot be fixed correctly", string21[1].equals(String.valueOf((double)(0-432))));
        assertTrue("_Ne_432_/__(__E__+__pi__)_ cannot be fixed correctly", string21[3].equals("/"));
        assertTrue("_Ne_432_/__(__E__+__pi__)_ cannot be fixed correctly", string21[5].equals("("));
        assertTrue("_Ne_432_/__(__E__+__pi__)_ cannot be fixed correctly", string21[7].equals(String.valueOf(Math.E)));
        assertTrue("_Ne_432_/__(__E__+__pi__)_ cannot be fixed correctly", string21[9].equals("+"));
        assertTrue("_Ne_432_/__(__E__+__pi__)_ cannot be fixed correctly", string21[11].equals(String.valueOf(Math.PI)));

        //test fourNotation"_E__+__pi__*__sin_50_/__cos_30"
        String[] string30=Calculate.fixNotation(fourNotation);
        assertTrue("_E__+__pi__*__sin_50_/__cos_30 cannot be fixed correctly", string30[1].equals(String.valueOf(Math.E)));
        assertTrue("_E__+__pi__*__sin_50_/__cos_30 cannot be fixed correctly", string30[3].equals("+"));
        assertTrue("_E__+__pi__*__sin_50_/__cos_30 cannot be fixed correctly", string30[5].equals(String.valueOf(Math.PI)));
        assertTrue("_E__+__pi__*__sin_50_/__cos_30 cannot be fixed correctly", string30[7].equals("*"));
        assertTrue("_E__+__pi__*__sin_50_/__cos_30 cannot be fixed correctly", string30[9].equals(String.valueOf(Math.sin(Math.toRadians(50)))));
        assertTrue("_E__+__pi__*__sin_50_/__cos_30 cannot be fixed correctly", string30[11].equals("/"));
        assertTrue("_E__+__pi__*__sin_50_/__cos_30 cannot be fixed correctly", string30[13].equals(String.valueOf(Math.cos(Math.toRadians(30)))));

        //test tenNotation" _E__+__pi__-___sin_50_+__cos_60_/__tan_45_+__ln_7_/__lg_9_+__root_121_+_9_^_7_/__Ne_432"
        String[] stringfinal=Calculate.fixNotation(tenNotation);
        assertTrue(" _E__+__pi__-___sin_50_+__cos_60_/__tan_45_+__ln_7_/__lg_9_+__root_121_+_9_^_7_/__Ne_432 cannot be fixed correctly",
                stringfinal[1].equals(String.valueOf(Math.E)));
        assertTrue(" _E__+__pi__-___sin_50_+__cos_60_/__tan_45_+__ln_7_/__lg_9_+__root_121_+_9_^_7_/__Ne_432 cannot be fixed correctly",
                stringfinal[3].equals("+"));
        assertTrue(" _E__+__pi__-___sin_50_+__cos_60_/__tan_45_+__ln_7_/__lg_9_+__root_121_+_9_^_7_/__Ne_432 cannot be fixed correctly",
                stringfinal[5].equals(String.valueOf(Math.PI)));
        assertTrue(" _E__+__pi__-___sin_50_+__cos_60_/__tan_45_+__ln_7_/__lg_9_+__root_121_+_9_^_7_/__Ne_432 cannot be fixed correctly",
                stringfinal[7].equals("-"));
        assertTrue(" _E__+__pi__-___sin_50_+__cos_60_/__tan_45_+__ln_7_/__lg_9_+__root_121_+_9_^_7_/__Ne_432 cannot be fixed correctly",
                stringfinal[10].equals(String.valueOf(Math.sin(Math.toRadians(50)))));
        assertTrue(" _E__+__pi__-___sin_50_+__cos_60_/__tan_45_+__ln_7_/__lg_9_+__root_121_+_9_^_7_/__Ne_432 cannot be fixed correctly",
                stringfinal[12].equals("+"));
        assertTrue(" _E__+__pi__-___sin_50_+__cos_60_/__tan_45_+__ln_7_/__lg_9_+__root_121_+_9_^_7_/__Ne_432 cannot be fixed correctly",
                stringfinal[14].equals(String.valueOf(Math.cos(Math.toRadians(60)))));
        assertTrue(" _E__+__pi__-___sin_50_+__cos_60_/__tan_45_+__ln_7_/__lg_9_+__root_121_+_9_^_7_/__Ne_432 cannot be fixed correctly",
                stringfinal[16].equals("/"));
        assertTrue(" _E__+__pi__-___sin_50_+__cos_60_/__tan_45_+__ln_7_/__lg_9_+__root_121_+_9_^_7_/__Ne_432 cannot be fixed correctly",
                stringfinal[18].equals(String.valueOf(Math.tan(Math.toRadians(45)))));
        assertTrue(" _E__+__pi__-___sin_50_+__cos_60_/__tan_45_+__ln_7_/__lg_9_+__root_121_+_9_^_7_/__Ne_432 cannot be fixed correctly",
                stringfinal[20].equals("+"));
        assertTrue(" _E__+__pi__-___sin_50_+__cos_60_/__tan_45_+__ln_7_/__lg_9_+__root_121_+_9_^_7_/__Ne_432 cannot be fixed correctly",
                stringfinal[22].equals(String.valueOf(Math.log(7)/Math.log(Math.E))));
        assertTrue(" _E__+__pi__-___sin_50_+__cos_60_/__tan_45_+__ln_7_/__lg_9_+__root_121_+_9_^_7_/__Ne_432 cannot be fixed correctly",
                stringfinal[24].equals("/"));

        assertTrue(" _E__+__pi__-___sin_50_+__cos_60_/__tan_45_+__ln_7_/__lg_9_+__root_121_+_9_^_7_/__Ne_432 cannot be fixed correctly",
                stringfinal[26].equals(String.valueOf(Math.log(9)/Math.log(10))));
        assertTrue(" _E__+__pi__-___sin_50_+__cos_60_/__tan_45_+__ln_7_/__lg_9_+__root_121_+_9_^_7_/__Ne_432 cannot be fixed correctly",
                stringfinal[28].equals("+"));
        assertTrue(" _E__+__pi__-___sin_50_+__cos_60_/__tan_45_+__ln_7_/__lg_9_+__root_121_+_9_^_7_/__Ne_432 cannot be fixed correctly",
                stringfinal[32].equals("+"));
        assertTrue(" _E__+__pi__-___sin_50_+__cos_60_/__tan_45_+__ln_7_/__lg_9_+__root_121_+_9_^_7_/__Ne_432 cannot be fixed correctly",
                stringfinal[36].equals("/"));
        assertTrue(" _E__+__pi__-___sin_50_+__cos_60_/__tan_45_+__ln_7_/__lg_9_+__root_121_+_9_^_7_/__Ne_432 cannot be fixed correctly",
                stringfinal[38].equals(String.valueOf((double)(0-432))));


    }

    @Test
    public void calInSpeical() {
    }

    @Test
    public void isNumber() {
    }

    @Test
    public void deleteSpace() {
    }
}