package Lab11;

public class lab11 {

        static double accentSum = 0;
        static double descentSum = 0;
        static double bothSum = 0;
    //Підняття
    public static double recursionAscent(int i){
        if(i == 1){
            return 1;
        }   ;
        double value = 2*Math.cos(recursionAscent(i - 1))+i;
        System.out.println(value + "  " + i);
        accentSum += value;
        return value;
    }
    //Спуск
    public static void recursionDescent(int i, double value){
        if(i != 0){
            double newValue =  2*Math.cos(value)+i;
            System.out.println(newValue + "  " + i);
            recursionDescent(i-1, newValue);
            descentSum += newValue;
        }   
    }

    public static double recursionBoth(int i, double value){
        double sum = 0;
        if(i>0){
            double newValue = 2*Math.cos(value)+i;
            sum += recursionBoth(i-1, newValue) + newValue;
            System.out.println(sum + "  " + i);
            return sum;
        }
        else{
            return sum;
        }
    }





    public static void main(String[] args) {
        System.out.println(recursionAscent(5));
        System.out.println(accentSum);
        System.out.println("");

        recursionDescent(5, 1);
        System.out.println(descentSum);


        System.out.println("");
        System.out.println(recursionBoth(5, 1));
    }

}
