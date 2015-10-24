/**
 * holds text in a book, which could be a button
 * @author William
 *
 */
public class TextBox {
	Point topLeft, botRight;
	String description;
	public TextBox(Point topLeft, Point botRight, String description)
	{
		this.topLeft = topLeft;
		this.botRight = botRight;
		this.description = description;
	}

}
