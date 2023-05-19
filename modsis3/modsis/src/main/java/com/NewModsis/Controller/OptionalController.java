package com.NewModsis.Controller;


import com.NewModsis.Service.Impl.OptionalService;
import com.NewModsis.Entity.Optional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OptionalController {
    private final OptionalService optionalService;

    public OptionalController(OptionalService optionalService) {
        this.optionalService = optionalService;
    }

    @PostMapping("/optionals/{optionalId}/comfort-packages")
    public Optional addComfortPackageToOptional(@PathVariable Long optionalId, @RequestBody String comfortPackageName) {
        return optionalService.addComfortPackageToOptional(optionalId, comfortPackageName);
    }
    @PostMapping("/optionals/{optionalId}/teknoloji-packages")
    public Optional addTeknolojiPackageToOptional(@PathVariable Long optionalId, @RequestBody String teknolojiPackageName) {
        return optionalService.addTeknolojiPackageToOptional(optionalId, teknolojiPackageName);
    }
    @PostMapping("/optionals/{optionalId}/beyazEsya-packages")
    public Optional addBeyazEsyaPackageToOptional(@PathVariable Long optionalId, @RequestBody String beyazEsyaPackageName) {
        return optionalService.addBeyazEsyaPackageToOptional(optionalId, beyazEsyaPackageName);
    }
}