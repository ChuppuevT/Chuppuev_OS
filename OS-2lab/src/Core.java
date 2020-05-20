import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

public class Core {
	private final Deque<Flow> flows = new ArrayDeque<Flow>();
	private final Deque<Proc> procs = new ArrayDeque<Proc>();
	private final int time = 1;
	private FlowManager flowManager = new FlowManager(flows);

	public Core() {
		Random rnd = new Random();
		createProc(rnd.nextInt(10));
		getAllFlows();
	}

	public void start() {
		while(!flowManager.isFinalWork()) {
			Flow flowInWorkFlow = flowManager.nextFlow();
			if (flowInWorkFlow == null) {
				System.out.println("завершился");
			}
			System.out.println(flowInWorkFlow.getName()+" работает");
			if (flowInWorkFlow.startWork(time)) {
				System.out.println(flowInWorkFlow.getName()+" завершился");
			} else {
				System.out.println(flowInWorkFlow.getName()+" не хватило времени");
				flowManager.flowInEnd(flowInWorkFlow);
			}
		}
	}
	
	private void getAllFlows() {
		for (Proc proc : procs) {
			flows.addAll(proc.getFlows());
		}
	}

	public void createProc(int countProc) {
		for (int i = 0; i < countProc; i++) {
			procs.add(new Proc(String.valueOf(i)));
		}
	}
}