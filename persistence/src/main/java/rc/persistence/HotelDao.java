package rc.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rc.domain.Hotel;
import java.util.List;

@Repository
public class HotelDao {

    @Autowired
    HotelRepository hotelRepository;

    public void insert(Hotel hotel){
        hotelRepository.insert(hotel);
    }

    public void save(Hotel hotel){
        hotelRepository.save(hotel);
    }

    public Hotel findById(String id) {
        return hotelRepository.findById(id).get();
    }

    public List<Hotel> findByPricePerNightLessThan(int maxPrice) {
        return hotelRepository.findByPricePerNightLessThan(maxPrice);
    }

    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }


}
