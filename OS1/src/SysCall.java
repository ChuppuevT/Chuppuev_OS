
import java.util.Arrays;
import java.util.List;

public class SysCall {
	Argument arg = new Argument();
	public SysCall(String... args) {
		arg = new Argument(args);
	}

	public List getArgs() {
		return arg.getArgs();
	}

	public String messedg() {
		return "Вызов выполнен";
	}

}
