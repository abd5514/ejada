package org.em.utils.handler;

import org.em.core.instance.BetaDriver.WebBase;
import org.em.utils.PropReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class XMLReader  {



    final static Map<String, String> map;
    private final String fileName;

    public  XMLReader (String fileName )
    {
        this.fileName=fileName;
    }

    static {
        map = new HashMap<> ();
        map.put (WebBase.xmlPathName, PropReader.readConfig("xml-path-web"));

    }

    public  String getXMLData(String dataFor)
    {
        String nodeValue = null;
        try{
            File file = new File( map.get (fileName));
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            org.w3c.dom.Document document = documentBuilder.parse(file);
            nodeValue =  document.getElementsByTagName(dataFor).item(0).getTextContent();
        }
        catch(Exception e)
        {
            nodeValue = null;
        }

        return nodeValue;
    }
}
