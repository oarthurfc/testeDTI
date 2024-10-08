package com.oarthurfc.PetShopDTI.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import com.oarthurfc.PetShopDTI.models.PetShop;
import com.oarthurfc.PetShopDTI.pricing.TipoAdicional;
import com.oarthurfc.PetShopDTI.repositories.PetShopRepository;

import jakarta.annotation.PostConstruct;

@Configuration
public class DataInitializer {

    @Autowired
    private PetShopRepository petShopRepository;

    @PostConstruct
    @Transactional
    public void init() {
        if (petShopRepository.count() == 0) {
            PetShop caninoFeliz = new PetShop(
                "Meu Canino Feliz",
                2.0,
                20.0, 
                40.0, 
                TipoAdicional.PERCENTUAL,
                0.2
            );

            PetShop vaiRex = new PetShop(
                "Vai Rex",
                1.7,
                15.0, 
                50.0, 
                TipoAdicional.FIXO,
                5.0 
            );

            PetShop chowChawgas = new PetShop(
                "ChowChawgas",
                0.8,
                30.0,  
                45.0,  
                TipoAdicional.FIXO,
                0.0 
            );

            petShopRepository.save(caninoFeliz);
            petShopRepository.save(vaiRex);
            petShopRepository.save(chowChawgas);
        }
    }
}
