package rc;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "Hotels")
public class Hotel {
    //variables
    @Id //always with primary key(class)'s id
    private String id;
    private String name;
    @Indexed(direction = IndexDirection.ASCENDING)  //index the next line's property
    private int pricePerNight;
    private Address address;
    private List<Review> reviews;

    //constructor
    public Hotel(String name, int pricePerNight, Address address, List<Review> reviews){
        this.name = name;
        this.pricePerNight = pricePerNight;
        this.address = address;
        this.reviews = reviews;
    }

    public String getId(){ return id; }

    public String getName() { return name; }

    public int getPricePerNight() { return pricePerNight; }

    public Address getAddress() {return address;}

    public List<Review> getReviews() {return reviews;}

}
