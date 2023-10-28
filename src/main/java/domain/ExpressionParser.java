package domain;

import java.util.Vector;

public class ExpressionParser {
    private final ExpressionFactory expr = new ExpressionFactory();

    public ComplexExpression parse(String[] args) {
        if (args.length % 2 == 0 || args.length < 1) {
            throw new ParseException("Given expression is invalid");
        }
        Vector<ComplexNumber> numbers = extractNumbers(args);
        Vector<Operation> operands = extractOperands(args);
        validateAllOperands(operands);

        if (operands.isEmpty()) {
            return expr.createExpression(Operation.ADDITION, numbers);
        }
        return expr.createExpression(operands.getFirst(), numbers);
    }

    private Vector<ComplexNumber> extractNumbers(String[] args) {
        Vector<ComplexNumber> numbers = new Vector<ComplexNumber>();
        for (int i = 0; i < args.length; i = i + 2) {
            numbers.add(new ComplexNumber(args[i]));
        }
        return numbers;
    }

    private Vector<Operation> extractOperands(String[] args) {
        Vector<Operation> operands = new Vector<Operation>();
        for (int i = 1; i < args.length; i = i + 2) {
            operands.add(getOperationFromString(args[i]));
        }
        return operands;
    }

    private void validateAllOperands(Vector<Operation> operands) {
        for (int i = 0; i < operands.size() - 1; i++) {
            if (!operands.get(i).equals(operands.get(i + 1))) {
                throw new ParseException("Operands are different");
            }
        }
    }

    private Operation getOperationFromString(String str) {
        if (str.equals("+")) {
            return Operation.ADDITION;
        }
        if (str.equals("-")) {
            return Operation.SUBSTRACTION;
        }
        if (str.equals("*")) {
            return Operation.MULTIPLICATION;
        }
        if (str.equals("/")) {
            return Operation.DIVISION;
        }
        throw new ParseException(String.format("%s is not a valid operator", str));
    }
}
