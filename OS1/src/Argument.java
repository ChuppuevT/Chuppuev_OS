
import java.util.Arrays;
import java.util.List;

public class Argument {
	private List<String> arguments;

	public Argument(String... args) {
		arguments = Arrays.asList(args);
	}

	public List getArgs() {
		return arguments;
	}

	

}