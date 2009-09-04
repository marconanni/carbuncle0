package Highlight;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.PlainDocument;
import javax.swing.text.PlainView;
import javax.swing.text.Segment;
import javax.swing.text.Utilities;

public class CaTraScaCodeView extends PlainView {

    private static HashMap<Pattern, Color> patternColors;
    private static String ELEMENTS = "\\b(CaTraSca|CONTINUE|MAGAZZINO|VIA|N|DA|A|GIACENZA INIZIALE|MODELLO|MARCA|CARICO|TRASFORMAZIONE|SCARICO)\\b";
    private static String SYMBOLS = "(\\{|\\}|,|\\.|;|:)";

    public CaTraScaCodeView(Element elem) {
        super(elem);
        getDocument().putProperty(PlainDocument.tabSizeAttribute, 3);
        
        patternColors = new HashMap<Pattern, Color>();
        patternColors.put(Pattern.compile(ELEMENTS), new Color(80, 150, 204));
        patternColors.put(Pattern.compile(SYMBOLS), new Color(205, 50, 50));
    }

    @Override
    protected int drawUnselectedText(Graphics graphics, int x, int y, int p0, int p1) throws BadLocationException {
        Document doc = getDocument();
        String text = doc.getText(p0, p1 - p0);

        Segment segment = getLineBuffer();

        SortedMap<Integer, Integer> startMap = new TreeMap<Integer, Integer>();
        SortedMap<Integer, Color> colorMap = new TreeMap<Integer, Color>();

        // Match all regexes on this snippet, store positions
        for (Map.Entry<Pattern, Color> entry : patternColors.entrySet()) {

            Matcher matcher = entry.getKey().matcher(text);

            while (matcher.find()) {
                startMap.put(matcher.start(), matcher.end());
                colorMap.put(matcher.start(), entry.getValue());
            }
        }

        // TODO: check the map for overlapping parts

        int i = 0;

        // Colour the parts
        for (Map.Entry<Integer, Integer> entry : startMap.entrySet()) {
            int start = entry.getKey();
            int end = entry.getValue();

            if (i < start) {
                graphics.setColor(Color.black);
                doc.getText(p0 + i, start - i, segment);
                x = Utilities.drawTabbedText(segment, x, y, graphics, this, i);
            }


            Font currentFont = graphics.getFont();

            graphics.setColor(colorMap.get(start));
            
            i = end;
            doc.getText(p0 + start, i - start, segment);
            x = Utilities.drawTabbedText(segment, x, y, graphics, this, start);
            graphics.setFont(currentFont);

        }

        // Paint possible remaining text black
        if (i < text.length()) {
            graphics.setColor(Color.black);
            doc.getText(p0 + i, text.length() - i, segment);
            x = Utilities.drawTabbedText(segment, x, y, graphics, this, i);
        }

        return x;
    }}
