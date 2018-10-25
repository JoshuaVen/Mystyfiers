
public class Script {

	String text;
	boolean isRead;
	
	public Script(String text, boolean isRead) {
		this.text = text;
		this.isRead = isRead;
	}
	
	String read() {
		String display = text;
		this.isRead = true;
		return display;
	}
}
