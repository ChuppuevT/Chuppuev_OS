
import java.util.ArrayList;

public class MemManager {
    PhysMem physicalMemory;
    SecondCh clock;

    public MemManager() {
        physicalMemory = new PhysMem();
    }

    public void implementPage(int address, ArrayList<Record> Table) {
        if(Table.get(address).isInPhysicalMemory() == false) {
        	int physicalPage = physicalMemory.getFreePage();
            if(physicalPage!= -1) {
                physicalMemory.takePhysicalPage(physicalPage);
                Table.get(address).sendToPhysicalMemory();
                Table.get(address).setNumberOfPhysicalPage(physicalPage);
                System.out.println("����������� �������� " + address + " ���������� �� ���������� �������� " + physicalPage);
            }
            else{
                System.out.println("��� ��� �������� ������, ������ ��������� ��������� �������");
                clock = new SecondCh(Table, physicalMemory);
                clock.algoritm();
                implementPage(address,Table);
            }
        }
        else {
            System.out.println("�������� " + address +
            		" ���������� �� ���������� �������� "+ Table.get(address).getNumberOfPhysicalPage());
        }
        Table.get(address).r(true);
    }

}
