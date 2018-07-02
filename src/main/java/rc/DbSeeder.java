package rc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {

    private HotelRepository hotelRepository;

    @Autowired //CHANGE
    public DbSeeder(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        Hotel marriot = new Hotel(
                "Marriot",
                100,
                new Address("Seoul", "South Korea"),
                Arrays.asList(
                        new Review("John", 8, false),
                        new Review("Mary", 7, true)
                )
        );

        Hotel hilton = new Hotel(
                "Hilton",
                200,
                new Address("San Francisco", "USA"),
                Arrays.asList(
                        new Review("Tim", 7, false),
                        new Review("Clara", 6, true)
                )
        );

        Hotel holidayInn = new Hotel(
                "Minjoo's",
                300,
                new Address("Los Angeles", "USA"),
                Arrays.asList(
                        new Review("Tim", 10, true),
                        new Review("Clara", 10, true)
                )
        );

        //drop all hotels
        this.hotelRepository.deleteAll();

        //add our hotels to the database
        List<Hotel> hotels = Arrays.asList(marriot, hilton, holidayInn);
        this.hotelRepository.saveAll(hotels);

    }

}
