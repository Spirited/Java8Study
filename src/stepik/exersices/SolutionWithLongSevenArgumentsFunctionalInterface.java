package stepik.exersices;

public class SolutionWithLongSevenArgumentsFunctionalInterface {
    public static void main(String[] args) {
        SevenArgumentsFunctionalInterface<String,String,String,String,String,String,String,String> solution = (x,y,z,k,m,n,v) -> (x+y+z+k+m+n+v).toUpperCase();

        System.out.println();
    }
}
