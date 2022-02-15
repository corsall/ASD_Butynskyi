package Lab2;

import java.util.Scanner;
import java.util.Random;


public class lab2 {
    static Scanner scan = new Scanner(System.in);
        
    public static void main(String[] args) {
        while(true){
            System.out.println("\n0: To exit"); 
            System.out.println("1: Task1"); 
            System.out.println("2: Task2"); 
            System.out.println("3: Task3"); 
            System.out.println("4: Task4");

            switch((int)getCorrectNumber()){
                case(0):
                    scan.close();
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
                case(4):
                    task4();
                    break;
                default:
                    scan.close();
                    System.exit(0);
            }
        }
    }
    public static void task1(){
        System.out.print("Enter length of array: ");

        Tasks1_2 task1 = new Tasks1_2();

        task1.setLength();
        task1.fillArray();
        task1.printArray();
        System.out.printf("\nСумма мiж парними iндексами: %d ", task1.evenNumbers());
        System.out.printf("\nКiлькiсть елментiв мiж першим i останнiми нульовими елементами: %d", task1.betweenZeros());
    }

    public static void task2(){
        System.out.print("\nEnter length of array: ");

        Tasks1_2 task2 = new Tasks1_2();

        task2.setLength();
        task2.fillArraywithRandomNumbers();
        task2.printArray();
        task2.sortArray();
        task2.printArray();
        System.out.print("<- After normal sort");
        task2.customSort();
    }

    public static void task3(){
        System.out.print("\nEnter length of array: ");

        Task3_4 task3 = new Task3_4();

        task3.setLength();
        task3.fillArraywithRandomNumbers();
        task3.printArray();
        task3.numberRowsWithZeros();
        System.out.println("");
        System.out.println("Second part:");
        task3.longestSerie();
    }

    public static void task4(){
        System.out.println("");
        System.out.println("Enter length of square matrix:");
        Task3_4 task4 = new Task3_4();
        task4.setLengthSquare();
        task4.fillArrayWithZeros();
        task4.squareWithTriangle();
        task4.printArray();
    }

    static class Task3_4{
        private
        int task3[][];

        public
        void squareWithTriangle(){
            int length_I = (task3.length/2)+1;
            int length_J = task3.length;
            int temp = 0;
            for(int i = 0; i < length_I; i++ ){
                for(int j = temp; j < length_J; j++ ){
                    task3[i][j] = 1;
                }
                temp++;
                length_J--;
            }

        }
        void fillArrayWithZeros(){
            for(int i = 0; i < task3.length; i++ ){
                for(int j = 0; j < task3[0].length; j++ ){
                    task3[i][j] = 0;
                }
            }
        }

        int[][] getArray(){
            return task3;
        }
        void setLengthSquare(){
            int temp = getCorrectNumber();
            task3 = new int[temp][temp];
        }
        void setLength(){
            task3 = new int[getCorrectNumber()][getCorrectNumber()];
        }

        void fillArraywithRandomNumbers(){
            for(int i = 0; i < task3.length; i++ ){
                for(int j = 0; j < task3[0].length; j++ ){
                    task3[i][j] = random(-2, 2);
                }
            }
        }

        void printArray(){
            System.out.print("Your array: \n");
            for(int i = 0; i < task3.length; i++ ){
                for(int j = 0; j < task3[0].length; j++ ){
                    System.out.print(task3[i][j] + ", ");
                }
                System.out.print("\n");
            }
        }

        void numberRowsWithZeros(){

            int count = 0;
            for(int i = 0; i < task3.length; i++ ){
                for(int j = 0; j < task3[0].length; j++ ){
                    if(task3[i][j]==0){
                        count++;
                        break;
                    }
                }
            }
            System.out.printf("\nNumber of rows with zeros: %d", count);
        }
        
        void longestSerie(){
            int temparray[][] = task3;
            sortArray(temparray);
            int serie_MAX_Array[][] = new int[task3.length][1];


            System.out.print("\nSame sorted array: \n");
            for(int i = 0; i < temparray.length; i++ ){
                for(int j = 0; j < temparray[0].length; j++ ){
                    System.out.print(temparray[i][j] + ", ");
                }
                System.out.print("\n");
            }

            int serieMax = 0;
            int serieTemp = 0;
            for(int i = 0; i < temparray.length; i++ ){
                for(int j = 0; j< temparray[0].length; j++){
                    for(int StartIndex = j+1; StartIndex< temparray[0].length; StartIndex++){
                        if(temparray[i][j] == temparray[i][StartIndex]){
                            serieTemp++;
                        }
                    }
                    if(serieTemp>serieMax){
                        serieMax = serieTemp;
                    }
                    serieTemp = 0;
                }
                serie_MAX_Array[i][0] = serieMax; 
                System.out.println(serieMax+1);
                serieMax = 0;
            }

            int Max_Serie_I = 0;
            int Temp_Serie_I = 0;
            int temp_I = 0;

            for(int i = 0; i < serie_MAX_Array.length-1; i++ ){

                Temp_Serie_I = serie_MAX_Array[i][0];

                if(Max_Serie_I<Temp_Serie_I){
                    Max_Serie_I = Temp_Serie_I;
                    temp_I = i;
                }
            }
            System.out.printf("\nRow: %d, Serie: %d",temp_I ,Max_Serie_I+1 );
        }

        void sortArray(int array[][]){
            for(int i = 0; i < task3.length; i++ ){
                for (int iteration = 0; iteration < array.length-1; ++iteration)
                {
                    int endOfArrayIndex = (array.length - iteration);
                    for (int currentIndex = 0; currentIndex < endOfArrayIndex - 1; ++currentIndex)
                    {
                        if (array[i][currentIndex] > array[i][currentIndex + 1])
                        {
                            int temp = array[i][currentIndex];
                            array[i][currentIndex] = array[i][currentIndex+1];
                            array[i][currentIndex+1] = temp;
                        }
                    }
                }
            }
        }
    }

    public static int random(int min,int max){
        //int diff = max - min;
        Random random = new Random();
        return random.nextInt(max + 1 - min) + min;
    }

    public static int getCorrectNumber(){

        while(!scan.hasNextInt()) scan.next();
        int x = scan.nextInt();
        return x;
    }

    static class Tasks1_2{
        private
        int array[];
        public
        Tasks1_2(){
            array = new int[1];
            array[0] = 0;
        }
        void setLength(){
            array = new int[getCorrectNumber()];
        }
    
        void fillArray(){
            System.out.println("Enter numbers: ");
            for(int i = 0; i < array.length; i++ ){
                array[i] = getCorrectNumber();
            }
        }
        
        void fillArraywithRandomNumbers(){
            for(int i = 0; i < array.length; i++ ){
                array[i] = random(-10, 10);
            }
        }

        void printArray(){
            System.out.print("Your array: ");
            for(int i = 0; i < array.length; i++ ){
                System.out.print(array[i] + ", ");
            }
        }
        int evenNumbers(){
            int sum=0;
            for(int i = 0; i < array.length; i+=2 ){
                sum+= array[i];
            }
            return sum;
        }
        int betweenZeros(){
            int temp1 =0,temp2 =0;
            for(int i = 0; i < array.length; i++ ){
                if(array[i]==0){
                    temp1 = i;
                    for(int j = temp1+1; j < array.length; j++ ){
                        if(array[j]==0){temp2=j;}
                    }
                    if((temp2-temp1)>0){
                        return (temp2-temp1)-1;
                    }
                }
            }
            return 0;
        }

        ///////////////////////////Task2///////////////////////

        void sortArray(){
            for (int iteration = 0; iteration < array.length-1; ++iteration)
            {
                int endOfArrayIndex = (array.length - iteration);
         
                boolean swapped = (false);
                for (int currentIndex = 0; currentIndex < endOfArrayIndex - 1; ++currentIndex)
                {
                    if (array[currentIndex] > array[currentIndex + 1])
                    {
                        int temp = array[currentIndex];
                        array[currentIndex] = array[currentIndex+1];
                        array[currentIndex+1] = temp;
                        swapped = true;
                    }
                }
                if (!swapped)
                {
                    System.out.printf("\nEarly termination on iteration: %d", iteration+1);
                    System.out.println("");
                    break;
                }
            }
        }

        void customSort(){
            int j = 0;
            int temparray[] = new int[array.length];
            for (int iteration = 0; iteration < array.length; iteration++){
                if(array[iteration]<=0){
                    temparray[((temparray.length)-1)-iteration]=array[iteration];
                }
                else{
                    temparray[j++] = array[iteration];
                }
            }
            System.out.println("\nCustom sort array: ");
            for(int i = 0; i < temparray.length; i++ ){
                System.out.print(temparray[i] + ", ");
            }
        }
    }
}
