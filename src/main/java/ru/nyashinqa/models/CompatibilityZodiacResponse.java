package ru.nyashinqa.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CompatibilityZodiacResponse {

    private String zodiacMan;
    private String zodiacWomen;
    private String compatibility;
}
