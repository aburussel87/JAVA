public class Dessert extends FoodItem {
    private int calories;

    public Dessert(String name, double price, int quantity, int calories) {
        super(name, price, quantity);
        this.calories = calories;
    }
    public void halfServing(){
        setQuantity(getQuantity()/2);
        calories = calories/2;
        setPrice(getPrice()/2);
        System.out.println("half-serving is enabled for dessert");
    }
    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Calories: "+calories+" kcal");
    }
     
}
