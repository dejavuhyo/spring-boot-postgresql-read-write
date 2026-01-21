package com.example.readwrite.mapper;

import com.example.readwrite.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {
    // Write (Master)
    void insert(User user);
    void update(User user);
    void delete(Long id);

    // Read (Slave)
    Optional<User> findById(Long id);
    List<User> findAll();
}
