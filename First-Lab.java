import static java.lang.Math.*;

public class Main {

    public static void main(String[] args) {

        int [] a = task1();
        float [] x = task2();
        float [][] ax = task3(a, x);
        for(float[] row : ax){
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
            x[i] = (float) ((random() * (max - min)) + min);
        }
        return x;
    }

    public static float[][] task3(int[] a, float[] x){
        float[][] ax = new float[11][20];
        for(int i = 0; i < a.length; i++){
            for (int j = 0; j < x.length; j++){
                float h = x[j];
                if (a[i] == 21){
                    ax[i][j] = (float) tan(pow(pow((0.25 / (h + 0.5)), 3), ((1 - asin((h - 4) / 14)) / 0.25)));
                }
                else if(a[i] == 3 | a[i] == 5 | a[i] == 13 | a[i] == 15 | a[i] == 19){
                    ax[i][j] = (float) (2 * (exp(asin((h - 4) / 14)) - 0.5)) / 3;
                }
                else{
                    ax[i][j] = (float) atan(exp(cbrt(-2 * PI * pow(cos(h), 2))));
                }
            }
        }
        return ax;
    }

    public static void printRow(float[] row){
        for (float i : row){
            System.out.printf("%.3f", i);
            System.out.print("\t");
        }
        System.out.println();
    }
}
