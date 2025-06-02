class M {
    private int x;
    public void setx(int i){
        x = i;
    }
    public void showx(){
        System.out.println(x);
    }
}
class N extends M{
    private int y ;
    public void sety(int y){
        this.y = y;
    }
    public void showy(){
        System.out.println(y);
    }
}
class O extends N{
    private int w ;
    public void setw(int w){
        this.w = w;
    }
    public void showw(){
        System.out.println(w);
    }
}
public class Main{
    public static void main(String[] args){
    O subob2 = new O();
    subob2.setw(0);
    subob2.setx(1);
    subob2.sety(2);
    subob2.showy();
    M superob = new M();
    superob.setx(0);
    superob = subob2;
    //superob.showy()--->superclass doent know anything about subclasses
    // same for superob.showw();
    //superob is a reference of class M which is currently refering to a subclas
    superob.showx();// perfect

    }
}
