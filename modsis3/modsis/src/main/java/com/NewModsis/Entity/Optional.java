package com.NewModsis.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "optional")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Optional {
    @Id
    private Long id;
    private String name;
    @ElementCollection
    private List<String> comfortPackages;
    @ElementCollection
    private List<String> teknolojiPackages;
    @ElementCollection
    private List<String> beyazEsyaPackages;
    @OneToMany(mappedBy = "optional", cascade = CascadeType.ALL)
    private List<SatinAlim> satinAlim ;
}
