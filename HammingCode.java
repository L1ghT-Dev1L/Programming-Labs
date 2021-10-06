package com.company;
import java.util.Scanner;

public class HammingCode{

    public static void main(String[] args) {

        Scanner message = new Scanner(System.in);
        System.out.print("Введите сообщение: ");
        int num = message.nextInt();
        int[] mess = toArr(num);
        decoding(mess);

    }

    public static int[] toArr(int num){ // Converting an integer to an array
        int [] arr = new int[7];
        int k = 6;
        while(num > 0){
            arr[k] = num % 10;
            num /= 10;
            k--;
        }
        return arr;
    }

    public static void decoding(int[] mess){

        int[] arr = new int[7];
        int k = 0;
        for(int i = 0; i < mess.length; i++){ // Making an array with key numbers equal zero to check them for errors
            int key_num = (int) Math.pow(2, k) - 1;
            if(i == key_num){
                arr[i] = 0;
                k++;
            }
            else{
                arr[i] = mess[i];
            }
        }

        k = 0;
        for(int i = 0; i < arr.length; i++){
            int key_num = (int) Math.pow(2, k);
            if(i == key_num - 1){
                int sum = 0;
                for(int j = i; j < arr.length; j+=(2 * key_num)){
                    for(int l = j; l < j + key_num; l ++){
                        sum += arr[l];
                    }
                }
                arr[i] = sum % 2; // Filling the key numbers with the right values
                k++;
            }
        }

        int err = 0;
        for(int i = 0; i < arr.length; i++){ // Comparing the correct message with received message to find the error
            if(arr[i] != mess[i]){
                err += (i + 1);
            }
        }
        if(err > 0){
            System.out.print("В сообщении присутсвует ошибка в бите № " + err + ". Правильное сообщение: ");
            mess[err - 1] = (mess[err - 1] == 0)? 1 : 0;
            for(int i : mess){
                System.out.print(i);
            }
        }
        else{
            System.out.print("В сообщении ошибок не обнаружено.");
        }
    }
}