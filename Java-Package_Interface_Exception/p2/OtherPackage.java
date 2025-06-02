package p2;

import p1.Protection;

public class OtherPackage {
    OtherPackage() {
        System.out.println("---OtherPackage---");
        Protection p = new Protection();
        //System.out.println(p.n); // n is not public in p1.Protection, can't be accessed from outside package, default member is visible only to the classes and subclasses of same package
        System.out.println(p.nPublic);
        //System.out.println(p.nProtected); //nProtected has protected access in p1.Protection,visible to only subclasses 
        //System.out.println(p.nPrivate); //nPrivate has private access in p1.Protection,visible to itself only
    }

    public static void main(String[] args) {
        Protection2 ob1 = new Protection2();
        OtherPackage ob2 = new OtherPackage();
    }
}
