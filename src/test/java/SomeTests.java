import org.junit.jupiter.api.Test;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SomeTests {

    @Test
    void checkXMLTest() {
        MyMethods.toWrightXML();
    }

    @Test
    void anotherTest() {
        final String fileName = Konst.PATH_TO_XML_FILE;
        try {
            XMLStreamReader xmlr = XMLInputFactory.newInstance().createXMLStreamReader(fileName, new FileInputStream(fileName));


            while (xmlr.hasNext()) {
                xmlr.next();
                if (xmlr.isStartElement()) {
                    System.out.println(ConsoleColors.YELLOW + xmlr.getLocalName() + " / " + ConsoleColors.GREEN +
                            " " + xmlr.getAttributeLocalName(0) +
                            " " + xmlr.getAttributeLocalName(1) +
                            " " + xmlr.getAttributeLocalName(2));
                } else if (xmlr.isEndElement()) {
                    System.out.print(" /" + ConsoleColors.BLUE + xmlr.getLocalName());
                } else if (xmlr.hasText() && xmlr.getText().trim().length() > 0) {
                    System.out.print(ConsoleColors.CYAN + xmlr.getText());
                }
            }
        } catch (FileNotFoundException | XMLStreamException ex) {
            ex.printStackTrace();
        }
    }
}

