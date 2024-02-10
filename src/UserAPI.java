import java.util.List;

public interface UserAPI {
    // This is the UserAPI interface 
	public void setInputSource(String source);
	public void setOutputSource(String destination);
	public void setInputDelimiter(String inD);
	public void setOutputDelimiter(String outD);
	
	public String executeComputation(List<Integer> l); 
	
}

