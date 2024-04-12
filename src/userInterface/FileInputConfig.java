package src;


public class FileInputConfig implements InputConfig {

	private final String fileName;

	public FileInputConfig(String fileName) {
		this.fileName = fileName;
	}

	public String getFileName() {
		return fileName;
	}
	public <T> T accept(InputConfigVisitor<T> visitor) {
        return visitor.visitFile(this);
    }
}
