import java.util.function.Consumer;

public class Integral implements Consumer<Double> {

    private static int N;
    private volatile double integral = 0;

    public static void main(String[] args) throws InterruptedException {

        Integral integral1 = new Integral();

        int countOfProc = Runtime.getRuntime().availableProcessors();
        N = 10_000 / countOfProc;

        double h = (3. - 1.) / countOfProc;

        Thread[] thread = new Thread[countOfProc];

        for (int i = 0; i < countOfProc; ++i){
            thread[i] = new Thread(new PartSumCalculate(1 + i * h, 1 + (i + 1) * h, integral1));
            thread[i].start();
        }

        for (int i = 0; i < countOfProc; ++i){
            thread[i].join();
        }

        System.out.println(integral1.integral);

    }


    public static double func(double x){
        return Math.exp(-x * x / 2) * Math.sin(x);
    }


    // частичная сумма, рассчитываемая одним потоком
    public static double partSum(double a, double b, int N){

        double h =  (b - a) / N;
        double sum = 0;

        for (int i = 0; i < N; ++i){
            sum += h * (func(a + i * h) + func(a + h * (i + 1))) / 2;
        }

        return sum;
    }

    @Override
    public synchronized void accept(Double aDouble) {
        integral += aDouble;
    }


    static class PartSumCalculate implements  Runnable{
        private double a;
        private double b;
        private Consumer<Double> consumer;



        public PartSumCalculate(double a, double b, Consumer<Double> consumer){
            this.a = a;
            this.b = b;
            this.consumer = consumer;
        }


        @Override
        public void run() {
            double result = partSum(a, b, N);
            consumer.accept(result);
        }
    }

}
