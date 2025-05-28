public class Main {
    public static void main(String[] args) {

        MyTestThread test1 = new MyTestThread(1);
        MyTestThread test2 = new MyTestThread(2);


        test1.start();
        test2.start();
    }


    static class MyTestThread extends Thread{

        private int index;

        public MyTestThread(int index){
            this.index = index;
        }

        @Override
        public void run() {
            System.out.println("Привет из параллельной реальности " + index );
        }
    }
}
