package com.NewModsis.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "karavan")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Karavan {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "karavan",cascade = CascadeType.ALL)
    private List<SatinAlim> satinAlim;
}