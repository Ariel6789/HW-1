import java.util.ArrayList;
import java.util.List;

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
    public String output(List<Integer> l) {
        // Empty
        return "";
    }
}
