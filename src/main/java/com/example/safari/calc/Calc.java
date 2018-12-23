package com.example.safari.calc;

import businnessLogic.Inputs;

public class Calc {

    public int execute(Inputs inputs){
        String operation = inputs.getOp1();
        int res;

        switch(operation) {
            case "*" :
                res = inputs.getNumb1() * inputs.getNumb2();
                break;
            case "+" :
                res = inputs.getNumb1() + inputs.getNumb2();
                break;
            case "-" :
                res = inputs.getNumb1() - inputs.getNumb2();
                break;
            case "/" :
                res = inputs.getNumb1() / inputs.getNumb2();
                break;
            default :
                res = 0;
        }

        return  res;
    }
}
