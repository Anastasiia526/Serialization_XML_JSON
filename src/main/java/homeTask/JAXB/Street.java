package homeTask.JAXB;

import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@ToString
@NoArgsConstructor
@XmlRootElement(name = "street")
public class Street {
    private String name;
    House house;

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "house")
    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }
}



