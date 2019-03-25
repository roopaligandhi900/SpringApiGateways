package com.stackroute.springredis;


import com.stackroute.springredis.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Map;
import java.lang.String;


@RestController
@RequestMapping("/rest/user")
@CrossOrigin
public class UserResource {

    private UserRepository userRepository;

    public UserResource(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/user")
    public ResponseEntity<String> user(){
        return new ResponseEntity<String>("user",HttpStatus.OK);
    }

    @GetMapping("/add/{id}/{name}")
    public ResponseEntity<User> add(@PathVariable("id") final String id,
                    @PathVariable("name") final String name) {
        userRepository.save(new User(id, name, 20000L));
        return new ResponseEntity<>(userRepository.findById(id),HttpStatus.OK);
    }

    @GetMapping("/update/{id}/{name}")
    public User update(@PathVariable("id") final String id,
                       @PathVariable("name") final String name) {
        userRepository.update(new User(id, name, 1000L));
        return userRepository.findById(id);
    }

    @GetMapping("/delete/{id}")
    public Map<String, User> delete(@PathVariable("id") final String id) {
        userRepository.delete(id);
        return all();
    }

    @GetMapping("/all")
    public Map<String, User> all() {
//        return userRepository.findAll();
        Map<String, User> data = userRepository.findAll();
        System.out.println("Is this Working ????");
        return data;
    }
}
