package rc.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import rc.domain.Hotel;
import java.util.List;
import java.util.Optional;

@Repository
public interface HotelRepository extends MongoRepository<Hotel,String> {
    Optional<Hotel> findById(String id);
    List<Hotel> findByPricePerNightLessThan(int maxPrice);
}
