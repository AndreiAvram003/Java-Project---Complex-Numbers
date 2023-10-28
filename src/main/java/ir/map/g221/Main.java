package ir.map.g221;


import domain.ComplexExpression;
import domain.ComplexNumber;
import domain.ExpressionParser;
import domain.ParseException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ExpressionParser parser = new ExpressionParser();
        try{
            ComplexExpression expr = parser.parse(args);
            ComplexNumber nmbr = expr.execute();
            System.out.println(nmbr);
        }
        catch(ParseException e){
            System.out.println(e.getMessage());
        }

    }
}