import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Core 
{
	Stack stack= new Stack();
	public HashMap<Integer, SysCall> SystemCalls;
	
	public Core(Stack stack)
	{
	        this.stack = stack;
	        SystemCalls = new HashMap<>();
	        SystemCalls.put(0,new SysCall("Copy"));
	        SystemCalls.put(1,new SysCall("Past"));
	        SystemCalls.put(2,new SysCall("Cut", "Past"));
	        SystemCalls.put(3,new SysCall("Del"));
	        SystemCalls.put(4,new SysCall("Read"));
	}
	
	public void start_Call(int id)	{	
	    if (!SystemCalls.containsKey(id))
	    {
	    	System.out.print("Вызванный номер "+id+" не существует\n");
	        return;
	    }
	    
	    for (int i=SystemCalls.get(id).getArgs().size()-1; i>=0; i--)
	    {	    	
	    	if (!stack.remove().equals(SystemCalls.get(id).getArgs().get(i))) 
	        {	    		
	    		System.out.println("Аргументы не совпадают" + " id =" + id);
	            return;
	        }
	    }		    
	
	    System.out.println(SystemCalls.get(id).messedg()+ ": id = " + id + ", аргументы =" + SystemCalls.get(id).getArgs().toString());
	    
	}
}
