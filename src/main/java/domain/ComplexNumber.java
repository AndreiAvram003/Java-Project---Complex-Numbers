package domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Float.parseFloat;

public class ComplexNumber {
    private float re;
    private float im;

    public ComplexNumber(float re, float im) {
        this.re = re;
        this.im = im;
    }

    public ComplexNumber(String number) {
        Pattern pattern = Pattern.compile("^([-+]?\\d*\\.?\\d+)([-+]\\d*\\.?\\d*)?\\*i$");
        Matcher matcher = pattern.matcher(number);
        boolean matchFound = matcher.find();
        if(!matchFound){
            throw new ParseException(String.format("The number %s is not a valid complex number", number));
        }
        String realString = matcher.group(1);
        String imaginaryString = matcher.group(2);

        re = parseFloat(realString);
        im = parseFloat(imaginaryString);
    }

    public ComplexNumber add(ComplexNumber other){
        ComplexNumber nmb = new ComplexNumber(re,im);
        nmb.re = nmb.re + other.re;
        nmb.im = nmb.im+ other.im;
        return nmb;

    }
    public ComplexNumber sub(ComplexNumber other){
        ComplexNumber nmb = new ComplexNumber(re,im);
        nmb.re = nmb.re - other.re;
        nmb.im = nmb.im - other.im;
        return nmb;
    }
    public ComplexNumber multiply(ComplexNumber other){
        ComplexNumber nmb = new ComplexNumber(re,im);
        float re_old = nmb.re;
        nmb.re = (nmb.re * other.re) - (nmb.im * other.im);
        nmb.im = (re_old * other.im) + (nmb.im * other.re);
        return nmb;
    }
    public ComplexNumber divide(ComplexNumber other) {
        ComplexNumber nmb = new ComplexNumber(re, im);
        float re_old = nmb.re;
        nmb.re = (nmb.re * other.re + nmb.im * other.im) / (other.re * other.re + other.im * other.im);
        nmb.im = (nmb.im * other.re - re_old * other.im) / (other.re * other.re + other.im * other.im);
        return nmb;
    }

    public ComplexNumber conjugate (ComplexNumber other){
        other.im = other.im * (-1);
        return other;
    }
    @Override
    public String toString(){
        if(im<0){
            return String.format("%s %s*i",re,im);
        }
        return String.format("%s + %s*i",re,im);
    }
}
