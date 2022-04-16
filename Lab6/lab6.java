package Lab6;

import java.util.ArrayList;

class Stack extends ArrayList<Object>{// кастомна колекція
    
    public boolean isEmpty() {
        return super.isEmpty();
    }

    public int getSize(){
        return super.size();
    }

    public Object pop() {
        Object o = get(getSize()-1);
        remove(getSize()-1);
        return o;
    }

    public Object push (Object o ){
        add(o);
        return o;
    }


    public Object peek(){
        return get(getSize() -1);
    }
}


public class lab6 {
    public static void main(String[] args){
        Stack elements = new Stack(); //наший стек

  
        task(elements);
        print(elements);

        /////////
        task(elements);
        elements.pop();
        elements.push("the end");
        System.out.println("");
        print(elements);

        ///////////////////////////////////////////////
        System.out.println("");
        
        task(elements);

        elements.pop();
        elements.push("the end");

        int count = 0;
        for(int i = 0; i < elements.getSize(); i++){
            if(elements.get(i).toString().length() < 3){
                count++;
            }
        }

        System.out.println("2 symblos");
        System.out.println(count);
    }

    public static void task(Stack el){
        el.push("abc");
        el.push("fx");
        el.push("glc");
        el.push("hi");
        el.push("Gogo");
    }
    
    public static void print(Stack el){
        while(!el.isEmpty()){
            System.out.println(el.peek());
            el.pop();
        }
    }
}
