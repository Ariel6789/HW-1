import java.util.List;

public interface ComputeEngineAP {

	public void initializeJob();

	public void readInput(List<Integer> input);

	public List<List<Integer>> writeOutput();

	public void preformComputation();

}
