package com.NewModsis.Controller;

import com.NewModsis.Entity.Karavan;
import com.NewModsis.Entity.Musteri;
import com.NewModsis.Entity.SatinAlim;
import com.NewModsis.Repository.KaravanRepository;
import com.NewModsis.Repository.MusteriRepository;
import com.NewModsis.Repository.SatinAlimRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class SatinAlimController {

    private final SatinAlimRepository satinAlimRepository;
    private final KaravanRepository karavanRepository;
    private final MusteriRepository musteriRepository;

    @GetMapping("/satinalim")
    public List<SatinAlim> getAllSatinAlim() {
        return satinAlimRepository.findAll();
    }

    @PostMapping("/satinalim")
    public SatinAlim createSatinAlim(@RequestBody SatinAlim satinAlim) {
        Karavan karavan = karavanRepository.findById(satinAlim.getKaravan().getId()).orElseThrow();
        Musteri musteri = musteriRepository.findById(satinAlim.getMusteri().getId()).orElseThrow();
        satinAlim.setKaravan(karavan);
        satinAlim.setMusteri(musteri);
        return satinAlimRepository.save(satinAlim);
    }

    @GetMapping("/karavan")
    public List<Karavan> getAllKaravan() {
        return karavanRepository.findAll();
    }

    @GetMapping("/musteri")
    public List<Musteri> getAllMusteri() {
        return musteriRepository.findAll();
    }
}
