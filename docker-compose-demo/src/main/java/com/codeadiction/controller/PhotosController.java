package com.codeadiction.controller;

import com.codeadiction.entity.Album;
import com.codeadiction.model.PhotoRequest;
import com.codeadiction.service.AlbumService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("photos")
public class PhotosController {

    private final AlbumService albumService;

    public PhotosController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @PostMapping
    public ResponseEntity<Album>savePhoto(@RequestBody PhotoRequest photoRequest){

        return new ResponseEntity<>(albumService.savePhotos(photoRequest), HttpStatus.CREATED);

    }
    @GetMapping
    public String getHealth(){
        return "Application is up ..!!";
    }
}
