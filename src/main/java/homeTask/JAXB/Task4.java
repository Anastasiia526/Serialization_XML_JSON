package homeTask.JAXB;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Task4 {
    public static void main(String[] args) {
        City city = new City("big", "Kyiv");
        Street street = new Street();
        House house = new House();
        street.setHouse(house);
        city.setStreet(street);
        try {
            File file = new File("src/main/java/homeTask/JAXB/city.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(City.class);
            Marshaller mar = jaxbContext.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            mar.marshal(city, file);
            mar.marshal(city, System.out);
            Unmarshaller unmar = jaxbContext.createUnmarshaller();
            city = (City) unmar.unmarshal(file);
            System.out.println(city);


        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
