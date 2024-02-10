import java.util.List;
 // This is the ComputeEngineAPI interface
public interface ComputeEngineAPI { 

	public void initializeJob();

	public void readInput(List<Integer> input);

	public List<List<Integer>> writeOutput();

	public void performComputation();

}
