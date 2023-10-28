package domain;

import java.util.Vector;

public class SubstractionComplexExpression extends ComplexExpression{
    public SubstractionComplexExpression(Vector<ComplexNumber> v) {
        super(v);
    }

    @Override
    public ComplexNumber executeOneExpression(ComplexNumber n1, ComplexNumber n2) {
        return n1.sub(n2);
    }
}
