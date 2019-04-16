package rc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rc.domain.Hotel;
import rc.persistence.HotelDao;
import java.util.List;

@Service
public class HotelService {

    @Autowired
    HotelDao hotelDao;

    public void insert(Hotel hotel){
        hotelDao.insert(hotel);
    }

    public void save(Hotel hotel){
        hotelDao.save(hotel);
    }

    public Hotel findById(String id){

        return hotelDao.findById(id);

    }
    public List<Hotel> findByPricePerNightLessThan(int maxPrice) {
        return hotelDao.findByPricePerNightLessThan(maxPrice);
    }

    public List<Hotel> findAll() {
        return hotelDao.findAll();
    }

}
