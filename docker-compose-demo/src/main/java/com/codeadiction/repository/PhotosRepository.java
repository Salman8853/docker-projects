package com.codeadiction.repository;

import com.codeadiction.entity.Photos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotosRepository extends JpaRepository<Photos,Long> {
}
