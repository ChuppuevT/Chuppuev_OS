
import java.util.ArrayList;

public class SecondCh {
    ArrayList<Record> Table;
    PhysMem physicalMemory;

    public SecondCh(ArrayList<Record> Table, PhysMem physicalMemory) {
        this.Table = Table;
        this.physicalMemory = physicalMemory;
    }
    
    
    
    
    public void algoritm() {
        for(int i = 0; i< Table.size(); i++) {
            int number = Table.get(i).getNumberOfPhysicalPage();
            if(!Table.get(i).r() && Table.get(i).isInPhysicalMemory()) {
                System.out.println("Страница под номером " + Table.get(i).getPageNumber()
                		+ " выгружена на диск, так как к ней не обращались");
                physicalMemory.sendPageToDisk(number);
                Table.get(i).removeFromPhysicalMemory();
                Table.get(i).setNumberOfPhysicalPage(-1);
                break;
            }
            else {
                Table.get(i).r(false);
                Table.add(Table.get(i));
                Table.remove(i);
                System.out.println("Страница под номером " + Table.get(i).getPageNumber() 
                		+ " перемещена в конец очереди, обращение сброшено");
            }
        }
    }
}
