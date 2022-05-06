import java.io.*;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    while(true){
      try{
        double money = Double.parseDouble(scan.nextLine());
        if(money <= 0)
      }catch(Exception e){
        System.out.println(e.getMessage());
      }
    }
    scan.close();
  }
}