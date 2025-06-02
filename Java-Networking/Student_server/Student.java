package Student_server;
import java.io.Serializable;

class SubjectMark implements Serializable{
    String name;
    Double mark;
    
    SubjectMark(String name, Double mark) {
        this.name = name;
        this.mark = mark;
    }
    
    public double getMark() {
        return mark;
    }
}

public class Student implements Serializable {
    private int ID;
    private String name;
    private SubjectMark[] marks;
    
    Student(int id, String name, SubjectMark[] marks) {
        this.ID = id;
        this.name = name;
        this.marks = marks;
    }
    
    double avg() {
        double total = 0;
        for (int i = 0; i < marks.length; i++) {
            total += marks[i].getMark();
        }
        return total / marks.length; 
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }
    
}
