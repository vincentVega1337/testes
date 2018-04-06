package ua.nure.shylov.Practice1;

public class Part2 {

    public static void main(String[] args) {
        if(args.length > 1){
            System.out.println(Integer.parseInt(args[0]) + Integer.parseInt(args[1]));
        } else {
            System.out.println("Parameters is empty!");
        }
    }

}
