
package bogart;

import java.util.Scanner;

public class Bogart {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name;
        int byear;
        
        System.out.print("Enter your name: ");
        name = sc.nextLine();
        System.out.print("Enter Your birth year: ");
        byear = sc.nextInt();
        System.out.print("hello world"+name+"your age is: "+(2025-byear));
       
    }
    
}
