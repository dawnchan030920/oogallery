public class HtmlImage {
	private String imageName;
	private String alternateText;

	/**
	 *  Constructor 
	 */
	public HtmlImage(String iName, String aText) {
		imageName = iName;
		alternateText = aText;
	}


	/**
	 *  Construct the HTML source for the tag
	 */
	public String buildHtml() {
		return ("<IMG src='"  + imageName + "' alt='" + alternateText + "'>");
	}

} 

