class MyException extends Exception {
    String details;

    MyException(String s) {
        details = s;
    }

    @Override
    public String getMessage() { 
        return details;
    }
}

public class Exceptioncustom2 {

    static int compute(int a) throws MyException {
        if (a < 0) {
            throw new MyException("Negative integer exception");
        }
        return a;
    }

    public static void main(String[] args) {
        try {
            System.out.println(compute(2));
            System.out.println(compute(10));
            System.out.println(compute(-2));
        } catch (MyException e) {
            System.out.println(e);
        }
    }
}
