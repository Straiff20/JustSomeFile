import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

public class MyMethods {

    static void toWrightXML() {
        String encoded = Base64.getEncoder().encodeToString(Konst.PROMOTION_XML_BASE_64.getBytes());

        byte[] decode = Base64.getDecoder().decode(encoded);
        String decodedString = new String(decode);

        byte[] xml = Base64.getDecoder().decode(decodedString.getBytes());
        String xmlDecode = new String(xml);

        try (
                FileOutputStream fos = new FileOutputStream(Konst.PATH_TO_XML_FILE)) {

            // перевод строки в байты
            byte[] buffer = xmlDecode.getBytes();

            fos.write(buffer, 0, buffer.length);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(ConsoleColors.GREEN + "Wright ro XML: Complete");
    }
}