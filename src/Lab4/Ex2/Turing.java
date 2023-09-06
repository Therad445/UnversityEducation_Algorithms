package Lab4.Ex2;

import java.util.Scanner;

public class Turing {
    public static void main(String[] args) {

        System.out.println("Введите число для расчета:");
        int num = new Scanner(System.in).nextInt();
        if(num == 0) {System.out.println("Результат - 0");return;}

        String string = Transform1(num);

        char[] ch = Transform2(string);

        ch = Tututu(ch);

        Transform3(ch);
    }

    public static String Transform1(int num){
        String string = Integer.toBinaryString(num);
        string = "0" + string + ",";
        System.out.println("Преобразуйте это число в двоичное:"+string);
        return string;
    }
    public static char[] Transform2(String string){

        string = string.replace("1","10");
        string = string.replace(",","110");

        System.out.println("Преобразуйте этот номер в двоичный добавочный номер:"+string);
        System.out.println();

        char[] ch = string.toCharArray();
        return ch;
    }

    public static char[] Tututu(char[] ch){
        int[][] array1 = {{0,0},{0,1},{1,0},{1,1},{10,0},{11,0}};
        int[][] array2 = {{0,0},{1,0},{0,1},{10,0},{11,1},{0,1}};

        int NT = 0;

        for(int i = 0;i < ch.length;i++){
            int index =  Search(NT,ch[i]-'0',array1);
            NT = array2[index][0];
            ch[i] = (char)(array2[index][1]+'0');
            System.out.print(" "+(i+1)+" Результат второй поисковой команды:");
            System.out.println(ch);
        }
        return ch;

    }
  public static int Search(int NT,int SR,int[][] array1){
        for(int i = 0;i < 6;i++) {
            if (NT == array1[i][0] && SR == array1[i][1]) {
                return i;
            }
        }
        return -1;
    }
    public static void Transform3(char[] ch){
        String str = new String(ch);
        str +="110";
        System.out.println();
        System.out.println("Наконец-то получил:");
        System.out.println("Двоичный внутренний номер:"+str);

        str = str.replace("110",",");
        str = str.replace("10","1");
        System.out.println("Преобразовать в двоичный:"+str);

        int index1 = str.indexOf("1");
        str = str.substring(index1,str.length()-2);
        System.out.print("Преобразовать в десятичное:");
        System.out.println(Integer.parseInt(str,2));

    }
}
