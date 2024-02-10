import java.util.ArrayList;
import java.util.List;
// This is the TestDataStorage class that implements the DataStorageAPI interface
public class TestDataStorage implements DataStorageAPI{
  //  private DataStorageAPI dataStorage; 

    public void testDataStorage() {
        // Constructor
    }

    @Override
    public List<Integer> input(String input) {
        // Empty
        return new ArrayList<Integer>();
    }

    @Override
    public String outPut(List<Integer> l) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'outPut'");
    }
}
