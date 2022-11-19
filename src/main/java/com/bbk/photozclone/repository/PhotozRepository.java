package com.bbk.photozclone.repository;

import com.bbk.photozclone.model.Photo;
import org.springframework.data.repository.CrudRepository;

public interface PhotozRepository extends CrudRepository<Photo, Integer> {
}
