package domain;

import java.util.Vector;

public class AdditionComplexExpression extends ComplexExpression {
    public AdditionComplexExpression(Vector<ComplexNumber> v) {
        super(v);
    }

    @Override
    public ComplexNumber executeOneExpression(ComplexNumber n1, ComplexNumber n2) {
        return n1.add(n2);
    }
}
