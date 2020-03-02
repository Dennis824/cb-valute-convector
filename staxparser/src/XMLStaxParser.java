import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class XMLStaxParser {



    private static boolean nameFlag;
    private static boolean charCodeFlag;
    private static boolean nominalFlag;
    private static boolean valueFlag;


    public static void StaxParser(){

        String fileName ="D:/Date.html";
        List<Valute> valuteList = parseXMLfile(fileName);

        for(Valute valute : valuteList){
            System.out.println(valute.toString());
        }
    }

    private static List<Valute> parseXMLfile(String fileName){
        List<Valute> valutesList = new ArrayList<>();
        Valute valute = null;
        XMLInputFactory factory = XMLInputFactory.newInstance();
        try {
            XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream(fileName));
            int event = reader.getEventType();
            while (true) {
                switch (event){
                    case XMLStreamConstants.START_ELEMENT:
                        if (reader.getLocalName().equals("Valute")) {
                            valute = new Valute();
                            valute.setID(reader.getAttributeValue(0));
                        } else if (reader.getLocalName().equals("Name")) {
                            nameFlag = true;
                        } else if (reader.getLocalName().equals("CharCode")) {
                            charCodeFlag = true;
                        } else if (reader.getLocalName().equals("Nominal")) {
                            nominalFlag = true;
                        }else if (reader.getLocalName().equals("Value")) {
                            valueFlag = true;
                        }
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        if (nameFlag) {
                            valute.setName(reader.getText());
                            nameFlag = false;
                        } else if (charCodeFlag) {
                            valute.setCharCode(reader.getText());
                            charCodeFlag = false;
                        } else if (nominalFlag) {
                            valute.setNominal(Integer.parseInt(reader.getText()));
                            nominalFlag = false;
                        } else if (valueFlag) {
                            String vlTemp = reader.getText();
                            vlTemp=vlTemp.replace(',','.');
                          valute.setValue(Double.parseDouble(vlTemp));
                            valueFlag = false;
                        }
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        if (reader.getLocalName().equals("Valute")) {
                            valutesList.add(valute);
                        }
                        break;
                }
                if (!reader.hasNext())
                    break;
                event = reader.next();
            }

        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
        return valutesList;
    }
}
