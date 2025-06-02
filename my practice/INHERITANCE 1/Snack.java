public class Snack extends FoodItem{
    private boolean isSpicy;
    
    public Snack(String name, double price, int quantity,boolean is) {
        super(name, price, quantity);
        this.isSpicy = is;
    }
    public void tooglespiciness(){
        if(isSpicy){
            isSpicy = false;
            System.err.println("Spiciness is disabled");
        }else{
            isSpicy = true;
            System.err.println("Spiciness is enabled");
        }
    }
    @Override
    public void displayInfo(){
        super.displayInfo();
        String s;
        if(isSpicy){
            s = "Yes";
        }else{
            s = "No";
        }
        System.out.println("Spicy: "+ s);
    }
}
