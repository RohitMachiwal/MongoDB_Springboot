package com.example.demo.repository;

import com.example.demo.model.ProfileImage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepo extends MongoRepository<ProfileImage,String> {

}
