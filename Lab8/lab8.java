package Lab8;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;

public class lab8 {
    public static void main(String[] args) {

        int b[] = {1, 2, 3, 4, 5};

        // for(int i = 0; i<a.length; i++){
        //     a[i] = (0 +(int)(Math.random()*2));
        // }
        // for(int i = 0; i<b.length; i++){
        //     b[i] = (0 +(int)(Math.random()*2));
        // }

        
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(2);
        a.add(5);
        a.add(6);
        a.add(7);
        a.add(1);
        a.sort(null);
        System.out.println(a);


        for(int i = 0; i<b.length; i++){
            int res = Collections.binarySearch(a,b[i],new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2){
                    if(o1 == o2){
                        return 0;
                    }
                    else{
                        return 1;
                    }
                }
                
            });
            if(res != -1){
                a.remove(res);  
            }
            System.out.println(a);
        }

        System.out.println(" ");
        System.out.println(a);

    }
}
