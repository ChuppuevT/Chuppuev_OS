import java.util.List;
import java.util.ArrayList;
import java.util.ArrayList;
public class Main 
{
	public static void main(String[] args) 
	{
		
	    Stack stack =new Stack();
	    Core core=new Core(stack);
	
	    stack.add("Copy");  	     
	    core.start_Call(0);
	    
	    stack.add("Past");
	    core.start_Call(1);
	    
	    stack.add("123");
	    core.start_Call(3);
	  
	}
}
