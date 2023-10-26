package com.example.md4_baitapvenha2.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Advertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAdvertisement;
    private String content;
    @ManyToMany(mappedBy = "advertisementSet")
    @JsonIgnore
    private Set<Blog> blogSet = new HashSet<>();
}
