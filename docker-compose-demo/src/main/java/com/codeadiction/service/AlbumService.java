package com.codeadiction.service;

import com.codeadiction.entity.Album;
import com.codeadiction.entity.Photos;
import com.codeadiction.model.PhotoRequest;
import com.codeadiction.repository.AlbumRepository;
import com.codeadiction.repository.PhotosRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AlbumService {

    private final  AlbumRepository albumRepository;
    private final PhotosRepository photosRepository;

    public AlbumService(AlbumRepository albumRepository, PhotosRepository photosRepository) {
        this.albumRepository = albumRepository;
        this.photosRepository = photosRepository;
    }


    public Album savePhotos(PhotoRequest photoRequest){

        Album album=new Album();
        album.setAlbumName("Public Album");
        album.setDescription("Album for public ...!!");
        Photos photos= new Photos();
        photos.setPhotoName(photoRequest.getPhotoName());
        photos.setPhotoUrl(photoRequest.getPhotoUrl());
        photos.setDescription(photoRequest.getDescription());
        Photos photos1=photosRepository.save(photos);
        album.setPhotosSet(Set.of(photos1));
        albumRepository.save(album);
        return album;

    }
}
