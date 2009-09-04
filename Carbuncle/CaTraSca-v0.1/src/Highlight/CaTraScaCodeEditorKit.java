package Highlight;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.ViewFactory;

public class CaTraScaCodeEditorKit extends StyledEditorKit
{
	private ViewFactory catrascaViewFactory;

	public CaTraScaCodeEditorKit()
	{
		catrascaViewFactory = new CaTraScaViewFactory();
	}

	@Override
    public ViewFactory getViewFactory()
	{
        return catrascaViewFactory;
    }

    @Override
    public String getContentType()
    {
        return "text/cts";
    }
}
