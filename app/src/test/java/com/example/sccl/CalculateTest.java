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
        String[] oneNotation=new String[]{"_E_+5","_pi_-6","_sin_50","_cos_30","_tan_45","_ln_7","_lg_9","_root_121","7_^_9","_Ne_432"};
        String[] twoNotation=new String[]{"_sin__E_", "_sin__pi_+7", "(_tan_45)*(_ln_7)", "(_lg_9)/(_root_121)", "7_^_9-_Ne_432"};
        String[] threeNotation=new String[]{"_E_+5+_pi_-6+_sin_50","_cos_30*_tan_45+_ln_7", "_lg_9*_root_121+7_^_9","_Ne_432/(_E_+_pi_)" };
        String[] fourNotation=new String[]{"_E_+_pi_*_sin_50/_cos_30","_tan_45-_ln_7+_lg_9*_root_121","7_^_9-_Ne_432"};
        String[] fiveNotatio=new String[]{
                "_E_+_pi_*_sin_60-_cos_30+_tan60_",
                "_ln_9+_root_121-7_^_9/_Ne_432"};
        String[] sixNotation=new String[]{
                "_E_+_pi_-_sin_50+_cos_60/_tan_45+_ln_7",
                "_lg_9/_root_121+7_^_9+_Ne_322-_E_+_pi_"};
        String[] sevenNotaion=new String[]{
                "_E_+_pi_-_sin_50+_cos_60/_tan_45+_ln_7/_lg_9",
                "_lg_9/_root_121+7_^_9+_Ne_322-_E_+_pi_*_sin_50"};
        String[] eightNotation=new String[]{"_E_+_pi_-_sin_50+_cos_60/_tan_45+_ln_7/_lg_9+_root_121",
                "_lg_9/_root_121+7_^_9+_Ne_322-_E_+_pi_*_sin_50+_E_"};
        String[] nineNotation=new String[]{
                "_E_+_pi_-_sin_50+_cos_60/_tan_45+_ln_7/_lg_9+_root_121+9_^_7",
                "_lg_9/_root_121+7_^_9+_Ne_322-_E_+_pi_*_sin_50+_E_+_pi_"
        };
        String tenNotation= " _E_+_pi_-_sin_50+_cos_60/_tan_45+_ln_7/_lg_9+_root_121+9_^_7/_Ne_432";
        assertTrue("_E_ could be fixed correctly",);



    }

    @Test
    public void isNumber() {
    }
}