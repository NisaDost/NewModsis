package com.NewModsis.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "satinAlim")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SatinAlim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String adres;
    private String il;
    private String ilce;
    private String mahalle;
    private int posta_kodu;

    @Column(name = "satinalim_Date")
    private LocalDate satinAlimDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "musteri_ID", referencedColumnName = "id")
    private Musteri musteri;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "karavan_ID", referencedColumnName = "id")
    private Karavan karavan;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "optional_ID", referencedColumnName = "id")
    private Optional optional;
}
