package com.codeadiction.repository;

import com.codeadiction.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album,Long> {
}
