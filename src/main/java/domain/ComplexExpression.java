package domain;

import java.util.Vector;


public abstract class ComplexExpression {

    Vector<ComplexNumber> v = new Vector<ComplexNumber>();

    public ComplexExpression(Vector<ComplexNumber> v) {
        this.v = v;
    }

    abstract public ComplexNumber executeOneExpression(ComplexNumber n1, ComplexNumber n2);
    public ComplexNumber execute(){
        if (v.size()==0){
            throw new RuntimeException("Vectorul este vid");
        }
        ComplexNumber accumulator = v.get(0);
        for (ComplexNumber nmb:v.stream().skip(1).toList()){
            accumulator =executeOneExpression(accumulator,nmb);
        }
        return accumulator;
    }
}
