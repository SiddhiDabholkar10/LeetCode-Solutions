// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.Scanner;
class Main {
    static void pattern1(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
        
    }
    static void pattern2(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
        
    }
     static void pattern3(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
        
    }
    static void pattern4(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(i+" ");
            }
            System.out.println();
        }
        
    }
    static void pattern5(int n){
        for(int i=n;i>0;i--){
            for(int j=i;j>0;j--){
                System.out.print("* ");
            }
            System.out.println();
        }
        
    }
    static void pattern6(int n){
        for(int i=0;i<n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
        
    }
    
    
    //erected pyramid
    static void pattern7(int n){
       //for each row 
       for(int i=0;i<n;i++){
           //each row - space before stars 
           for(int j=0;j<n-i-1;j++){
               System.out.print(" ");
           }
           //each row - stars
           for(int j=0;j<2*i+1;j++){
               System.out.print("*");
           }
           //each row - space after stars 
           for(int j=0;j<n-i-1;j++){
               System.out.print(" ");
           }
            System.out.println();
       }
    }
    
    //inverted pyramid
    static void pattern8(int n){
       //for each row 
       for(int i=n;i>0;i--){
           //each row - space before stars 
           for(int j=0;j<n-i;j++){
               System.out.print(" ");
           }
           for(int j=0;j<2*i-1;j++){
               System.out.print("*");
           }
           for(int j=0;j<n-i;j++){
               System.out.print(" ");
           }
            System.out.println();
       }
    }
    static void pattern9(int n){
        //erected pyramid
        pattern7(n);
        //inverted pyramid
        pattern8(n);
        
    }
    static void pattern10(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
        for(int i=n-1;i>0;i--){
            for(int j=i;j>0;j--){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void pattern11(int n){
        int start;
        for(int i=0;i<n;i++){
           if(i%2==0){
               start = 1;
           }
           else start =0;
           for(int j=0;j<=i;j++){
               System.out.print(start);
               start = 1-start;
           }
           System.out.println();
        }
    }
    //Number crown pattern
    static void pattern12(int n){
        int spaces = 2*(n-1);
        
        for(int i = 1;i<=n;i++){
            //print numbers
            for(int j=1;j<=i;j++){
                System.out.print(j);
            }
            //print spaces 
            for(int j=0;j<spaces;j++){
                System.out.print(" ");
            }
            //print numbers in reverse 
            for(int j=i;j>=1;j--){
                System.out.print(j);
            }
            spaces -=2;
            System.out.println();
        }
    }
    
    
    
    public static void main(String[] args) {
        System.out.print("Enter the value of n: ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        //pattern1(n);
        //pattern2(n);
        //pattern3(n);
        //pattern4(n);
        //pattern5(n);
        //pattern6(n);
        //pattern7(n);
        //pattern8(n);
        //pattern9(n);
        //pattern10(n);
        //pattern11(n);
        //pattern12(n);
        
        
    }
}
