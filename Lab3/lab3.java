package Lab3;

import java.util.Scanner;

class Student {
  private String name;
  private int group;
  private int[] grades;
  
  public Student(String name, int group, int grades[]) {
    super();
    this.name = name;
    this.group = group;
    this.grades = grades;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getgroup() {
    return group;
  }

  public void setgroup(int group) {
    this.group = group;
  }

  public int[] getGrades() {
    return grades;
  }

  public void setGrades(int grades[]) {
    this.grades = grades;
  }

  public Student(){}

}

public class lab3 {

  static  Scanner in = new Scanner(System.in);
  public static void main(String[] args) {



		Student[] s=new Student[3];
    createLearner(s);
    sort(s);
    print(s);


		in.close();
	}


  public static void createLearner(Student s[]){
    for (int i = 0; i < s.length; i++) {
      int[] marks = new int[5];
      System.out.println("Enter Name, Group and student grades");
      String name = in.next();
      int group = in.nextInt();
      for(int j = 0; j< 5; j++){
        marks[j] = in.nextInt();
      }
			s[i]=new Student(name,group,marks);
		}
  }


  public static void sort(Student s[]){
    Student s1=null;
    for (int iteration = 0; iteration < s.length-1; ++iteration)
    {

        int endOfArrayIndex= (s.length - iteration);
 
        for (int currentIndex = 0; currentIndex < endOfArrayIndex - 1; ++currentIndex)
        {

            if (s[currentIndex].getName().charAt(0) > s[currentIndex+1].getName().charAt(0))
            {
              s1=s[currentIndex+1];
					    s[currentIndex+1]=s[currentIndex];
					    s[currentIndex]=s1;
            }
        }
    }
  }


  public static void print(Student s[]){
    System.out.println("Name  | Group | Grades");
		for (int i = 0; i < s.length; i++) {
			System.out.print(s[i].getName()+"\t"+s[i].getgroup()+"\t");
      for(int j = 0; j < 5; j++){
        System.out.print(s[i].getGrades()[j]+" ");
      }
      System.out.print("\n");
		}
    boolean have2 =false;
    System.out.println("Students with twos");
		for (int i = 0; i < s.length; i++) {
      for (int j = 0; j < 5; j++){
        if(s[i].getGrades()[j] == 2){
          System.out.print(s[i].getName()+"\t"+s[i].getgroup()+"\t\n");
          have2 = true;
          break;
        }
      }
		}
    if(!have2){
      System.out.print("\n Hooray!!! Students dont have twos");
    }
  }
}
