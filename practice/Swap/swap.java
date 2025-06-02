class swap {
    public static void main(String[] args) {
        int x = 10;
        int y = 11;
        x = x+(y-(y=x));
        System.out.printf("x - %d y - %d\n", x, y);
        int arr[] = { x, y };
        Swap(arr);
        x = arr[0];
        y = arr[1];
        System.out.printf("x - %d y - %d\n", x, y);
        String str[] = {"abc","a"};
        change(str);
        System.out.printf("%s %s\n",str[0],str[1]);
        Change(str[0],str[1]);
        System.out.printf("%s %s",str[0],str[1]);
    }

    /*
     ->Primitives (e.g., int, double)
     * Passed by value (copy of actual value).
     * Modifications inside the method don’t affect the original.
     * Objects (String, ArrayList, HashMap, etc.)
     
     ->objects 
     * Passed by value (copy of the reference).
     * The reference itself can't be changed, but if the object is mutable, its
     * contents can be modified.
     
     ->Immutable Objects (String, Integer)
     * Even though a reference is passed, a new object is created when modified, so
     * the original remains unchanged.
     */

     static void change(String str[]){
        str[0] = "hi";
        str[1]  = "russel";
     }

     static void Change(String a, String b){
        //though references(by value) of str[0] and str[1] are passed
        //doesnt affect the main string as String is immutable objects
        a = "abc";
        b = "a";
     }


    static void Swap(int[] arr) {
        int x = arr[0];
        arr[0] = arr[1];
        arr[1] = x;
        int a[] = { 2, 3 };
        arr = a; // this will have no effect in the main function
                 // becaues references themselves are passed by value
                 // so references cannot be modified though their contents can be modified
    }
};