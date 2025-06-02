class practice{
    public static void main(String args[]){
        String s1 = args[0];
        String s2 = args[1];
        String s3 = args[2];
        String s4 = s1 +" "+ s2 +" "+ s3;
        System.out.println(s4);
        String s5 = "command";

        if(s1.equals(s5)){
            System.out.println("s1 == s5");
        }else{
            System.out.println("s1 != s5");
        }

        if(s1==s5){
            System.out.println("s1 == s5");
        }else{
            System.out.println("s1 != s5");
        }

        System.out.println("length of s1: "+s1.length());
        System.out.printf("%s %s %s",s1,s2,s3);
        }
}