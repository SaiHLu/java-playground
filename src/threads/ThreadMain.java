import threads.MyRunnable;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
//    threads.MyThread myThread = new threads.MyThread();
//    myThread.start();

    MyRunnable myRunnable = new MyRunnable();
    Thread thread = new Thread(myRunnable);
    System.out.println("Before start: " + thread.getState());
    thread.start();
    System.out.println("After start: " + thread.getState());

    System.out.println("threads.Main Thread is started");
}
