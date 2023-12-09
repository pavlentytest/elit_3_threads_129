package dev2;

public class Program {
    public static void main(String[] args) {

//        Calculable calculable = new Calculable();
        Calculable calculable1 = new Calculable() {
            @Override
            public int calc(int a, int b) {
                return a+b;
            }
        };
        calculable1.calc(2,3);

        Calculable calculable2 = (a, b) -> a+b;
        calculable2.calc(10,20);

        Test test = new Test();
        test.calc(4,5);

    }
}

class Test implements Calculable {

    @Override
    public int calc(int a, int b) {
        return 0;
    }
}

interface Calculable {
    int calc(int a, int b);
}

