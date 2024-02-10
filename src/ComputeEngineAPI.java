
import java.util.List;
 
public interface ComputeEngineAPI { 

	public void initializeJob();

	public void readInput(List<Integer> input);

	public List<List<Integer>> writeOutput();

	public void performComputation();

}
