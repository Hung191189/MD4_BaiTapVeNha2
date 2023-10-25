package com.example.md4_baitapvenha2.service.impl;
import com.example.md4_baitapvenha2.model.Category;
import com.example.md4_baitapvenha2.repository.ICategoryRepository;
import com.example.md4_baitapvenha2.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class CategoryService implements ICategoryService {
    @Autowired
    ICategoryRepository categoryRepository;


    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category save(Category category) {
       return categoryRepository.save(category);
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
