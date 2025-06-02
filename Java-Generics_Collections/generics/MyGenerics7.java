package generics;

// class TwoD {
//     int x, y;

//     TwoD(int x, int y) {
//         this.x = x;
//         this.y = y;
//     }
// }

// class ThreeD extends TwoD {
//     int z;
//     ThreeD(int x, int y, int z) {
//         super(x, y);
//         this.z = z;
//     }
// }

// class FourD extends ThreeD {
//     int t;

//     FourD(int x, int y, int z, int t) {
//         super(x, y, z);
//         this.t = t;
//     }
// }

// class Coords<T extends TwoD> {
//     T[] coords;

//     Coords(T[] coords) {
//         this.coords = coords;
//     }
// }

// class BoundedWildcard {
//     static void showXY(Coords<?> c) {
//         for (int i = 0; i< c.coords.length; i++) {
//             System.out.println(c.coords[i].x + ", " + c.coords[i].y);
//         }
//         System.out.println();
//     }

//     static void showXYZ(Coords<? extends ThreeD> c) {
//         for (int i = 0; i< c.coords.length; i++) {
//             System.out.println(c.coords[i].x + ", " + c.coords[i].y + ", " + c.coords[i].z);
//         }
//         System.out.println();
//     }

//     static void showAll(Coords<? extends FourD> c) {
//         for (int i = 0; i< c.coords.length; i++) {
//             System.out.println(c.coords[i].x + ", " + c.coords[i].y + ", " + c.coords[i].z + ", " + c.coords[i].t);
//         }
//         System.out.println();
//     }
// }

// public class MyGenerics7 {
//     public static void main(String[] args) {
//         // TwoD [] twoD = {
//         //         new TwoD(1, 8),
//         //         new TwoD(2, 7),
//         //         new TwoD(3, 6),
//         //         new TwoD(4, 5)
//         // };
//         TwoD[] twoD = new TwoD[4];
//         for(int i = 0; i<4; i++){
//             twoD[i] = new TwoD(i+1, 9-1-i);
//         }
//         Coords<TwoD> twoDCoords = new Coords<>(twoD);
//         BoundedWildcard.showXY(twoDCoords);
//         // generics.BoundedWildcard.showXYZ(twoDCoords);
//         // generics.BoundedWildcard.showAll(twoDCoords);

//         FourD [] fourD = {
//                 new FourD(1, 8, 9, 16),
//                 new FourD(2, 7, 10, 15),
//                 new FourD(3, 6, 11, 14),
//                 new FourD(4, 5, 12, 13)
//         };
//         Coords<FourD> fourDCoords = new Coords<>(fourD);
//         BoundedWildcard.showXY(fourDCoords);
//         BoundedWildcard.showXYZ(fourDCoords);
//         BoundedWildcard.showAll(fourDCoords);
//     }

// }

class TwoD {
    int x, y;

    TwoD(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class ThreeD extends TwoD {
    int z;

    ThreeD(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }
}

class FourD extends ThreeD {
    int t;

    public FourD(int x, int y, int z, int t) {
        super(x, y, z);
        this.t = t;
    }

}

class coords<T extends TwoD> {
    T[] points;

    coords(T[] arr) {
        points = arr;
    }
}

class showPoints {
    static void showXY(coords<?> x) {
        for (int i = 0; i < x.points.length; i++) {
            System.out.println(x.points[i].x + " " + x.points[i].y);
        }
    }

    static void showXYZ(coords<? extends ThreeD> c) {
        /*
         -> Upper Bounded Wildcard (? extends ThreeD)
         -> Only accepts coords<T> where T is ThreeD or its subclass (FourD).
         -> Can safely access x, y, z but not t.
          ✅ Accepts: coords<ThreeD>, coords<FourD>.
          ❌ Rejects: coords<TwoD> (because TwoD lacks z).
         */
        for (int i = 0; i < c.points.length; i++) {
            System.out.println(c.points[i].x + " " + c.points[i].y + " " + c.points[i].z);
        }
    }

    static void showAll(coords<? extends FourD> c) {
        /*
         * ->Only accepts coords<T> where T is FourD or its subclass.
         * ->Can safely access x, y, z, t.
         * ✅ Accepts: coords<FourD>.
         * ❌ Rejects: coords<TwoD>, coords<ThreeD> (because they lack t).
         */
        for (int i = 0; i < c.points.length; i++) {
            System.out.println(c.points[i].x + " " + c.points[i].y + " " + c.points[i].z + " " + c.points[i].t);
        }
    }

    public static void main(String[] args) {
        FourD[] points = new FourD[4];
        for (int i = 0; i < 4; i++) {
            points[i] = new FourD(i + 1, 9 - i - 1, 9 + i, 17 - i - 1);
        }
        coords<FourD> c = new coords<>(points);
        showPoints.showXY(c);
        showPoints.showXYZ(c);
        showPoints.showAll(c);
    }
}
