package generics;

class Stats<T extends Number> {
    T[] nums;

    Stats(T[] o) {
        nums = o;
    }

    double average() {
        double sum = 0.0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i].doubleValue();
        }
        return sum / nums.length;
    }

    boolean sameAvg(Stats<T> obj) {
        if (average() == obj.average()) {
            return true;
        } else return false;
    }

    boolean sameAvgAny(Stats<?> obj) {
        if (average() == obj.average()) {
            return true;
        } else return false;
    }
}

public class MyGenerics6 {
    public static void main(String[] args) {
        Integer[] n1 = {10, 20, 30, 40, 50};
        Stats<Integer> s1 = new Stats<>(n1);
        System.out.println(s1.average());

        Integer[] n2 = {50, 20, 40, 10, 30};
        Stats<Integer> s2 = new Stats<>(n2);
        System.out.println(s2.average());

        System.out.println(s1.sameAvg(s2));

        Double[] n3 = {50.0, 40.0, 30.0, 20.0, 10.0};
        Stats<Double> s3 = new Stats<>(n3);
        System.out.println(s3.average());

        System.out.println(s2.sameAvgAny(s3));
        sum<Integer> ints = new sum<>(n1);
        sum<Double> doubles = new sum<>(n3);   
        System.out.println(ints.giveSum());
        System.out.println(doubles.giveSum());
        System.out.println(ints.isSame(doubles));
     }
}

class sum<T extends Number>{
    T[] numbers;
    sum(T[] arr){
        numbers = arr;
    }
    public double giveSum(){
        double s = 0;
        for(T x:numbers){
            s += x.doubleValue();
        }
        return s;
    }
    public boolean isSame(sum<?> ob){
        if(this.giveSum() == ob.giveSum()){
            return true;
        }
        return false;
    }
}