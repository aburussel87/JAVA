class practice{
    public static void main(String[] args) {
        var a = 'a';
        char b;
        b = 'B';
        int x = 10;
        System.out.printf("%c %c %d\n",a,b,x);
        System.out.println("\"this is in quotes\" while this is not");
        if(x == 10){
            int y = x ;
            System.out.println(x +" "+y);
            x = y*2;
        }
        System.out.println(x);
        int arr[][], c;
        arr = new int[2][2];
        c = 2;
        for(int i = 0; i<2; i++){
            for(int j = 0; j<2; j++){
                arr[i][j] = i+j;
            }
        }
        System.out.println(c+" dimesional array");
        for(int i = 0; i<2; i++){
            for(int j = 0; j<2; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

        //Arrays of unequal arrays
        var arr1 = new int[4][];
        for(int i = 0 ; i<4; i++){
            arr1[i] = new int[i+1];
        }
        int k  = 0;
        for(int i = 0; i<4; i++)
        {
            for(int j = 0 ; j<i+1; j++){
                arr1[i][j] = k++;
            }
        }
        for(int i = 0; i<4; i++)
        {
            for(int j = 0 ; j<i+1; j++){
            System.out.print(arr1[i][j] +" ");
            }
            System.out.println();
        }
        int s = 10;
        int y = 5;
        s = s + y-(y=s);
        System.out.println(s+" "+y);
    }
}
