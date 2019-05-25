package rc.web;

import com.fasterxml.jackson.core.JsonParser;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rc.domain.Hotel;
import rc.domain.User;
import rc.service.HotelService;
import java.util.List;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import rc.service.UserService;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    HotelService hotelService;
    @Autowired
    UserService userService;
    
    
    @GetMapping("/user/name/{name}")
    public List<User> findByDetailsNameQuery(@PathVariable String name){
       return userService.findByDetailsNameQuery(name);
    }
    

    @GetMapping("/user/query/{key}/{name}")
    public List<User> findByDetails(@PathVariable String key ,@PathVariable String name){
       return userService.findByDetails(key, name);
      
    }
    
    @GetMapping("/user/all")
    public List<User> findAllUser(){
       return userService.findAll();
    }

    @PostMapping("/user")
    public void saveUser(@RequestBody User user){
        //user.setDetails((JSONObject) JSON.parse(userObj));
        userService.save(user);
    }

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
