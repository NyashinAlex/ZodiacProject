package ru.nyashinqa.db;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "zodiac_sing", schema = "zodiac")
public class ZodiacSing {

    @Id
    @Column(name = "id")
    private int idManZodiac;

    @Column(name = "name_zodiac")
    private String nameZodiac;

    @Column(name = "name_zodiac_ru")
    private String nameZodiacRu;

}
