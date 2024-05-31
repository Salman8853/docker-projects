package com.codeadiction.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String albumName;
    private String description;

    @OneToMany
    @JoinColumn(name = "album_id",referencedColumnName = "id")
    private Set<Photos> photosSet;
}
