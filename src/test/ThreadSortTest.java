package test;

/**
 * @author intent
 * @version 1.0
 * @date 2020/3/2 11:23 上午
 * @email zzy.main@gmail.com
 */
public class ThreadSortTest {
    public static void main(String[] args) {
        int[] testArray = {10, 436, 7, 88, 2, 5, 9, 3};
        SortThread[] sortThreads = new SortThread[testArray.length];
        for (int i = 0; i < sortThreads.length; i++) {
            sortThreads[i] = new SortThread(testArray[i]);
        }
        for (SortThread sortThread : sortThreads) {
            sortThread.start();
        }
    }
}

class SortThread extends Thread {
    int s = 0;

    public SortThread(int s) {
        this.s = s;
    }

    public void run() {
        try {
            sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //输出该数
        System.out.println(s);
    }
}