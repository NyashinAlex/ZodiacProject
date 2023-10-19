package ru.nyashinqa.db;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "users", schema = "zodiac")
public class Coffe {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "id_name_zodiac")
    private int idNameZodiac;

    @Column(name = "coffe")
    private String coffe;

    @Column(name = "desc")
    private String desc;

}
