import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class TestDataStorage implements DataStorageAPI{
  //  private DataStorageAPI dataStorage; 

   @Test
    public void testDataStorage() {
        // Constructor
      
        DataStorage dataStorageMock = Mockito.mock(DataStorage.class);

        when(dataStorageMock.saveData(any(String.class))).thenReturn(true);

        boolean result = dataStorageMock.saveData(test data);

        verify(dataStorageMock).saveData(test data);

        assertTrue(result);
    }


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

    
  
