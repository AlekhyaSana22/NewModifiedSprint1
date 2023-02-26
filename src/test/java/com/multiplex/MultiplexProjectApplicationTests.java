package com.multiplex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

 

import com.multiplex.entities.User;
import com.multiplex.repository.UserRepository;

 

@SpringBootTest
class MultiplexProjectApplicationTests {

 

     @Autowired
        private UserRepository userRespository;
        }