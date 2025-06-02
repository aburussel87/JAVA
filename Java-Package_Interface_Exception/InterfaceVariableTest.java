import java.util.Random;

/*
 Variables are implicitly public static final
 But accessing depends on the reference. 
 if the reference is of sharedconstants, then we will get 1,2
 if the reference is of sharedconstants2, then we will get 2,3
 if the reference is of question class, we will get 6,8
 */
interface SharedConstants {
    int NO = 1;
    int YES = 2;
}

interface SharedConstants2 extends SharedConstants {
    int NO = 2;
    int YES = 3;
}

class Question implements SharedConstants2 {
    int NO = 6;
    int YES = 8;
    Random rand = new Random();

    int ask() {
        int prob = (int) (100 * rand.nextDouble());
        if (prob < 50)
            return NO;
        else
            return YES;
    }
}

public class InterfaceVariableTest {
    public static void main(String[] args) {
        SharedConstants2 q = new Question();
        // for (int i = 0; i < 10; i++) {
        // System.out.println(q.ask());
        // }
        System.out.println(q.NO);
        System.out.println(q.YES);
        SharedConstants ob1 = new SharedConstants2() {
            int NO = 5;
            int YES = 6;
        };
        System.out.println(ob1.NO);
        System.out.println(ob1.YES);
    }
}
