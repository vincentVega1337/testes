package ua.nure.shylov.Practice1;

public class Part4 {

    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println(sum(Integer.parseInt(args[0])));
        } else {
            System.out.println("Parameters is empty!");
        }
    }

    private static int sum(int i){
        if(i < 10){
            return i;
        }
        return i % 10 + sum((i - (i % 10)) / 10);
    }
}
