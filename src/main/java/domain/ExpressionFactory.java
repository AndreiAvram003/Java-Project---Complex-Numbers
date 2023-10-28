package domain;

import java.util.Vector;

public class ExpressionFactory {
    public ComplexExpression createExpression(Operation operation, Vector<ComplexNumber> args) {
        if (operation == Operation.ADDITION) {
            AdditionComplexExpression expr = new AdditionComplexExpression(args);
            return expr;
        } else if (operation == Operation.SUBSTRACTION) {
            SubstractionComplexExpression expr = new SubstractionComplexExpression(args);
            return expr;
        } else if (operation == Operation.DIVISION) {
            DivisionComplexExpression expr = new DivisionComplexExpression(args);
            return expr;
        } else {
            MultiplicationComplexExpression expr = new MultiplicationComplexExpression(args);
            return expr;
        }
    }
}
