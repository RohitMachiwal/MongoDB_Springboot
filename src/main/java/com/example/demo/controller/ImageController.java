package com.example.demo.controller;

import com.example.demo.model.ProfileImage;
import com.example.demo.repository.ImageRepo;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class ImageController {

    @Autowired
    private ImageRepo imageRepo;

     @PostMapping("/image")
     public ProfileImage imageUpload(@RequestParam("image")MultipartFile file) throws IOException {

         ProfileImage profileImage = new ProfileImage();

         profileImage.setImage(new Binary(BsonBinarySubType.BINARY, file.getBytes()));

         return  imageRepo.insert(profileImage);

     }

}
