import java.util.List;

public class TestUser implements UserAPI{ //or UserInterface the naming on it is not clear
    private ComputeEngineInterface computeEngine;

    public TestUser(ComputeEngineInterface computeEngine) {
        this.computeEngine = computeEngine;
    }
    
    @Override
    public void setInputSource(String src) {
        // Empty
    }

    @Override
    public void setOutputSource(String destination) { 
        // Empty
    }

    @Override
    public void setInputDelimiter(String inD) {
        // Empty
    }

    @Override
    public void setOutputDelimiter(String outD) {
        // Empty
    }

    @Override
    public String executeComputation(List<Integer> l) {
        // EMPTY
        return ""; 
    }
}


