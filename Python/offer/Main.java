import java.util.Scanner;

public class Main{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        String[] s = {""};
        int len = 0;
        if(in.hasNextLine()){
            s = in.nextLine().split(" ");
        }
        len = s[s.length-1].length();
        System.out.println(len);
    }
}