package com.hospital.pharmacy.service;

import com.hospital.pharmacy.model.User;
import com.hospital.pharmacy.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DataInitializationServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private DataInitializationService dataInitializationService;

    @Test
    void initData_shouldCreateAdminWithRoleAssigned() {
        when(userRepository.count()).thenReturn(0L);
        ReflectionTestUtils.setField(dataInitializationService, "userRepository", userRepository);

        dataInitializationService.initData();

        ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);
        verify(userRepository, times(4)).save(userCaptor.capture());
        assertEquals("ADMIN", userCaptor.getAllValues().get(0).getRole());
    }
}
