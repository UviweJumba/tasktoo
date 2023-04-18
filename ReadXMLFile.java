import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

public class ReadXMLFile {

   public static void main(String argv[]) {

      try {
         File inputFile = new File("input.xml");
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);
         doc.getDocumentElement().normalize();
         System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
         NodeList nList = doc.getElementsByTagName("employee");
         System.out.println("----------------------------");

         for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               NodeList childList = nNode.getChildNodes();

               for (int i = 0; i < childList.getLength(); i++) {
                  Node childNode = childList.item(i);

                  if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                     System.out.println(childNode.getNodeName() + ": " + childNode.getTextContent());
                  }
               }
            }
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}