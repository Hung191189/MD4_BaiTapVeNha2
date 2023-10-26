package com.example.md4_baitapvenha2.controller;
import com.example.md4_baitapvenha2.model.Advertisement;
import com.example.md4_baitapvenha2.service.IAdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin("*")
@RequestMapping("/Advertisements")
public class AdvertisementController {
    @Autowired
    IAdvertisementService advertisementService;

    @GetMapping
    public ResponseEntity<Iterable<Advertisement>> showAll(){
        List<Advertisement> advertisementList = (List<Advertisement>) advertisementService.findAll();
        if (advertisementList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(advertisementList, HttpStatus.ACCEPTED);
    }
    @PostMapping
    public ResponseEntity<Advertisement> saveBlog(@RequestBody Advertisement advertisement){
        advertisementService.save(advertisement);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Advertisement> updateBlog(@PathVariable Long id, @RequestBody Advertisement advertisement){
        Optional<Advertisement> advertisementOptional = advertisementService.findById(id);
        if(!advertisementOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        advertisement.setIdAdvertisement(advertisementOptional.get().getIdAdvertisement());
        advertisementService.save(advertisement);
        return new ResponseEntity<>(advertisement, HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Advertisement> deleteBlog(@PathVariable Long id){
        advertisementService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
