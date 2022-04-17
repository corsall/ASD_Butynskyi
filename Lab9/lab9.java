package Lab9;

import java.util.Arrays;
import java.util.Scanner;

public class lab9 {

    static  Scanner in = new Scanner(System.in);
    public static void main(String[] args) {

        int a[] = new int[10];

        System.out.println("Choose: 0-> Manual input / 1 -> Input of random numbers");

        switch (in.nextInt()) {
            case 0:
                System.out.println("Введіть елементи массиву:");
                for(int i = 0; i < a.length; i++){
                    a[i] = in.nextInt();
                }
                break;

            case 1:
                System.out.println("Entering random numbers...");

                for(int i = 0; i<a.length; i++){
                    a[i] = (0 +(int)(Math.random()*20));
                }
                break;

            default:
                System.out.println("Ooops");
                break;
        }

        System.out.println("Choose: 0-> Output sorted aay / 1 -> Output sorted aay with iterations");

        switch (in.nextInt()) {
            case 0:
                System.out.println("Your aay:");
                Arrays.sort(a);
                for(int i = 0; i < a.length; i++){
                    System.out.print(a[i]+" ");
                }
                break;

            case 1:
                System.out.println("Sorted aay with Iterations:1");

                int i, j, temp;
                boolean swapped;
                for (i = 0; i < a.length - 1; i++)
                {
                    swapped = false;
                    for (j = 0; j < a.length - i - 1; j++)
                    {
                        if (a[j] > a[j + 1])
                        {
                            // swap a[j] and a[j+1]
                            temp = a[j];
                            a[j] = a[j + 1];
                            a[j + 1] = temp;
                            swapped = true;
                        }
                    }
         
                    // IF no two elements were
                    // swapped by inner loop, then break
                    if (swapped == false)
                        break;
                    
                    System.out.println("Iterations:" + i);
                    for(int k = 0; k < a.length; k++){
                        System.out.print(a[k]+" ");
                    }
                        
                }
                break;

            default:
                System.out.println("Ooops");
                break;
        }
        
    }
}
