import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Memory mmU = new Memory(2048, 256);
        int page_index;
        Scanner scanner = new Scanner(System.in);
       
        while(true){
            System.out.println("¬ведите индекс страницы в таблице страниц :");
            page_index = scanner.nextInt();
            if (page_index >= 0 && page_index < mmU.getSizeTablePages()){
                mmU.inputNumberOfPage(page_index);
            }
        }
    }

}
