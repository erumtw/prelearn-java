import java.util.Scanner;

public class BasicIO {
    // create method (function)
    public static float triangle(float base, float height) {
        return .5f * base * height;
    }
    public static void main(String[] args) {
        // OUTPUT & VARAIBLEs // 
        // int a = 2;
        // float b = 2.0f; // float must have f after values (suffix)
        // double c = 2.0; 
        // System.out.println(a);
        // System.out.println(b);
        // System.out.println(c);

        // INPUT // 
        // double i; 
        // Scanner rev = new Scanner(System.in); // class for recieve input
        // System.out.print("Enter numbers : ");
        // i = rev.nextDouble(); // input method
        // System.out.println("it is " + i + " ?");

        //use method (function)
        float b;
        float h;
        Scanner in = new Scanner(System.in);
        System.out.print("enter base width : ");
        b = in.nextFloat();
        System.out.print("enter height : ");
        h = in.nextFloat();
        System.out.println("Triangle = " + triangle(b, h));
        System.out.println("base is " + b + ", height is " + h);
        System.out.printf("%.1f x %.1f", b, h);
    }
}
