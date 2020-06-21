package com.yoshi.gmoclient.domain.service;

import com.yoshi.gmoclient.domain.entity.*;
import com.yoshi.gmoclient.domain.repository.*;
import lombok.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.util.*;

@Service
@Transactional
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Optional<User> find(long id) {
        return userRepository.find(id);
    }

    public int create(User user) {
        return userRepository.create(user);
    }
}
