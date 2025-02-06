package com.tutech.backend.repository;

import com.tutech.backend.dto.TestEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TestRepo extends MongoRepository<TestEntity, String> {
}
