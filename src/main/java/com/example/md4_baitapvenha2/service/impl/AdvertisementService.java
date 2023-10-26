package com.example.md4_baitapvenha2.service.impl;

import com.example.md4_baitapvenha2.model.Advertisement;
import com.example.md4_baitapvenha2.repository.IAdvertisementRepository;
import com.example.md4_baitapvenha2.service.IAdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AdvertisementService implements IAdvertisementService {
    @Autowired
    IAdvertisementRepository advertisementRepository;

    @Override
    public Iterable<Advertisement> findAll() {
        return advertisementRepository.findAll();
    }

    @Override
    public Optional<Advertisement> findById(Long id) {
        return advertisementRepository.findById(id);
    }

    @Override
    public Advertisement save(Advertisement advertisement) {
        return advertisementRepository.save(advertisement);
    }

    @Override
    public void delete(Long id) {
        advertisementRepository.deleteById(id);
    }
}
