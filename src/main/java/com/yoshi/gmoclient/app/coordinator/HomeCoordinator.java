package com.yoshi.gmoclient.app.coordinator;

import com.yoshi.gmoclient.app.exception.*;
import com.yoshi.gmoclient.domain.service.*;
import lombok.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

@Component
@Transactional
@AllArgsConstructor
public class HomeCoordinator {
    private final UserService userService;

    public String findGmoTokenBySub(String sub) {
        return userService.findBySub(sub)
                          .orElseThrow(() -> new ResourceNotFountException(sub))
                          .getGmoToken();
    }
}
