package domain;

import java.util.Vector;

public class DivisionComplexExpression extends ComplexExpression {
    public DivisionComplexExpression(Vector<ComplexNumber> v) {
        super(v);
    }

    @Override
    public ComplexNumber executeOneExpression(ComplexNumber n1, ComplexNumber n2) {
        return n1.divide(n2);
    }
}
