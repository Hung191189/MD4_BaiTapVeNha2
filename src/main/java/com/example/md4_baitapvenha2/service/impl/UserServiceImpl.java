package com.example.md4_baitapvenha2.service.impl;
import com.example.md4_baitapvenha2.model.User;
import com.example.md4_baitapvenha2.repository.IUserRepository;
import com.example.md4_baitapvenha2.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Optional;
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserRepository userRepository;


    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User user) {
       return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
