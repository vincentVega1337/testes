package ua.nure.shylov.Practice1;

public class Part3 {

    public static void main(String[] args) {
        if (args.length > 1) {
            System.out.println(NOD(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
        } else {
            System.out.println("Parameters is empty!");
        }
    }

    private static int NOD(int first, int second) {
        if (first > second) {
            first = first % second;
            if (first == 0) {
                return second;
            }
        } else if (first < second) {
            second = second % first;
            if (second == 0) {
                return first;
            }
        }
        return NOD(first, second);
    }
}
