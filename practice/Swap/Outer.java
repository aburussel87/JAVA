class Outer{
    private int x = 10;
    void test(){
        Inner inner = new Inner();
        inner.display();
    }
    class Inner{
        private int y  =11;
        void display(){
            System.out.println("Outer x: "+ x+"\nInner y: "+y);
        }
    }
    public static void main(String args[]){
        Outer outer  = new Outer();
        outer.test();
        Outer.Inner inner  = outer.new Inner();
        inner.display();
    }
}
