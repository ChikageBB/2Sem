public class Main2  {
    public static void main(String[] args) {

    }

    static class MyTestThread implements Runnable{

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
