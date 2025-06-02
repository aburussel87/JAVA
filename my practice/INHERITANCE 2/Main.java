class Animal {
    private String name;
    private int age;
    
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
        
    }
    public Animal(Animal ob){
        name = ob.name;
        age = ob.age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
     public boolean isLethalToAdultHumans(){
        return false;
    }
    // your code
}
class Bird extends Animal{
    Bird (String name, int age){
        super(name, age);
    }
    @Override
    public String toString() {
        return getName()+" is "+"Bird , age is "+ getAge();
    }
}
class Mammal extends Animal{
    public void printBloodType(){
        System.out.println("Warm blooded");
    }
    Mammal(String name, int age){
        super(name, age);
    }
    @Override
    public String toString() {
        return getName()+" is "+"Mammal , age is "+ getAge();
    }    

}
class Reptile extends Animal{
    Reptile (String name, int age){
        super(name, age);
    }
    @Override
    public String toString() {
        return getName()+" is "+"Reptile , age is "+ getAge();
    }
    @Override
    public boolean isLethalToAdultHumans(){
        return true;
    }
}
class Fish extends Animal{
    Fish (String name, int age){
        super(name, age);
    }
    @Override
    public String toString() {
        return getName()+" is "+"Fish , age is "+ getAge();
    }
}
class Arachnid extends Animal{
    Arachnid (String name, int age){
        super(name, age);
    }
    @Override
    public boolean isLethalToAdultHumans(){
        return true;
    }
    @Override
    public String toString() {
        return getName()+" is "+"Arachnid , age is "+ getAge()+" ";
    }
}
class Albatross extends Bird{
    Albatross (String name, int age){
        super(name, age);
    }
    @Override
    public String toString() {
        return getName()+" is "+"Albatross, age is "+ getAge()+" ";
    }
}
class Dog extends Mammal {
    Dog (String name, int age){
        super(name, age);
    }
    @Override
    public String toString() {
        return getName()+" is "+"Dog , age is "+ getAge()+" ";
    }
}
class FruitBat extends Mammal{
    FruitBat (String name, int age){
        super(name, age);
    }
    @Override
    public String toString() {
        return getName()+" is "+"FruitBat , age is "+ getAge()+" ";
    }
}
class EasternBrownSnake extends Reptile{
    EasternBrownSnake (String name, int age){
        super(name, age);
    }
    @Override
    public String toString() {
        return getName()+" is "+"EasternBrownSnake , age is "+ getAge()+" ";
    }
}
class GreatWhiteShark extends Fish{
    GreatWhiteShark (String name, int age){
        super(name, age);
    }
}
class RedBackSpider extends Arachnid{
    RedBackSpider (String name, int age){
        super(name, age);
    }
    @Override
    public String toString() {
        return getName()+" is "+"RedBackspider , age is "+ getAge()+" ";
    }
}
class Platypus extends Mammal{
    Platypus (String name, int age){
        super(name, age);
    }
    @Override
    public String toString() {
        return getName()+" is "+"Platypus , age is "+ getAge()+" ";
    }
}
class Human extends Mammal{
    Human (String name, int age){
        super(name, age);
    }

    @Override
    public String toString() {
        return getName()+" is "+"Human , age is "+ getAge()+" ";
    }
    
}
public class Main {
    public static void main(String[] args) {
        Bird alex = new Albatross("Alex", 39);
        Mammal spot = new Dog("Spot", 7);
        Mammal fred = new FruitBat("Fred", 10);
        Reptile steph = new EasternBrownSnake("Steph", 12);
        Fish bruce = new GreatWhiteShark("Bruce", 40);
        Arachnid charlotte = new RedBackSpider("Charlotte", 1);
        Mammal perry = new Platypus("Perry", 5);
        Mammal bob = new Human("Bob", 20);

        Animal[] animals = { alex, spot, fred, steph, bruce, charlotte, perry, bob };
        for (Animal a : animals) {
            System.out.print(a);
            if (a instanceof Mammal) {
                ((Mammal) a).printBloodType();
            }
            if (a.isLethalToAdultHumans()) {
                System.out.print(", and it's lethal!");
            }
            System.out.println();
        }
        System.out.println();
    }
}

