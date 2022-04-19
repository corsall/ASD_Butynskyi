package Lab12;

public class lab12 {
    public static void main(String[] args) {

        int a[][] = new int[5][5];
        int b[][] = new int[7][7];

        System.out.println("Entering random numbers...");
        //Рандомне заповнення
        randomInput(a);

        //Симетричне заповнення
        symetricInput(b);


        //Перевірка на симетричність
        boolean PA = isSymetric(a); 
        boolean PB = isSymetric(b); 


        //Вивід Матриці на консоль
        printMatrix(a);
        System.out.println("");
        printMatrix(b);

        System.out.println("Для матрицi A    PA = " + PA);
        System.out.println("Для матрицi A    PB = " + PB);
    }


    public static void randomInput(int a[][]){
        for(int i = 0; i<a.length; i++){
            for(int j = 0; j<a[0].length; j++){
                a[i][j] = (0 +(int)(Math.random()*20));
            }
        }
    }

    public static void symetricInput(int a[][]){
        for(int i = 0; i<a.length; i++){
            for(int j = 0; j < a[0].length; j++){
                a[i][j] = (0 +(int)(Math.random()*10));
                a[j][i] = a[i][j];
            }
        }
    }

    public static boolean isSymetric(int a[][]){
        int count = 0;
        for(int i = 0; i<a.length; i++){
            for(int j = 0; j < a[0].length; j++){
                if(a[j][i] == a[i][j]){
                    count++;
                }
            }
        }
        if(a.length*a[0].length == count){
            return true;
        }
        return false;
    }
    
    public static void printMatrix(int a[][]){
        for(int i = 0; i<a.length; i++){
            for(int j = 0; j<a[0].length; j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }



}
