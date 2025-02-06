package com.tutech.backend.service;

import com.tutech.backend.dto.TestEntity;

import java.util.List;

public interface TestService {
    TestEntity createTest(TestEntity testEntity);
    List<TestEntity> getAllTests();
    TestEntity getTestById(String id);
    void deleteTestById(String id);
}
