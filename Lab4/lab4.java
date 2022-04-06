package Lab4;

import java.util.*;

class LinkList{
    public int data;
    public LinkList next;

    public LinkList(int data){
        this.data = data;
    }
}

class List{
    private LinkList head;

    public List(){
        head  = null;
    }

    private boolean isEmpty(){
        return head == null;
    }

    public void add(int data){
        LinkList temp = new LinkList(data);
        temp.next = head;
        head = temp;
    }



    public void addAt(int data, int k){
        LinkList temp = head;
        int c = 0;

        while(temp != null){
            if(k == c){
                LinkList a = new LinkList(data);
                a.next = temp.next;
                temp.next = a;
                break;
            }
            temp = temp.next;
            c++;
        }
        
    }

    public void remove(){
        head = head.next;
    }

    public int find(int k){
        LinkList temp = head;
        int c = 0;

        while(temp != null){
            if(temp.data == k){
                return c;
            }
            temp = temp.next;
            c++;
        }
        return -1;
    }

    public void removeAt(int k){
        LinkList cur = head;
        LinkList prev = head;
        while(cur.data != k){
            if(isEmpty()){
                System.out.println("List is empty");
                return;
            }
            else{
                prev = cur;
                cur = cur.next;
            }

            if(cur == head){
                head = head.next;
            }
            else{
                prev.next = cur.next;
            }
        }
    }

    public void print(){
        LinkList temp = head;

        while(temp!=null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}




public class lab4 {
    public static void main(String[] args) {

        List list = new List();
        
        list.add(1);
        list.add(30);
        list.add(40);
        list.add(20);

        list.addAt(33, 2);

        list.print();

        list.remove();
        list.remove();
        list.removeAt(1);

        System.out.println();
        list.print();

        //Task2

        Scanner in = new Scanner(System.in);
        System.out.println("Введiть кiлькiсть воїнiв: ");
		int n = in.nextInt();

        System.out.println("k-тий, що помре: ");
        int k = in.nextInt();
        in.close();
		ArrayList<Integer> ns = new ArrayList<Integer>(n);
		for (int i = 1; i <= n; i++) 
			ns.add(i);
		
		int i = 0, j = 0;
		while(n > 1) {
			j = (++j) % k;
			if(j == 0) {
				n--;
				ns.remove(i);
			} else {
				i = (++i) % n;
			}
		}
        System.out.println("Вижив: ");
		System.out.println(ns.get(0));

    }
}