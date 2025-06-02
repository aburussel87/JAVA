public class strings {
    public static void prints(){
        String s = "Hello    My Fellow Mates";// searches in string pool,
            //if found, returns the reference of that string
            //if not, create a new string object in string pool
        String[] infos = s.split("\\s+");
        for(String str: infos){
            System.out.println(str);
        }
        String s1 = "Hello World";
        String s2 = s1;
        String s3 = new String("Hello World");//always creates a new string in the heap
        String s4 = s3.intern(); // explicitly adding new string to a string pool
        if(s1.equals(s4)){
            System.out.println("s1.equals(s4)");
        }
        if(s1 == s4){
            System.out.println("s1 == s4");
        }
        if(s1.equals(s3)){
            System.out.println("s1.equals(s3)");
        }
        if(s1 == s3){
            System.out.println("s1 == s3");
        }
        if(s1.equals(s2)){
            System.out.println("s1.equals(s2)");
        }
        if(s1 == s2){
            System.out.println("s1 == s2");
        }
    }
    public static void main(String[] args) {
        strings.prints();
    }
}
