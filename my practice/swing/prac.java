import javax.swing.JOptionPane;
public class prac {

    public static void main(String[] args) {
        String s1 = JOptionPane.showInputDialog(null,"Enter 1st number");
        String s2 = JOptionPane.showInputDialog(null,"Enter 2nd number");
        int num1 = Integer.parseInt(s1);
        int num2 = Integer.parseInt(s2);
        num1 += num2 - (num2 = num1);
        JOptionPane.showMessageDialog(null,"After swapping : num1  = " +num1+" and num2 = "+num2); 
    }
}