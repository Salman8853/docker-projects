package com.codeadiction.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
public class Photos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @GeneratedValue(generator = "UUID")
    private UUID photoId;

    private String photoName;
    private String photoUrl;
    private String description;

}
