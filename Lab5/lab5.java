package Lab5;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class lab5 {

    static  Scanner in = new Scanner(System.in);

    public static void main(String[] args){
        LinkedList<Integer> numbers = new LinkedList<Integer>();
        System.out.println("Введіть елементи двохзв'язного списку:");
        while(in.hasNextInt()){
            numbers.add(in.nextInt());
        }

        System.out.println("Старий список");
        for(var el : numbers){
            System.out.print(el);
            System.out.println();
        }

        for(int i = 0; i < numbers.size(); i++){
            if(numbers.get(i) % 2 != 0){
                numbers.add(i,numbers.get(i));
                i++;
            }
        }
        System.out.println("Новий список");
        for(var el : numbers){
            System.out.print(el);
            System.out.println();
        }

        System.out.println("Покажчик на останій елемент");
        System.out.print(numbers.getLast());
        
    }
}
