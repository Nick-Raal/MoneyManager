import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    while(true){
      System.out.println("Would you like to add or withdraw money or view balance and changes (view for short) or exit the program?");
      String answer = scan.nextLine();
      if(answer.equalsIgnoreCase("add")){
        try{
          System.out.println("Enter the amount of money you would like to add or a negative number if you wish to exit:");
          double money = Double.parseDouble(scan.nextLine());
          if(money <= 0){
            break;
          }
          FileWriter fw = new FileWriter("dat.txt", true);
          DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd ");  
          LocalDateTime now = LocalDateTime.now();  
          fw.write(dtf.format(now) + "$" + money + "\n");
          fw.close();
        }catch(Exception e){
          System.out.println(e.getMessage());
        } 
      }else if(answer.equalsIgnoreCase("withdraw")){
        try{
          System.out.println("Enter the amount of money you would like to withdraw or a negative number if you wish to exit:");
          double money = Double.parseDouble(scan.nextLine());
          if(money <= 0){
            break;
          }
          FileWriter fw = new FileWriter("dat.txt", true);
          DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd ");  
          LocalDateTime now = LocalDateTime.now();  
          fw.write(dtf.format(now) + "$" + -money + "\n");
          fw.close();
        }catch(Exception e){
          System.out.println(e.getMessage());
        }
      }else if(answer.equalsIgnoreCase("exit")){
        System.out.println("Your data has been saved, goodbye!");
        break;
      }else if(answer.equalsIgnoreCase("view")){
        try{
          Scanner in = new Scanner(new File("dat.txt"));
          double balance = 0;
          while(in.hasNext()){
            String nextLine = in.nextLine();
            System.out.println(nextLine);
            balance += Double.parseDouble(nextLine.substring(nextLine.indexOf("$") + 1));
          }
          in.close();
          System.out.println("\nBalance: $" + balance);
          System.out.println("Would you like to remove a transaction?");
          answer = scan.nextLine();
          if(answer.equalsIgnoreCase("yes")){
            System.out.println("Which transaction would you like to remove? (mm/dd/yy $amount)");
            answer = scan.nextLine();
            Scanner in2 = new Scanner(new File("dat.txt"));
            ArrayList<String> list = new ArrayList<>();
            while(in2.hasNext()){
              list.add(in2.nextLine());
            }
            FileWriter fw = new FileWriter("dat.txt", false);
            for (String s : list) {
              if (!s.equals(answer)) {
                fw.write(s);
              }
            }
            fw.close();
          }
        }catch(Exception e){
          System.out.println(e.getMessage());
        }
      }else{
        System.out.println("Invalid Input");
      }
    }
    scan.close();
  }
}