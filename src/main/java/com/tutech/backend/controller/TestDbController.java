package com.tutech.backend.controller;

import com.tutech.backend.dto.TestEntity;
import com.tutech.backend.service.SearchService;
import com.tutech.backend.service.SearchServiceImpl;
import com.tutech.backend.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/testentity")
public class TestDbController {
    private final TestService testService;
    private final SearchServiceImpl searchServiceImpl;

    @Autowired
    public TestDbController(TestService testService, SearchService searchService, SearchServiceImpl searchServiceImpl) {
        this.testService = testService;
        this.searchServiceImpl = searchServiceImpl;
    }

    @PostMapping
    public TestEntity createTestEntity(@RequestBody TestEntity testEntity) {
        System.out.printf("TestEntity created: %s\n", testEntity);

        return testService.createTest(testEntity);
    }

    @GetMapping
    public List<TestEntity> getAllTests() {

        //System.out.println(searchServiceImpl.getAllSearchEntities());

        return testService.getAllTests();
    }

    @GetMapping("/{id}")
    public TestEntity getTestEntity(@PathVariable String id) {
        return testService.getTestById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTestEntity(@PathVariable String id) {
        testService.deleteTestById(id);
    }
}
