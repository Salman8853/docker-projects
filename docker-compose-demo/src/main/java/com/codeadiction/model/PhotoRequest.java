package com.codeadiction.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Data
public class PhotoRequest {

    private String photoName;
    private String photoUrl;
    private String description;
}
