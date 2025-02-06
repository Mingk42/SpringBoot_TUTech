package com.tutech.backend.service;

import com.tutech.backend.dto.TestEntity;
import com.tutech.backend.repository.TestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    private final TestRepo testRepo;

    @Autowired
    public TestServiceImpl(TestRepo testRepo) {
        this.testRepo = testRepo;
    }

    @Override
    public TestEntity createTest(TestEntity testEntity) {
        return testRepo.save(testEntity);
    }

    @Override
    public List<TestEntity> getAllTests() {
        System.out.println(testRepo.findAll().size());
        return testRepo.findAll();
    }

    @Override
    public TestEntity getTestById(String id) {
        return testRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteTestById(String id) {
        testRepo.deleteById(id);
    }
}
