package domain;

import java.util.Vector;

public class MultiplicationComplexExpression extends ComplexExpression{
    public MultiplicationComplexExpression(Vector<ComplexNumber> v) {
        super(v);
    }

    @Override
    public ComplexNumber executeOneExpression(ComplexNumber n1, ComplexNumber n2) {
        return n1.multiply(n2);
    }
}
