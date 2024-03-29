
package src;

public interface DataStore {
	Iterable<Integer> read(InputConfig input);
	WriteResult appendSingleResult(OutputConfig output, String result, char delimeter);

}