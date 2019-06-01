package rc.web;

import com.mongodb.BasicDBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rc.domain.Hotel;
import rc.domain.User;
import rc.service.HotelService;
import java.util.List;
import org.json.JSONException;
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
    

    @GetMapping("/user/query/{key}/{param}")
    public List<User> findByDetails(@PathVariable final String key ,@PathVariable final String param){
       return userService.findByDetails(key, param);
      
    }
    
    @GetMapping("/user/all")
    public List<User> findAllUser(){
       return userService.findAll();
    }
    @GetMapping("/users")
    public void saveUsers() throws JSONException{
        User user = new User();
        BasicDBObject details = new BasicDBObject();
        details.put("dynamicField1", "dynamicValue1");
        details.put("dynamicField2", "dynamicValue2");
        user.setDetails(details);
        userService.save(user);
    }
    @PostMapping("/users")
    public void saveUserDB(@RequestBody BasicDBObject details){
        User user = new User();
        user.setDetails(details);
        userService.save(user);
    }

    @PostMapping("/user")
    public void saveUser(@RequestBody User user){
       
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
