package com.example.readwrite.service.impl;

import com.example.readwrite.mapper.UserMapper;
import com.example.readwrite.model.User;
import com.example.readwrite.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Override
    @Transactional // 기본값 (readOnly = false) -> Write DB(Master) 사용
    public void registerUser(User user) {
        userMapper.insert(user);
    }

    @Override
    @Transactional // Write DB(Master) 사용
    public void modifyUser(User user) {
        userMapper.update(user);
    }

    @Override
    @Transactional // Write DB(Master) 사용
    public void removeUser(Long id) {
        userMapper.delete(id);
    }

    @Override
    @Transactional(readOnly = true) // Read DB(Slave) 사용
    public User getUserById(Long id) {
        return userMapper.findById(id)
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다. ID: " + id));
    }

    @Override
    @Transactional(readOnly = true) // Read DB(Slave) 사용
    public List<User> getAllUsers() {
        return userMapper.findAll();
    }
}
