package p2;

import p1.Protection;

class Protection2 extends Protection {
    Protection2() {
        System.out.println("---Protection2---");
        // System.out.println(n); // n is not public in p1.Protection, can't be accessed
        // from outside package(visible in the same package)
        System.out.println(nProtected);// visible to all the subclasses even if it is in different package
        System.out.println(nPublic);// visible to all in and other package
        // System.out.println(nPrivate); //nPrivate has private access in
        // p1.Protection(visible to only itself even if in the same classes)
    }
}
