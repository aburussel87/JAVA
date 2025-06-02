public class varargs {
    static void printnums(int ... numbers){
        for(int x:numbers){
            System.out.print(x+" ");
        }
        System.out.println();
    }
    static void printnums(int a,int b){
        System.out.println("In specific method: "+a+" "+b);
    }
    static void prints(String msg,int ... numbers){//varargs must be the last parameter
        System.out.println(msg+": ");
        for(int x:numbers){
            System.out.print(x+" ");
        }
        System.out.println();
    }
    static void printnums(boolean ... numbers){

    }
        // ambiguous-> printnums(int ... numbers)
    // static void printnums(int a, int ... numbers){
    //     for(int x:numbers){
    //         System.out.print(x+" ");
    //     }
    //     System.out.println();
    // }



    public static void main(String[] args) {
        printnums(1,2);//java calls the specific avoiding overhead
        printnums(1,2,3);
        //printnums(null); // ambiguous -> printnums(int ... numbers) ? or printnums(boolean ... numbers)? 
        prints("My marks",1,2,3,4);
    }
}
