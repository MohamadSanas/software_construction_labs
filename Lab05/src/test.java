import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class test{
    public static void main(String [] args){
        try{
            File inputFile=new File("wf");

            DocumentBuilderFactory dbFact=DocumentBuilderFactory.newDefaultInstance();
            DocumentBuilder dBbuild=dbFact.newDocumentBuilder();
            Document DOC=dBbuild.parse(inputFile);

            
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }
}
