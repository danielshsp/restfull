package rc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rc.domain.Hotel;
import rc.service.HotelService;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    HotelService hotelService;

    @PutMapping("/update/{id}")
    public void update(@PathVariable final String id ,@RequestBody Hotel hotel){
        hotel.setId(id);
        hotelService.save(hotel);
    }

    @PostMapping
    public void insert(@RequestBody Hotel hotel){
        hotelService.save(hotel);
    }

    @GetMapping("/all")
    public List<Hotel> findAll(){
        return hotelService.findAll();
    }
    @GetMapping("/{id}")
    public Hotel findById(@PathVariable final String id){
        return hotelService.findById(id);
    }

    @GetMapping("/price/{maxPrice}")
    public List<Hotel> getByPricePerNight(@PathVariable("maxPrice") int maxPrice){
        return hotelService.findByPricePerNightLessThan(maxPrice);

    }


}
