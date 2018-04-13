package ua.nure.shylov.Practice5;

public class Part2 {

    public static void main(String[] args) {
        Spam spam = new Spam(new int[]{500, 1000, 1500, 2000}, new String[]{"one", "two", "three", "four"});
        spam.startSpam();
        
    }
}

class Spam {

    private int[] intervals;
    private String[] messages;

    public Spam(int[] intervals, String[] messages) {
        this.intervals = intervals;
        this.messages = messages;
    }

    public void startSpam() {
        for (int i = 0; i < intervals.length; i++) {
            System.out.println(messages[i]);
            if (i != intervals.length - 1) {
                try {
                    Thread.sleep(intervals[i]);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
