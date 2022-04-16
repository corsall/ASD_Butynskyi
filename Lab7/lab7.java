package Lab7;

import java.util.TreeSet;
import java.util.Iterator;

public class lab7 {
    public static void main(String[] args) {
        TreeSet<Integer> tree = new TreeSet<Integer>();

        for(int i = 10; i>0; i--){
            tree.add(0 +(int)(Math.random()*20 - 10));
        }

        System.out.println(tree);
        System.out.println("");

        removeLessZero(tree);
        System.out.println(tree);

        ///////TASK2

        String n[] = {"342351","765891","453122","431350","876432","734626","238651","455734","234987","124512"};

        TreeSet<Integer> t = new TreeSet<Integer>();

        for(int i= 0; i < n.length; i++){
            if((int)n[i].charAt(0)+(int)n[i].charAt(1)+(int)n[i].charAt(2) == (int)n[i].charAt(3)+(int)n[i].charAt(4)+(int)n[i].charAt(5)){
                t.add(Integer.parseInt(n[i]));
            }
        }

        System.out.println("");
        System.out.println(t);
        
    }

    public static void removeLessZero(TreeSet<Integer> tree){
        Iterator<Integer> iterator = tree.iterator();
        while(iterator.hasNext()){
            if(iterator.next()< 0){
                iterator.remove();
            }
        }
    }
}
