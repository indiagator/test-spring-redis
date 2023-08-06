package com.example.testspringredis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainRestController
{
    UserdetailRepository userdetailRepository;

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    MainRestController(UserdetailRepository userdetailRepository)
    {
        this.userdetailRepository = userdetailRepository;
    }

    public ResponseEntity<Userdetail> saveUser(@RequestBody Userdetail userdetail)
    {
        userdetailRepository.save(userdetail);
        return new ResponseEntity<>(userdetail, HttpStatus.OK);
    }

    @Cacheable(value = "userdetails", key = "#username")
    @RequestMapping(value = "get/user/detail/{username}", method = RequestMethod.GET)
    public Userdetail getUserdetail(@PathVariable String username)
    {
        LOG.info("Getting user with ID {}.", username);
        return userdetailRepository.findById(username).get();
    }


}
