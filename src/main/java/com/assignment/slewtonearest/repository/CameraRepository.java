package com.assignment.slewtonearest.repository;

import com.assignment.slewtonearest.document.Camera;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CameraRepository extends MongoRepository<Camera, String> {
}
