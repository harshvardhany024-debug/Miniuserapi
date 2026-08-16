package in.codeneeti.Miniuserapi.controller;

import in.codeneeti.Miniuserapi.entity.User;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import in.codeneeti.Miniuserapi.service.Userservice;

import java.util.List;

@RestController
@RequestMapping("/user")
public class Usercontroller {
    // making refrence
    private final Userservice userservice;

    // making constructer
    public Usercontroller (Userservice userservice){
        this.userservice=userservice;

    }
@PostMapping
    public ResponseEntity<User> creatUser(@Valid @RequestBody User user){
         User Savedu=userservice.creatUser(user);
         return ResponseEntity.status(201 ).body(Savedu);
}

@GetMapping
    public List<User>  Get(){
        return userservice.Getalluser();

}
@GetMapping("/{id}")
    public ResponseEntity<User> Getbyid(@PathVariable Integer id){
 User user = userservice.Getbyid(id);
 return ResponseEntity.ok(user);

}
@DeleteMapping("/{id}")
    public ResponseEntity<Void> Deletebyid(@PathVariable  Integer id){
        userservice.Deletebyid(id);
        return ResponseEntity.noContent().build();
    }

    // update the user info
    @PutMapping("/{id}")
    public User Updatebyid(@PathVariable  Integer id,@RequestBody User user){
        return  userservice.Updatebyid(id,user);
    }


}
