import java.io.*;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    while(true){
      System.out.println("Would you like to add or withdraw money or exit the program?");
      String answer = scan.nextLine();
      if(answer.toLowerCase().equals("add")){
        try{
          System.out.println("Enter the amount of money you would like to add or a negative number if you wish to exit:");
          double money = Double.parseDouble(scan.nextLine());
          if(money <= 0){
            break;
          }
          FileWriter fw = new FileWriter("dat.txt", true);
          DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd ");  
          LocalDateTime now = LocalDateTime.now();  
          fw.write(dtf.format(now) + "$" + money);
          fw.close();
        }catch(Exception e){
          System.out.println(e.getMessage());
        } 
      }else if(answer.toLowerCase().equals("withdraw")){
        try{
          System.out.println("Enter the amount of money you would like to withdraw or a negative number if you wish to exit:");
          double money = Double.parseDouble(scan.nextLine());
          if(money <= 0){
            break;
          }
          FileWriter fw = new FileWriter("dat.txt", true);
          DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd ");  
          LocalDateTime now = LocalDateTime.now();  
          fw.write(dtf.format(now) + " $" + -money);
          fw.close();
        }catch(Exception e){
          System.out.println(e.getMessage());
        }
      }else if(answer.toLowerCase().equals("exit")){
        System.out.println("Your data has been saved, goodbye!");
        break;
      }else{
        System.out.println("Invalid Input");
      }
    }
    scan.close();
  }
}