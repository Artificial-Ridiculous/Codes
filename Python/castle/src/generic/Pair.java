package generic;

public class Pair<T>{
    private T first;
    private T second;
    //private S third;

    public Pair(){
        this.first = null;
        this.second = null;
    }

    public Pair(T first, T second){
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(T second) {
        this.second = second;
    }



    @Override
    public String toString() {
        return "Tri{" +
                "first=" + first +
                ", second=" + second +

                '}';
    }

    public static void main(String[] args){
        Pair<Integer> three = new Pair<>();
        three.setFirst(1);
        three.setSecond(2);
        //three.setThird(3d);
        System.out.println(three);


    }


}
