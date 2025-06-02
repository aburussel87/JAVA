package collections;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


// class TestClassComparator implements Comparator<TestClass> {
//     @Override
//     public int compare(TestClass o1, TestClass o2) {
//         //return o1.getName().compareTo(o2.getName());
//         return o1.getId() - o2.getId();
//     }
//}


class TestClass implements Comparable<TestClass> {

    private String name;
    private int id;

    TestClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public int compareTo(TestClass o) {
        if(id==o.id){
            return o.name.compareTo(name);
        }
        return o.id-id;
        //return this.name.compareTo(o.name);
    }
    @Override
    public String toString(){
        return id+","+name;
    }
}

class ComparatorDemo {
    public static void printList(List<TestClass> al) {
        for (TestClass ob: al) {
            System.out.println(ob);
        }
        System.out.println();
    }

    public static void main(String args[]) {
        List<TestClass> al = new ArrayList<>();
        al.add(new TestClass(1, "C"));
        al.add(new TestClass(2, "A"));
        al.add(new TestClass(2, "E"));
        al.add(new TestClass(5, "B"));
        al.add(new TestClass(4, "D"));
        al.add(new TestClass(6, "F"));
        printList(al);
        Collections.sort(al);
        printList(al);
       //Collections.sort(al, new TestClassComparator());
        // printList(al);
        // List<points> p = new ArrayList<>();
        // p.add(new points(1,2));
        // p.add(new points(0, 0));
        // p.add(new points(-1,-2));
        // Collections.sort(p);
        // points.printpoints(p);
    }
}

// class points implements Comparable<points>{
//     int x,y;
//     points(int x, int y){
//         this.x = x;
//         this.y = y;
//     }
//     @Override
//     public int compareTo(points p){
//         return this.x-p.x;
//     }
//     static void printpoints(List<points> z){
//         points[] arr = new points[z.size()];
//         z.toArray(arr);
//         for(points p: arr){
//             System.out.println(p.x+" "+p.y);
//         }
//     }
// }