enum month{
    January(31),February(28),March(31),April(30),May(31),June(30),July(31),August(31),September(30),October(31),November(30),December(31);
    private int days;
    boolean leapYear;
    month(int days){
        this.days = days;
        leapYear =false;
    }
    month(int days,boolean leapYear){
        this.days = days;
        this.leapYear = leapYear;
    }
    int getdays(){
        if(this == February && leapYear){
            return 29;
        }
        return days;
    }
}
public class months {
    public static void main(String[] args) {
        int x = 0;
        for(month m: month.values()){
            x += m.getdays();
            System.out.println(m.getdays());
        }
        System.out.println("Total days: "+x);
    }
}
