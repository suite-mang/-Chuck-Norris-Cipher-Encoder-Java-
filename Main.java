package chucknorris;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Converter converter =new Converter();
        converter.setMainState();
        while(!converter.isWorking()){
           converter.action(scanner.nextLine());
        }
        scanner.close();
    }

}
