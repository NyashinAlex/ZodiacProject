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
@Table(name = "compatibility", schema = "zodiac")
public class Compatibility {

    @Id
    @Column(name = "id_man_zodiac")
    private int idManZodiac;

    @Column(name = "id_woman_zodiac")
    private int idWomanZodiac;

    @Column(name = "compatibility")
    private String compatibility;

}
