package generic;

public class ArrayAlg {
    public static <T> T getMiddle(T... a){
        return a[a.length/2];
    }


    public static void main(String[] args){
        System.out.println(ArrayAlg.getMiddle(3,null,false));
    }

}
