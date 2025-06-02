public class Beverage extends FoodItem{
    private String size;
    boolean hasIce;
    public Beverage(String name, double price, int quantity, String size) {
        super(name, price, quantity);
        this.size = size;
        this.hasIce = false;
    }
    void addIce(boolean x ){
        this.hasIce  = x;
        System.out.println("Ice has been added to your beverage");
    }
    @Override
   public void displayInfo(){
        super.displayInfo();
        String s;
        if(hasIce){
            s = "Yes";
        }else{
            s = "No";
        }
        System.out.println("Size: "+size+"  Ice: "+ s);
    } 
}
