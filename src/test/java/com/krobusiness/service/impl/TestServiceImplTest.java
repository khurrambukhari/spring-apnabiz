package com.krobusiness.service.impl;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.krobusiness.model.repostiory.TestRepository;
import com.krobusiness.service.TestService;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class TestServiceImplTest {
    private final TestRepository mockTestRepository = Mockito.mock(TestRepository.class);
    private final TestService mockTestService = Mockito.mock(TestService.class);

    @Test
    void save_test_results_should_work() {
        com.krobusiness.model.entities.Test test = new com.krobusiness.model.entities.Test();
        when(mockTestRepository.save(Mockito.any(com.krobusiness.model.entities.Test.class)))
                .thenAnswer(i -> i.getArguments()[0]);
        mockTestService.saveTestResults(test);

        assertNotNull(mockTestRepository.findById(1L));
    }
}