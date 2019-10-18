package com.example.sccl;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class CalculateTest {
    final String[] oneNotation = new String[]{"_E_+5", "_pi_-6", "_sin_50", "_cos_30", "_tan_45", "_ln_7", "_lg_9", "_root_121", "7.4_^_9.8", "_Ne_432"};
    final String[] twoNotation = new String[]{"_(_sin_30_)_*_(__root_121_)_", "7_^_9_-__Ne_432"};
    final String[] threeNotation = new String[]{"_E_+_5_+__pi__-_6_+__sin_50", "_Ne_432_/__(__E__+__pi__)_"};
    final String fourNotation = "_E__+__pi__*__sin_50_/__cos_30";
    final String tenNotation = " _E__+__pi__-___sin_50_+__cos_60_/__tan_45_+__ln_7_/_root_121_+__lg_9__^_7_/__Ne_432";
    final String[] ErrorFuncion = {"_+__+_6", "23_-__-_7", "342_+__/_9", "6_^__root_"};


    @Test
    public void getResult() {
        //test Strings with one notation
        assertTrue("Cannot get correct result of " + oneNotation[0], Calculate.getResult(oneNotation[0]).equals(String.valueOf((double) 5)));
        assertTrue("Cannot get correct result of " + oneNotation[1], Calculate.getResult(oneNotation[1]).equals(String.valueOf((double) (-6))));
        assertTrue("Cannot get correct result of " + oneNotation[2], Calculate.getResult(oneNotation[2]).equals(String.valueOf(Math.sin(Math.toRadians(50)))));
        assertTrue("Cannot get correct result of " + oneNotation[3], Calculate.getResult(oneNotation[3]).equals(String.valueOf(Math.cos(Math.toRadians(30)))));

        assertTrue("Cannot get correct result of " + oneNotation[4], Calculate.getResult(oneNotation[4]).equals(String.valueOf(Math.tan(Math.toRadians(45)))));

        assertTrue("Cannot get correct result of " + oneNotation[5], Calculate.getResult(oneNotation[5]).equals(String.valueOf(Math.log(7) / Math.log(Math.E))));
        assertTrue("Cannot get correct result of " + oneNotation[6], Calculate.getResult(oneNotation[6]).equals(String.valueOf(Math.log(9) / Math.log(10))));
        assertTrue("Cannot get correct result of " + oneNotation[7], Calculate.getResult(oneNotation[7]).equals(String.valueOf(Math.sqrt(121))));
        assertTrue("Cannot get correct result of " + oneNotation[8], Calculate.getResult(oneNotation[8]).equals(String.valueOf(Math.pow(7.4, 9.8))));
        assertTrue("Cannot get correct result of " + oneNotation[9], Calculate.getResult(oneNotation[9]).equals(String.valueOf((double) (0 - 432))));

        //test Strings with two notations
        assertTrue("Cannot get correct result of " + twoNotation[0], Calculate.getResult(twoNotation[0]).equals(String.valueOf(Math.sin(Math.toRadians(30)) * Math.sqrt(121))));
        assertTrue("Cannot get correct result of " + twoNotation[1], Calculate.getResult(twoNotation[1]).equals(String.valueOf(Math.pow(7, 9) - (0 - 432))));

        //test Strings with three notations
        assertTrue("Cannot get correct result of " + threeNotation[0], Calculate.getResult(threeNotation[0]).equals(String.valueOf(Math.E + 5 + Math.PI - 6 + Math.sin(Math.toRadians(50)))));
        assertTrue("Cannot get correct result of " + threeNotation[0], Calculate.getResult(threeNotation[1]).equals(String.valueOf((0 - 432) / (Math.E + Math.PI))));

        //test String with four notations
        assertTrue("Cannot get correct resulg of " + fourNotation, Calculate.getResult(fourNotation).equals(String.valueOf(Math.E + Math.PI * Math.sin(Math.toRadians(50)) / Math.cos(Math.toRadians(30)))));

        //test String with ten notations
        //_E__+__pi__-___sin_50_+__cos_60_/__tan_45_+__ln_7_/_root_121_+__lg_9__^_7_/__Ne_432
        assertTrue("Cannot get correct result of " + tenNotation, Calculate.getResult(tenNotation).equals(String.valueOf(
                Math.E + Math.PI - Math.sin(Math.toRadians(50)) + Math.cos(Math.toRadians(60)) / Math.tan(Math.toRadians(45)) + Math.log(7) / Math.log(Math.E) / Math.sqrt(121) + Math.pow(Math.log(9) / Math.log(10), 7) / (-432)
        )));

        //test string with error notations
        for (String s : ErrorFuncion) {
            assertTrue(s + ": " + "get reult of error functions incorrectly", Calculate.getResult(s).equals("error"));
        }


    }

    @Test
    public void transform() {

        //test String with one notation

        List<String> result00 = new ArrayList<>();
        result00.add(String.valueOf(Math.E));
        result00.add("+5");
        assertTrue(oneNotation[0] + "cannot be transformed correctly", Calculate.transform(oneNotation[0]).equals(result00));

        List<String> result01 = new ArrayList<>();
        result01.add(0, String.valueOf(Math.PI));
        result01.add(1, "-6");
        assertTrue(oneNotation[1] + "_pi_-6 cannot be transformed correctly", Calculate.transform(oneNotation[1]).equals(result01));

        List<String> result02 = new ArrayList<>();
        result02.add(0, String.valueOf(Math.sin(Math.toRadians(50))));
        assertTrue(oneNotation[2] + " cannot be transformed correctly", Calculate.transform(oneNotation[2]).equals(result02));

        List<String> result03 = new ArrayList<>();
        result03.add(0, String.valueOf(Math.cos(Math.toRadians(30))));
        assertTrue(oneNotation[3] + " cannot be transformed correctly", Calculate.transform(oneNotation[3]).equals(result03));

        List<String> result04 = new ArrayList<>();
        result04.add(0, String.valueOf(Math.tan(Math.toRadians(45))));
        assertTrue(oneNotation[4] + " cannot be transformed correctly", Calculate.transform(oneNotation[4]).equals(result04));

        List<String> result05 = new ArrayList<>();
        result05.add(0, String.valueOf(Math.log(7) / Math.log(Math.E)));
        assertTrue(oneNotation[5] + " cannot be transformed correctly", Calculate.transform(oneNotation[5]).equals(result05));

        List<String> result06 = new ArrayList<>();
        result06.add(0, String.valueOf(Math.log(9) / Math.log(10)));
        assertTrue(oneNotation[6] + " cannot be transformed correctly", Calculate.transform(oneNotation[6]).equals(result06));

        List<String> result07 = new ArrayList<>();
        result07.add(0, String.valueOf(Math.sqrt(121)));
        assertTrue(oneNotation[7] + " cannot be transformed correctly", Calculate.transform(oneNotation[7]).equals(result07));

        List<String> result08 = new ArrayList<>();
        result08.add(0, String.valueOf(Math.pow(7.4, 9.8)));
        assertTrue(oneNotation[8] + " cannot be transformed correctly", Calculate.transform(oneNotation[8]).equals(result08));

        List<String> result09 = new ArrayList<>();
        result09.add(0, String.valueOf((double) (0 - 432)));
        assertTrue(oneNotation[9] + " cannot be transformed correctly", Calculate.transform(oneNotation[9]).equals(result09));

        //test Strings with two notations
        List<String> result10 = new ArrayList<>();//_(_sin_30_)_*_(__root_121_)_
        result10.add(String.valueOf(Math.sin(Math.toRadians(30))));
        result10.add(String.valueOf(Math.sqrt(121)));
        result10.add("*");
        assertTrue(twoNotation[0] + " cannot be transformed correctly", Calculate.transform(twoNotation[0]).equals(result10));

        List<String> result11 = new ArrayList<>();//"7_^_9_-__Ne_432"
        result11.add(String.valueOf(Math.pow(7, 9)));
        result11.add(String.valueOf((double) (0 - 432)));
        result11.add("-");
        assertTrue(twoNotation[1] + "cannot be transformed correctly", Calculate.transform(twoNotation[1]).equals(result11));

        //test Strings with three notations
        List<String> result20 = new ArrayList<>();//"_E_+5+_pi_-6+_sin_50"
        result20.add(String.valueOf(Math.E));
        result20.add("5");
        result20.add("+");
        result20.add(String.valueOf(Math.PI));
        result20.add("+");
        result20.add("6");
        result20.add("-");

        result20.add(String.valueOf(Math.sin(Math.toRadians(50))));
        result20.add("+");
        assertTrue(threeNotation[0] + "cannot be transformed correctly", Calculate.transform(threeNotation[0]).equals(result20));

        List<String> result21 = new ArrayList<>();//"_Ne_432_/__(__E__+__pi__)_"
        result21.add(String.valueOf((double) 0 - 432));
        result21.add(String.valueOf(Math.E));
        result21.add(String.valueOf(Math.PI));
        result21.add("+");
        result21.add("/");
        assertTrue(threeNotation[1] + "cannot be transformed correctly", Calculate.transform(threeNotation[1]).equals(result21));

        //test Strings with four notations
        List<String> result30 = new ArrayList<>();//"_E__+__pi__*__sin_50_/__cos_30";
        result30.add(String.valueOf(Math.E));
        result30.add(String.valueOf(Math.PI));
        result30.add(String.valueOf(Math.sin(Math.toRadians(50))));
        result30.add("*");
        result30.add(String.valueOf(Math.cos(Math.toRadians(30))));
        result30.add("/");
        result30.add("+");
        assertTrue(fourNotation + "cannot be transformed correctly", Calculate.transform(fourNotation).equals(result30));

        //test Strings with ten notations
        List<String> finalResult = new ArrayList<>();//" _E__+__pi__-___sin_50_+__cos_60_/__tan_45_+__ln_7_/__lg_9_+__root_121_+_9_^_7_/__Ne_432"
        finalResult.add(String.valueOf(Math.E));
        finalResult.add(String.valueOf(Math.PI));
        finalResult.add("+");
        finalResult.add(String.valueOf(Math.sin(Math.toRadians(50))));
        finalResult.add("-");
        finalResult.add(String.valueOf(Math.cos(Math.toRadians(60))));
        finalResult.add(String.valueOf(Math.tan(Math.toRadians(45))));
        finalResult.add("/");
        finalResult.add("+");
        finalResult.add(String.valueOf(Math.log(7) / Math.log(Math.E)));
        finalResult.add(String.valueOf(Math.sqrt(121)));
        finalResult.add("/");
        finalResult.add("+");

        finalResult.add(String.valueOf(Math.pow(Math.log(9) / Math.log(10), 7)));


        finalResult.add(String.valueOf((double) (0 - 432)));
        finalResult.add("/");
        finalResult.add("+");
        assertTrue(tenNotation + "cannot be transfored correctly", Calculate.transform(tenNotation).equals(finalResult));


    }

    @Test
    public void fixNotation() {


        //test "_E_+5"
        String[] string00 = Calculate.fixNotation(oneNotation[0]);
        assertTrue("_E_ cannot be fixed correctly", string00[1].equals(String.valueOf(Math.E)));
        assertTrue("+5  cannot be fixed correctly", string00[2].equals("+5"));

        //test "_pi_-6"
        String[] string01 = Calculate.fixNotation(oneNotation[1]);
        assertTrue("_E_ cannot be fixed correctly", string01[1].equals(String.valueOf(Math.PI)));
        assertTrue("+5  cannot be fixed correctly", string01[2].equals("-6"));

        //test "_sin_50"
        String[] string02 = Calculate.fixNotation(oneNotation[2]);
        assertTrue("_sin_50 cannot be fixed correctly", string02[1].equals(String.valueOf(Math.sin(Math.toRadians(50)))));

        //test "_cos_30"
        String[] string03 = Calculate.fixNotation(oneNotation[3]);
        assertTrue("_cos_30 cannot be fixed correctly", string03[1].equals(String.valueOf(Math.cos(Math.toRadians(30)))));

        //test"_tan_45"
        String[] string04 = Calculate.fixNotation(oneNotation[4]);
        assertTrue("_tan_45 cannot be fixed correctly", string04[1].equals(String.valueOf(Math.tan(Math.toRadians(45)))));

        //test "_ln_7"
        String[] string05 = Calculate.fixNotation(oneNotation[5]);
        assertTrue("_ln_7 cannot be fixed correctly", string05[1].equals(String.valueOf(Math.log(7) / Math.log(Math.E))));

        //test "_lg_9"
        String[] string06 = Calculate.fixNotation(oneNotation[6]);
        assertTrue("_lg_9 cannot be fixed correctly", string06[1].equals(String.valueOf(Math.log(9) / Math.log(10))));

        //test"_root_121"
        String[] string07 = Calculate.fixNotation(oneNotation[7]);
        assertTrue("_root_121 cannot be fixed correctly", string07[1].equals(String.valueOf(Math.sqrt(121))));

        //test"7.4_^_9.8"
        String[] string08 = Calculate.fixNotation(oneNotation[8]);
        assertTrue("7.4_^_9.8 cannot be fixed correctly", string08[1].equals(String.valueOf(Math.pow(7.4, 9.8))));

        //test"_Ne_432"
        String[] string09 = Calculate.fixNotation(oneNotation[9]);
        assertTrue("_Ne_432 cannot be fixed correctly", string09[1].equals(String.valueOf((double) (0 - 432))));


        //test"_(_sin_30_)_*_(__root_121_)_"
        String[] string10 = Calculate.fixNotation(twoNotation[0]);
        assertTrue("_(_sin_30_)_*_(__root_121_)_ cannot be fixed correctly", string10[1].equals("("));
        assertTrue("_(_sin_30_)_*_(__root_121_)_ cannot be fixed correctly", string10[2].equals(String.valueOf(Math.sin(Math.toRadians(30)))));
        assertTrue("_(_sin_30_)_*_(__root_121_)_ cannot be fixed correctly", string10[4].equals(")"));
        assertTrue("_(_sin_30_)_*_(__root_121_)_ cannot be fixed correctly", string10[5].equals("*"));
        assertTrue("_(_sin_30_)_*_(__root_121_)_ cannot be fixed correctly", string10[6].equals("("));
        assertTrue("_(_sin_30_)_*_(__root_121_)_ cannot be fixed correctly", string10[8].equals(String.valueOf(Math.sqrt(121))));
        assertTrue("_(_sin_30_)_*_(__root_121_)_ cannot be fixed correctly", string10[10].equals(")"));

        //test"7_^_9_-__Ne_432"
        String[] string11 = Calculate.fixNotation(twoNotation[1]);
        assertTrue("7_^_9_-__Ne_432 cannot be fixed correctly", string11[1].equals(String.valueOf(Math.pow(7, 9))));
        assertTrue("7_^_9_-__Ne_432 cannot be fixed correctly", string11[3].equals("-"));
        assertTrue("7_^_9_-__Ne_432 cannot be fixed correctly", string11[5].equals(String.valueOf((double) 0 - 432)));

        //test "_E_+5+_pi_-6+_sin_50"
        String[] string20 = Calculate.fixNotation(threeNotation[0]);
        assertTrue("_E_+5+_pi_-6+_sin_50 cannot be fixed correctly", string20[1].equals(String.valueOf(Math.E)));
        assertTrue("_E_+5+_pi_-6+_sin_50 cannot be fixed correctly", string20[2].equals("+"));
        assertTrue("_E_+5+_pi_-6+_sin_50 cannot be fixed correctly", string20[3].equals("5"));
        assertTrue("_E_+5+_pi_-6+_sin_50 cannot be fixed correctly", string20[4].equals("+"));
        assertTrue("_E_+5+_pi_-6+_sin_50 cannot be fixed correctly", string20[6].equals(String.valueOf(Math.PI)));
        assertTrue("_E_+5+_pi_-6+_sin_50 cannot be fixed correctly", string20[8].equals("-"));
        assertTrue("_E_+5+_pi_-6+_sin_50 cannot be fixed correctly", string20[9].equals("6"));
        assertTrue("_E_+5+_pi_-6+_sin_50 cannot be fixed correctly", string20[10].equals("+"));
        assertTrue("_E_+5+_pi_-6+_sin_50 cannot be fixed correctly", string20[12].equals(String.valueOf(Math.sin(Math.toRadians(50)))));

        //test "_Ne_432_/__(__E__+__pi__)_"
        String[] string21 = Calculate.fixNotation(threeNotation[1]);
        assertTrue("_Ne_432_/__(__E__+__pi__)_ cannot be fixed correctly", string21[1].equals(String.valueOf((double) (0 - 432))));
        assertTrue("_Ne_432_/__(__E__+__pi__)_ cannot be fixed correctly", string21[3].equals("/"));
        assertTrue("_Ne_432_/__(__E__+__pi__)_ cannot be fixed correctly", string21[5].equals("("));
        assertTrue("_Ne_432_/__(__E__+__pi__)_ cannot be fixed correctly", string21[7].equals(String.valueOf(Math.E)));
        assertTrue("_Ne_432_/__(__E__+__pi__)_ cannot be fixed correctly", string21[9].equals("+"));
        assertTrue("_Ne_432_/__(__E__+__pi__)_ cannot be fixed correctly", string21[11].equals(String.valueOf(Math.PI)));

        //test fourNotation"_E__+__pi__*__sin_50_/__cos_30"
        String[] string30 = Calculate.fixNotation(fourNotation);
        assertTrue("_E__+__pi__*__sin_50_/__cos_30 cannot be fixed correctly", string30[1].equals(String.valueOf(Math.E)));
        assertTrue("_E__+__pi__*__sin_50_/__cos_30 cannot be fixed correctly", string30[3].equals("+"));
        assertTrue("_E__+__pi__*__sin_50_/__cos_30 cannot be fixed correctly", string30[5].equals(String.valueOf(Math.PI)));
        assertTrue("_E__+__pi__*__sin_50_/__cos_30 cannot be fixed correctly", string30[7].equals("*"));
        assertTrue("_E__+__pi__*__sin_50_/__cos_30 cannot be fixed correctly", string30[9].equals(String.valueOf(Math.sin(Math.toRadians(50)))));
        assertTrue("_E__+__pi__*__sin_50_/__cos_30 cannot be fixed correctly", string30[11].equals("/"));
        assertTrue("_E__+__pi__*__sin_50_/__cos_30 cannot be fixed correctly", string30[13].equals(String.valueOf(Math.cos(Math.toRadians(30)))));

        //test tenNotation" _E__+__pi__-___sin_50_+__cos_60_/__tan_45_+__ln_7_/__lg_9_+__root_121_+_9_^_7_/__Ne_432"
        String[] stringfinal = Calculate.fixNotation(tenNotation);
        assertTrue(tenNotation + "  cannot be fixed correctly",
                stringfinal[1].equals(String.valueOf(Math.E)));
        assertTrue(tenNotation + "  cannot be fixed correctly",
                stringfinal[3].equals("+"));
        assertTrue(tenNotation + "  cannot be fixed correctly",
                stringfinal[5].equals(String.valueOf(Math.PI)));
        assertTrue(tenNotation + "  cannot be fixed correctly",
                stringfinal[7].equals("-"));
        assertTrue(tenNotation + "  cannot be fixed correctly",
                stringfinal[10].equals(String.valueOf(Math.sin(Math.toRadians(50)))));
        assertTrue(tenNotation + "  cannot be fixed correctly",
                stringfinal[12].equals("+"));
        assertTrue(tenNotation + "  cannot be fixed correctly",
                stringfinal[14].equals(String.valueOf(Math.cos(Math.toRadians(60)))));
        assertTrue(tenNotation + "  cannot be fixed correctly",
                stringfinal[16].equals("/"));
        assertTrue(tenNotation + "  cannot be fixed correctly",
                stringfinal[18].equals(String.valueOf(Math.tan(Math.toRadians(45)))));
        assertTrue(tenNotation + "  cannot be fixed correctly",
                stringfinal[20].equals("+"));
        assertTrue(tenNotation + "  cannot be fixed correctly",
                stringfinal[22].equals(String.valueOf(Math.log(7) / Math.log(Math.E))));
        assertTrue(tenNotation + "  cannot be fixed correctly",
                stringfinal[24].equals("/"));
        assertTrue(tenNotation + "  cannot be fixed correctly",
                stringfinal[25].equals(String.valueOf(Math.sqrt(121))));
        assertTrue(tenNotation + "  cannot be fixed correctly",
                stringfinal[27].equals("+"));
        assertTrue(tenNotation + "  cannot be fixed correctly",
                stringfinal[32].equals(String.valueOf(Math.pow(Math.log(9) / Math.log(10), 7))));
        assertTrue(tenNotation + "  cannot be fixed correctly",
                stringfinal[34].equals("/"));
        assertTrue(tenNotation + "  cannot be fixed correctly",
                stringfinal[36].equals(String.valueOf((double) (0 - 432))));


    }

    @Test
    public void calInSpeical() {

    }

    @Test
    public void isNumber() {
    }


}