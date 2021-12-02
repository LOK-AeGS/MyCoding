package Guajae;
public class Calculator {
    double num1;
    double num2;
    char op;
    public Calculator(){
        this(0, ' ', 0);
    }
    public Calculator(double n1, char o, double n2){
        num1 = n1;
        op = o;
        num2 = n2;
    }
    public double compute() {
        switch (op){
            case '+': return num1 + num2;
            case '-': return num1 - num2;
            case '*': return num1 * num2;
            case '/': return num1 / num2;
            default: return Double.NaN;
        }
    }
}