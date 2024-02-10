import java.util.ArrayList;
import java.util.List;
// this is the TestComputeEngine class that implements the ComputeEngineAPI interface
public class TestComputeEngine implements ComputeEngineAPI {
     private DataStorageAPI dataStorage; // instance variable for the DataStorageAPI
    // private UserAPI userAPI; // UserInterface

    public void testComputeEngine(DataStorageAPI dataStorage) {
        this.dataStorage = dataStorage; // could also be an empty constructor 
    }

    @Override
    public void initializeJob() {
        // This method will be used to initialize computation jobs
    }

    @Override
    public void readInput(List<Integer> input) {
        // This method will read input from the data storage
    }

    @Override
    public List<List<Integer>> writeOutput() {
        // This method will write the computation results to the data storage 
        return new ArrayList<List<Integer>>();
    }
    
    @Override
    public void performComputation() {
        // TODO Auto-generated method stub // will handle the comptatuon logic 
        throw new UnsupportedOperationException("Unimplemented method 'preformComputation'");
    }
}