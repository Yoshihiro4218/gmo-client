package com.yoshi.gmoclient.domain.repository;

import com.yoshi.gmoclient.domain.entity.*;
import org.apache.ibatis.annotations.*;

import java.util.*;

@Mapper
public interface UserRepository {
    Optional<User> find(long id);

    int create(User user);
}
