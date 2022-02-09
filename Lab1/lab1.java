package Lab1;

import java.util.Scanner;

public class lab1 {
    public static void main(String[] args) {
        while(true){
            System.out.println("\n0: To exit"); 
            System.out.println("1: Task1"); 
            System.out.println("2: Task2"); 
            System.out.println("3: Task3"); 

            switch((int)getCorrectNumber()){
                case(0):
                    System.exit(0);
                case(1):
                    task1();
                    break;
                case(2):
                    task2();
                    break;

                case(3):
                    task3();
                    break;
                default:
                    System.exit(0);
            }
        }
        
    }
    private static void task1(){
        float v1, v2, s, t, result;

        System.out.print("Please, enter the speed of the first car: "); 
        v1=getCorrectNumber();

        System.out.print("Please, enter the speed of the second car: "); 
        v2=getCorrectNumber();

        System.out.print("Please, enter the distance between them: "); 
        s=getCorrectNumber();

        System.out.print("Please, enter the amount of time that has elapsed: "); 
        t=getCorrectNumber();

        float s1 = v1*t;//Відстань, що проїхав 1;

        float s2 = v2*t;//Відстань, що проїхав 2;

        if(s1+s2 <= s){
            result = s-(s1+s2); // Відстань між ними
        }
        else if(s1<s && s2<s){
            result = Math.abs(s1-s2);
        }
        else{
            result = Math.abs(s1-s2)+s;
        }

        System.out.printf("The distance between them: %f ", result); 
    } 

    private static void task2(){
        float y, x, a ,b;

        System.out.print("Please, enter x: "); 
        x=getCorrectNumber();
        System.out.print("Please, enter b: "); 
        b=getCorrectNumber();
        System.out.print("Please, enter a: "); 
        a=getCorrectNumber();

        y = (float)(Math.pow(x, a/b) - Math.cbrt((x+b)/a));

        System.out.printf("Result y: %f ", y);  
    } 

    private static void task3() { 
        int x1, x2, y1, y2;
        do {
        System.out.print("Please, enter x1: "); 
        x1 = (int)getCorrectNumber();
        System.out.print("Please, enter y1: "); 
        y1 = (int)getCorrectNumber();
        System.out.print("Please, enter x2: "); 
        x2 = (int)getCorrectNumber();
        System.out.print("Please, enter y2: "); 
        y2 = (int)getCorrectNumber();
        } while (!((x1 > 0 && x1 < 9) && (x2 > 0 && x2 < 9) && (y1 > 0 && y1 < 9) && (y2 > 0 && y2 < 9)));

        if (Math.abs(x1 - x2) == Math.abs(y1 - y2) || x1 == x2 || y1 == y2){
            System.out.print("Сan be moved"); 
        }  
        else{
            System.out.print("Сannot be moved");
        }
    }

    public static float getCorrectNumber(){
        Scanner scan = new Scanner(System.in);

        while(!scan.hasNextFloat()) scan.next();
        float x = scan.nextFloat();
        return x;
    }
}
