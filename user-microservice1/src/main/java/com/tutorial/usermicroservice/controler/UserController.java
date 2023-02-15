package com.tutorial.usermicroservice.controler;


import com.tutorial.usermicroservice.entity.User1;
import com.tutorial.usermicroservice.models.Car;
import com.tutorial.usermicroservice.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<User1>> getAll() {
        List<User1> users = userService.getAll();
        if(users.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User1> getById(@PathVariable("id") int id) {
        User1 user = userService.getUserById(id);
        if(user == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(user);
    }

    @PostMapping()
    public ResponseEntity<User1> save(@RequestBody User1 user) {
        User1 userNew = userService.save(user);
        return ResponseEntity.ok(userNew);
    }

    @GetMapping("/cars/{userId}")
    public  ResponseEntity<List<Car>> getCars(@PathVariable("userId") int userId){
     User1 user =userService.getUserById(userId);
     if(user==null){
         return  ResponseEntity.notFound().build();
     }

     List<Car> cars =userService.getCard(userId);
     return ResponseEntity.ok(cars);
    }

}
