package com.tutorial.usermicroservice.service;

import com.tutorial.usermicroservice.entity.User1;
import com.tutorial.usermicroservice.models.Bike;
import com.tutorial.usermicroservice.models.Car;
import com.tutorial.usermicroservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RestTemplate restTemplate;
    public List<User1> getAll() {
        return userRepository.findAll();
    }


    public User1 getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public User1 save(User1 user) {
        User1 userNew = userRepository.save(user);
        return userNew;
    }

   public  List<Car> getCard(int id){
        List<Car> cars =restTemplate.getForObject("http://localhost:8002/car/byuser/" + id,List.class);
         return cars;
   }


    public  List<Bike> getBike(int id){
        List<Bike> bikes =restTemplate.getForObject("http://localhost:8002/bike/byuser/" + id,List.class);
        return bikes;
    }


}
