class myEx extends Exception {
    private int detail;
    myEx(int a) {
        detail = a;
    }
    @Override
    public String toString() {
        return "My Exception :  " + detail;
    }
}

public class ExceptionCustom {
    static void compute(int a) throws myEx {
        if (a > 10) {
            throw new myEx(a);
        }
        System.out.println(a);
    }
    public static void main(String args[]) {
        try {
            compute(10);
            compute(20);
        } catch (myEx e) {
            System.out.println(e);
        }
    }
}