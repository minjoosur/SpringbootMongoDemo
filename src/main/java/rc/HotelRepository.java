package rc;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HotelRepository extends MongoRepository<Hotel, String>, QuerydslPredicateExecutor<Hotel> {

    Optional<Hotel> findById(String id);
    List<Hotel> findByPricePerNightLessThan(int maxPrice);

    @Query(value="{'address.city':?0}")
    public List<Hotel> findByCity(String city);
}
