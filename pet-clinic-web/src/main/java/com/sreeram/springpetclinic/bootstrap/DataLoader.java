package com.sreeram.springpetclinic.bootstrap;

import com.sreeram.springpetclinic.model.Owner;
import com.sreeram.springpetclinic.model.Vet;
import com.sreeram.springpetclinic.services.OwnerService;
import com.sreeram.springpetclinic.services.VetService;
import com.sreeram.springpetclinic.services.map.OwnerServiceMap;
import com.sreeram.springpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {

        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();

    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Sreeram");
        owner1.setLastName("Srinivasaragavan");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner1.setFirstName("Rohan");
        owner1.setLastName("Sreeram");

        ownerService.save(owner2);

        System.out.println("Owners Loaded ....");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Pranav");
        vet1.setLastName("Sreeram");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Nivethitha");
        vet2.setLastName("Mathan Mohan");

        vetService.save(vet2);

        System.out.println("Vets Loaded ...");




    }
}
