package Highlight;

import javax.swing.text.Element;
import javax.swing.text.View;
import javax.swing.text.ViewFactory;

public class CaTraScaViewFactory implements ViewFactory
{
	public View create(Element elem)
	{
		return new CaTraScaCodeView(elem);
	}
}
