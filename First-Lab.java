import static java.lang.Math.*;

public class Main {

    public static void main(String[] args) {
        final int firstCond = 21;
        final int[] secondCond = {3, 5, 13, 15, 19};
        int [] a = task1();
        float [] x = task2();
        float [][] ax = task3(a, x, firstCond, secondCond);
        for(float[] row : ax) {
            printRow(row);
        }
    }

    public static int[] task1(){
        int[] a = new int[11]; //Массив с нечетными числами от 1 до 21 в порядке убывания
        int k = 21;
        for(int i = 0; i < a.length; i++){
            a[i] = k;
            k -= 2;
        }
        return a;
    }

    public static float[] task2(){
        float[] x = new float[20]; //Массив с 20-ю случайными числами от -11.0 до 3.0
        int max = 3;
        int min = -11;
        for(int i = 0; i < x.length; i++){
            x[i] = rndNum(max, min);
        }
        return x;
    }

    public static float[][] task3(int[] a, float[] x, int first_cond, int[] second_cond){
        float[][] ax = new float[11][20];
        for(int i = 0; i < a.length; i++){
            for (int j = 0; j < x.length; j++){
                if (a[i] == first_cond){
                    ax[i][j] = first_form(x[j]);
                }
                else if(contain(second_cond, a[i])){
                    ax[i][j] = second_form(x[j]);
                }
                else{
                    ax[i][j] = third_form(x[j]);
                }
            }
        }
        return ax;
    }

    public static float first_form(float x){
        return (float) tan(pow(pow((0.25 / (x + 0.5)), 3), ((1 - asin((x - 4) / 14)) / 0.25)));
    }

    public static float second_form(float x){
        return (float) (2 * (exp(asin((x - 4) / 14)) - 0.5)) / 3;
    }

    public static float third_form(float x){
        return (float) atan(exp(cbrt(-2 * PI * pow(cos(x), 2))));
    }

    public static float rndNum(int max, int min){
        return (float) ((random() * (max - min)) + min);
    }

    public static boolean contain(int[] arr, int n){
        for(int i : arr) if(i == n) return true;
        return false;
    }

    public static void printRow(float[] row){
        for (float i : row){
            System.out.printf("%.3f", i);
            System.out.print("\t");
        }
        System.out.println();
    }
}
