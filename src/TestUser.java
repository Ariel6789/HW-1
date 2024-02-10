import java.util.List;
// this is the TestUser class that implements the UserAPI interface
public class TestUser implements UserAPI{ //or UserInterface the naming on it is not clear
    private ComputeEngineAPI computeEngine;

    public TestUser(ComputeEngineAPI computeEngine) {
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'executeComputaion'");
    }

}


