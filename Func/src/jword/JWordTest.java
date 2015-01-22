package jword;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.independentsoft.office.ExtendedBoolean;
import com.independentsoft.office.IContentElement;
import com.independentsoft.office.Unit;
import com.independentsoft.office.UnitType;
import com.independentsoft.office.drawing.Extents;
import com.independentsoft.office.drawing.Offset;
import com.independentsoft.office.drawing.Picture;
import com.independentsoft.office.drawing.PresetGeometry;
import com.independentsoft.office.drawing.ShapeType;
import com.independentsoft.office.drawing.Transform2D;
import com.independentsoft.office.vml.Position;
import com.independentsoft.office.vml.Shape;
import com.independentsoft.office.vml.ShapeStyle;
import com.independentsoft.office.vml.TextBox;
import com.independentsoft.office.word.BookmarkEnd;
import com.independentsoft.office.word.BookmarkStart;
import com.independentsoft.office.word.BottomBorder;
import com.independentsoft.office.word.DrawingObject;
import com.independentsoft.office.word.FieldCode;
import com.independentsoft.office.word.HorizontalAlignmentType;
import com.independentsoft.office.word.Hyperlink;
import com.independentsoft.office.word.LineSpacingRule;
import com.independentsoft.office.word.Paragraph;
import com.independentsoft.office.word.Run;
import com.independentsoft.office.word.Spacing;
import com.independentsoft.office.word.StandardBorderStyle;
import com.independentsoft.office.word.Tab;
import com.independentsoft.office.word.TabLeaderCharacter;
import com.independentsoft.office.word.TabType;
import com.independentsoft.office.word.Underline;
import com.independentsoft.office.word.VmlObject;
import com.independentsoft.office.word.WordDocument;
import com.independentsoft.office.word.drawing.DrawingObjectSize;
import com.independentsoft.office.word.drawing.Inline;
import com.independentsoft.office.word.fields.ComplexField;
import com.independentsoft.office.word.fields.ComplexFieldCharacterType;
import com.independentsoft.office.word.fields.PageReference;
import com.independentsoft.office.word.fields.TableOfContents;
import com.independentsoft.office.word.fonts.ThemeFont;
import com.independentsoft.office.word.sections.PageMargins;
import com.independentsoft.office.word.sections.PageSize;
import com.independentsoft.office.word.sections.Section;
import com.independentsoft.office.word.styles.Style;
import com.independentsoft.office.word.styles.StyleDefinitions;
import com.independentsoft.office.word.styles.StyleType;
import com.independentsoft.office.word.tables.Cell;
import com.independentsoft.office.word.tables.Row;
import com.independentsoft.office.word.tables.Table;
import com.independentsoft.office.word.tables.TableWidthUnit;
import com.independentsoft.office.word.tables.Width;

public class JWordTest {

	public static void main(String[] args) {
//		insertImage();
//		tableTest();
		test();
//		page();
//		createTableContent();
//		custom();
//		pageBrake();
//		textBox();
	}
	
	private static void create(){
		
	}

	private static void test() {
        try
        {
//        	WordDocument doc = new WordDocument("./yunTianYi.docx");
            WordDocument doc = new WordDocument();

//            doc.replace("{no.}", "12345");
//            doc.replace("{keywords}","关键词");
//
//            doc.replace("{转发增量图}", getImageRun());
//            
//            List<Table> tables = doc.getTables();
//            System.out.println("tables.size:"+tables.size());
//            
//            Table newsTable = tables.get(2);
//            for(IContentElement i : newsTable.getContentElements()){
//            	handleElement(i);
//            }
            
            
//            addDataToTable(table);
            
            Run run = new Run("baidu");
            Underline u = new Underline();
            com.independentsoft.office.word.Color c = new com.independentsoft.office.word.Color();
            c.setHexValue("0x00ddff");
            u.setColor(c);
            run.setUnderline(u);
            run.setFontSize(50);
            
            Hyperlink link = new Hyperlink();
			link.setTarget("http://www.baidu.com");
			link.add(run);
			
			Paragraph p = new Paragraph();
			
			p.add(link);
			
			doc.getBody().add(p);
            
            doc.save("./replaceTest.docx");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
	
	
	private static void handleElement(IContentElement element) {
		// TODO Auto-generated method stub
		if(element.getContentElements().size()>0){
			for(IContentElement temp:element.getContentElements()){
				System.out.println(temp);
				handleElement(temp);
			}
		}
	}

	private static void addDataToTable(Table table){
		
		List<TableItem> items = new ArrayList<TableItem>();
		
		TableItem item1 = new TableItem("排序2", 1101);
		TableItem item2 = new TableItem("新闻指数2", 1559);
		TableItem item3 = new TableItem("新闻标题2", 2594);
		TableItem item4 = new TableItem("新闻来源2", 1517);
		TableItem item5 = new TableItem("发表日期2", 1876);
		
		items.add(item1);
		items.add(item2);
		items.add(item3);
		items.add(item4);
		items.add(item5);
		
		Row row = new Row();
		
		for(TableItem item:items){
			row.add(item.getCell());
		}
		
		table.add(row);
		
	}
	
	static class TableItem {
		String name;
		int width ;
		
		public TableItem(String name, int width) {
			super();
			this.name = name;
			this.width = width;
		}

		public Cell getCell(){
			Run run = new Run(name);

			Hyperlink link = new Hyperlink();
			link.setTarget("http://www.baidu.com");
			link.setAnchor("百度");
			
			Paragraph p = new Paragraph();
			p.setHorizontalTextAlignment(HorizontalAlignmentType.CENTER);
//			p.add(run);
			
			p.add(link);
			
			Cell c = new Cell();
			c.setWidth(new Width(TableWidthUnit.POINT, width));
			c.add(p);
			
			return c;
		}
	}
	
	private static void createTableContent(){
		   try
	        {
	            WordDocument doc = new WordDocument();

	            ComplexField startComplexField = new ComplexField(ComplexFieldCharacterType.START);
	            ComplexField separatorComplexField = new ComplexField(ComplexFieldCharacterType.SEPARATOR);
	            ComplexField endComplexField = new ComplexField(ComplexFieldCharacterType.END);

	            Run startComplexFieldRun = new Run();
	            startComplexFieldRun.add(startComplexField);

	            Run separatorComplexFieldRun = new Run();
	            separatorComplexFieldRun.add(separatorComplexField);

	            Run endComplexFieldRun = new Run();
	            endComplexFieldRun.add(endComplexField);

	            TableOfContents toc = new TableOfContents();
	            FieldCode tocFieldCode = new FieldCode(toc);

	            Run tocFieldCodeRun = new Run();
	            tocFieldCodeRun.add(tocFieldCode);

	            Run firstChapterTocEntryRun = new Run("First chapter");

	            PageReference firstChapterReference = new PageReference();
	            firstChapterReference.setValue("TocEntry1");

	            FieldCode firstChapterFieldCode = new FieldCode(firstChapterReference);

	            Run firstChapterFieldCodeRun = new Run();
	            firstChapterFieldCodeRun.add(firstChapterFieldCode);

	            Run secondChapterTocEntryRun = new Run("Second chapter");

	            PageReference secondChapterReference = new PageReference();
	            secondChapterReference.setValue("TocEntry2");

	            FieldCode secondChapterFieldCode = new FieldCode(secondChapterReference);

	            Run secondChapterFieldCodeRun = new Run();
	            secondChapterFieldCodeRun.add(secondChapterFieldCode);

	            Run tabRun = new Run();
	            tabRun.addTab();

	            Tab tab1 = new Tab();
	            tab1.setPosition(9350);
	            tab1.setLeader(TabLeaderCharacter.DOT);
	            tab1.setType(TabType.RIGHT);

	            Paragraph tocStartParagraph = new Paragraph();
	            tocStartParagraph.add(startComplexFieldRun);
	            tocStartParagraph.add(tocFieldCodeRun);
	            tocStartParagraph.add(separatorComplexFieldRun);

	            Paragraph firstTocEntryParagraph = new Paragraph();
	            firstTocEntryParagraph.getTabs().add(tab1);
	            firstTocEntryParagraph.add(firstChapterTocEntryRun);
	            firstTocEntryParagraph.add(tabRun);
	            firstTocEntryParagraph.add(startComplexFieldRun);
	            firstTocEntryParagraph.add(firstChapterFieldCodeRun);
	            firstTocEntryParagraph.add(separatorComplexFieldRun);
	            firstTocEntryParagraph.add(endComplexFieldRun);

	            Paragraph secondTocEntryParagraph = new Paragraph();
	            secondTocEntryParagraph.getTabs().add(tab1);
	            secondTocEntryParagraph.add(secondChapterTocEntryRun);
	            secondTocEntryParagraph.add(tabRun);
	            secondTocEntryParagraph.add(startComplexFieldRun);
	            secondTocEntryParagraph.add(secondChapterFieldCodeRun);
	            secondTocEntryParagraph.add(separatorComplexFieldRun);
	            secondTocEntryParagraph.add(endComplexFieldRun);

	            Paragraph tocEndParagraph = new Paragraph();
	            tocEndParagraph.add(endComplexFieldRun);

	            BookmarkStart startBookmark1 = new BookmarkStart();
	            startBookmark1.setName("TocEntry1");
	            startBookmark1.setID(1);

	            BookmarkEnd endBookmark1 = new BookmarkEnd();
	            endBookmark1.setID(1);

	            Run firstChapterRun = new Run("First Chapter");

	            Paragraph firstChapterParagraph = new Paragraph();
	            firstChapterParagraph.setPageBreakBefore(ExtendedBoolean.TRUE);
	            firstChapterParagraph.add(startBookmark1);
	            firstChapterParagraph.add(firstChapterRun);
	            firstChapterParagraph.add(endBookmark1);

	            BookmarkStart startBookmark2 = new BookmarkStart();
	            startBookmark2.setName("TocEntry2");
	            startBookmark2.setID(2);

	            BookmarkEnd endBookmark2 = new BookmarkEnd();
	            endBookmark2.setID(2);

	            Run secondChapterRun = new Run("Second Chapter");

	            Paragraph secondChapterParagraph = new Paragraph();
	            secondChapterParagraph.setPageBreakBefore(ExtendedBoolean.TRUE);
	            secondChapterParagraph.add(startBookmark2);
	            secondChapterParagraph.add(secondChapterRun);
	            secondChapterParagraph.add(endBookmark2);
	            
	            doc.getBody().add(tocStartParagraph);
	            doc.getBody().add(firstTocEntryParagraph);
	            doc.getBody().add(secondTocEntryParagraph);
	            doc.getBody().add(tocEndParagraph);
	            doc.getBody().add(firstChapterParagraph);
	            doc.getBody().add(secondChapterParagraph);

	            doc.save("./tableContent.docx");
	        }catch (Exception e){
	            System.out.println(e.getMessage());
	            e.printStackTrace();
	        }
	}
	
	private static void page(){
		 try
	        {
	            WordDocument doc = new WordDocument();

	            PageMargins margins = new PageMargins();
	            margins.setBottom(1440); // 1 inch
	            margins.setLeft(1440); // 1 inch
	            margins.setRight(1440); // 1 inch
	            margins.setTop(1440); // 1 inch
	            margins.setFooter(720); // 1/2 inch
	            margins.setHeader(720); // 1/2 inch

	            Section section = new Section();
	            section.setPageSize(new PageSize(12240, 15840)); //8.5 x 11 in
	            section.setPageMargins(margins);
	            
	            Run run1 = new Run();
	            run1.addText("Some text on the first page.");

	            Paragraph paragraph1 = new Paragraph();
	            paragraph1.add(run1);

	            Paragraph paragraph2 = new Paragraph();
	            paragraph2.add(run1);

	            Paragraph paragraph3 = new Paragraph();
	            paragraph3.add(run1);
	            paragraph3.setSection(section); //last paragraph on the first page
	            
	            //first page
	            doc.getBody().add(paragraph1);
	            doc.getBody().add(paragraph2);
	            doc.getBody().add(paragraph3);
	            
	            Run run2 = new Run();
	            run2.addText("Some text on the second page.");

	            Paragraph paragraph4 = new Paragraph();
	            paragraph4.add(run2);
	            
	            //second page
	            doc.getBody().add(paragraph4);

	            doc.save("./page.docx");
	        }
	        catch (Exception e)
	        {
	            System.out.println(e.getMessage());
	            e.printStackTrace();
	        }
	}
	
	private static void tableTest(){
		try
        {
            WordDocument doc = new WordDocument();

            Run run1 = new Run("Quantity");
            run1.setBold(ExtendedBoolean.TRUE);

            Paragraph paragraph1 = new Paragraph();
            paragraph1.add(run1);

            Run run2 = new Run("Item #");
            run2.setBold(ExtendedBoolean.TRUE);

            Paragraph paragraph2 = new Paragraph();
            paragraph2.add(run2);

            Run run3 = new Run("Description");
            run3.setBold(ExtendedBoolean.TRUE);

            Paragraph paragraph3 = new Paragraph();
            paragraph3.add(run3);

            Run run4 = new Run("Unit Price");
            run4.setBold(ExtendedBoolean.TRUE);

            Paragraph paragraph4 = new Paragraph();
            paragraph4.add(run4);

            Run run5 = new Run("Line Total");
            run5.setBold(ExtendedBoolean.TRUE);

            Paragraph paragraph5 = new Paragraph();
            paragraph5.add(run5);

            Cell cell1 = new Cell();
            cell1.setWidth(new Width(TableWidthUnit.POINT, 1260));
//            cell1.setShading(new Shading(ShadingPattern.PERCENT_10));
            cell1.add(paragraph1);

            Cell cell2 = new Cell();
            cell2.setWidth(new Width(TableWidthUnit.POINT, 1440));
//            cell2.setShading(new Shading(ShadingPattern.PERCENT_10));
            cell2.add(paragraph2);

            Cell cell3 = new Cell();
            cell3.setWidth(new Width(TableWidthUnit.POINT, 4140));
//            cell3.setShading(new Shading(ShadingPattern.PERCENT_10));
            cell3.add(paragraph3);

            Cell cell4 = new Cell();
            cell4.setWidth(new Width(TableWidthUnit.POINT, 1620));
//            cell4.setShading(new Shading(ShadingPattern.PERCENT_10));
            cell4.add(paragraph4);

            Cell cell5 = new Cell();
            cell5.setWidth(new Width(TableWidthUnit.POINT, 1620));
//            cell5.setShading(new Shading(ShadingPattern.PERCENT_10));
            cell5.add(paragraph5);

            Row firstRow = new Row();
            firstRow.add(cell1);
            firstRow.add(cell2);
            firstRow.add(cell3);
            firstRow.add(cell4);
            firstRow.add(cell5);

            Row row1 = new Row();
//            row1.add(new Cell());
//            row1.add(new Cell());
//            row1.add(new Cell());
//            row1.add(new Cell());
//            row1.add(new Cell());
            row1.add(cell1);
            row1.add(cell2);
            row1.add(cell3);
            row1.add(cell4);
            row1.add(cell5);

            Table table1 = new Table(StandardBorderStyle.SINGLE_LINE);

            table1.add(firstRow);
            
            table1.add(row1);
            table1.add(row1);
            table1.add(row1);
            table1.add(row1);
            table1.add(row1);
            table1.add(row1);
            table1.add(row1);
            table1.add(row1);
            table1.add(row1);
            table1.add(row1);

            doc.getBody().add(table1);

            doc.save("./tablesTest.docx");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
	}

	private static void insertImage() {
		try {
			WordDocument doc = new WordDocument("./yunTianYi.docx");

			Picture picture = new Picture("./temp.png");
			Unit pictureWidth = new Unit(600, UnitType.PIXEL);
			Unit pictureHeight = new Unit(260, UnitType.PIXEL);

			Offset offset = new Offset(0, 0);
			Extents extents = new Extents(pictureWidth, pictureHeight);

			picture.getShapeProperties().setPresetGeometry(
					new PresetGeometry(ShapeType.RECTANGLE));
			picture.getShapeProperties().setTransform2D(
					new Transform2D(offset, extents));
			picture.setID("1");
			picture.setName("image.jpg");

			Inline inline = new Inline(picture);
			inline.setSize(new DrawingObjectSize(pictureWidth, pictureHeight));
			inline.setID("1");
			inline.setName("Picture 1");
			inline.setDescription("image.jpg");

			DrawingObject drawingObject = new DrawingObject(inline);

			Run run1 = new Run();
			run1.addText("Below is an image:");

			Run run2 = new Run();
			run2.add(drawingObject);

			Paragraph paragraph1 = new Paragraph();
			paragraph1.add(run1);
			paragraph1.add(run2);

			doc.getBody().add(paragraph1);

			doc.save("./jword.docx");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	private static Run getImageRun(){
		try {
			Picture picture = new Picture("./temp.png");
			Unit pictureWidth = new Unit(640, UnitType.PIXEL);
			Unit pictureHeight = new Unit(480, UnitType.PIXEL);

			Offset offset = new Offset(0, 0);
			Extents extents = new Extents(pictureWidth, pictureHeight);

			picture.getShapeProperties().setPresetGeometry(
					new PresetGeometry(ShapeType.RECTANGLE));
			picture.getShapeProperties().setTransform2D(
					new Transform2D(offset, extents));
			picture.setID("1");
			picture.setName("image.jpg");
			
			Inline inline = new Inline(picture);
			inline.setSize(new DrawingObjectSize(pictureWidth, pictureHeight));
			inline.setID("1");
			inline.setName("Picture 1");
			inline.setDescription("image.jpg");
			
			DrawingObject drawingObject = new DrawingObject(inline);
			Run run = new Run();
			run.add(drawingObject);

			return run;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	private static void custom(){
		 try
	        {
	            WordDocument doc = new WordDocument();

	            Style style1 = new Style();
	            style1.setID("Heading 1");
	            style1.setName("Heading 1");
	            style1.setType(StyleType.PARAGRAPH);
	            style1.setPrimary(ExtendedBoolean.TRUE);
	            style1.setUserInterfacePriority(9);

	            style1.getParagraphProperties().setKeepNext(ExtendedBoolean.TRUE);
	            style1.getParagraphProperties().setKeepLines(ExtendedBoolean.TRUE);
	            style1.getParagraphProperties().setOutlineLevel(0);

	            Spacing spacing1 = new Spacing();
	            spacing1.setAfter(0);
	            spacing1.setBefore(480);

	            style1.getParagraphProperties().setSpacing(spacing1);

	            style1.getRunProperties().getFonts().setAsciiThemeFont(ThemeFont.MAJOR_HIGH_ANSI);
	            style1.getRunProperties().getFonts().setEastAsiaThemeFont(ThemeFont.MAJOR_EAST_ASIA);
	            style1.getRunProperties().getFonts().setHighAnsiThemeFont(ThemeFont.MAJOR_HIGH_ANSI);
	            style1.getRunProperties().getFonts().setComplexScriptThemeFont(ThemeFont.MAJOR_COMPLEX_SCRIPT);
	            style1.getRunProperties().setBold(ExtendedBoolean.TRUE);
	            style1.getRunProperties().setComplexScriptBold(ExtendedBoolean.TRUE);
	            style1.getRunProperties().setFontSize(28); //14 points
	            style1.getRunProperties().setComplexScriptFontSize(28); //14 points
	           
	            Style style2 = new Style();
	            style2.setID("Title");
	            style2.setName("Title");
	            style2.setType(StyleType.PARAGRAPH);
	            style2.setPrimary(ExtendedBoolean.TRUE);
	            style2.setUserInterfacePriority(9);
	           
	            BottomBorder bottomBorder = new BottomBorder(StandardBorderStyle.SINGLE_LINE);
	            bottomBorder.setSpace(4);
	            bottomBorder.setWidth(8);

	            style2.getParagraphProperties().setBottomBorder(bottomBorder);
	            style2.getParagraphProperties().setIgnoreSpace(ExtendedBoolean.TRUE);

	            Spacing spacing2 = new Spacing();
	            spacing2.setAfter(300);
	            spacing2.setLine(240);
	            spacing2.setLineRule(LineSpacingRule.AUTO);

	            style2.getParagraphProperties().setSpacing(spacing2);

	            style2.getRunProperties().getFonts().setAsciiThemeFont(ThemeFont.MAJOR_HIGH_ANSI);
	            style2.getRunProperties().getFonts().setEastAsiaThemeFont(ThemeFont.MAJOR_EAST_ASIA);
	            style2.getRunProperties().getFonts().setHighAnsiThemeFont(ThemeFont.MAJOR_HIGH_ANSI);
	            style2.getRunProperties().getFonts().setComplexScriptThemeFont(ThemeFont.MAJOR_COMPLEX_SCRIPT);
	            style2.getRunProperties().setSpacing(5);
	            style2.getRunProperties().setFontKern(28);
	            style2.getRunProperties().setFontSize(52); //26 points
	            style2.getRunProperties().setComplexScriptFontSize(52); //26 points

	            StyleDefinitions documentStyles = new StyleDefinitions();
	            documentStyles.getStyles().add(style1);
	            documentStyles.getStyles().add(style2);

	            doc.setStyleDefinitions(documentStyles);

	            Run run1 = new Run();
	            run1.addText("Text with style \"Heading 1\"");

	            Run run2 = new Run();
	            run2.addText("Text with style \"Title\"");

	            Paragraph paragraph1 = new Paragraph();
	            paragraph1.setStyleName("Heading 1");
	            paragraph1.add(run1);

	            Paragraph paragraph2 = new Paragraph();
	            paragraph2.setStyleName("Title");
	            paragraph2.add(run2);

	            Paragraph emptyParagraph = new Paragraph();

	            doc.getBody().add(paragraph1);
	            doc.getBody().add(emptyParagraph);
	            doc.getBody().add(paragraph2);

	            doc.save("./custom.docx");
	        }
	        catch (Exception e)
	        {
	            System.out.println(e.getMessage());
	            e.printStackTrace();
	        }
	}
	
	private static void pageBrake(){
		try
        {
            WordDocument doc = new WordDocument();

            Run run1 = new Run();
            run1.addText("Some text on the first page.");

            Paragraph paragraph1 = new Paragraph();
            paragraph1.add(run1);

            Run run2 = new Run();
            run2.addText("Some text on the second page.");

            Paragraph paragraph2 = new Paragraph();
            paragraph2.add(run2);
            paragraph2.setPageBreakBefore(ExtendedBoolean.TRUE);

            doc.getBody().add(paragraph1); //on the first page
            doc.getBody().add(paragraph2); //on the second page

            doc.save("./pageBreak.docx");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
	}
	
	private static void textBox(){
		  try
	        {
	            WordDocument doc = new WordDocument();

	            Run textBoxRun = new Run();
	            textBoxRun.addText("Simple text inside a textbox");

	            Paragraph textBoxParagraph = new Paragraph();
	            textBoxParagraph.add(textBoxRun);

	            TextBox textBox = new TextBox();
	            textBox.getContent().add(textBoxParagraph);

	            ShapeStyle shapeStyle = new ShapeStyle();
	            shapeStyle.setPosition(Position.ABSOLUTE);
	            shapeStyle.setWidth("100pt");
	            shapeStyle.setHeight("75pt");

	            Shape shape = new Shape(shapeStyle);
	            shape.getContent().add(textBox);

	            VmlObject vmlObject = new VmlObject();
	            vmlObject.getContent().add(shape);

	            Run run1 = new Run();
	            run1.add(vmlObject);

	            Paragraph paragraph1 = new Paragraph();
	            paragraph1.add(run1);

	            doc.getBody().add(paragraph1);

	            doc.save("./textBox.docx");
	        }
	        catch (Exception e)
	        {
	            System.out.println(e.getMessage());
	            e.printStackTrace();
	        }
	}
}
