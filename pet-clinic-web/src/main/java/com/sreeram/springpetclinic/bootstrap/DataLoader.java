package com.sreeram.springpetclinic.bootstrap;

import com.sreeram.springpetclinic.model.Owner;
import com.sreeram.springpetclinic.model.PetType;
import com.sreeram.springpetclinic.model.Vet;
import com.sreeram.springpetclinic.services.OwnerService;
import com.sreeram.springpetclinic.services.PetTypeService;
import com.sreeram.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {


    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService ,PetTypeService  petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService=petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);


        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Sreeram");
        owner1.setLastName("Srinivasaragavan");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Rohan");
        owner2.setLastName("Sreeram");

        ownerService.save(owner2);

        System.out.println("Owners Loaded ....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Pranav");
        vet1.setLastName("Sreeram");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Nivethitha");
        vet2.setLastName("Mathan Mohan");

        vetService.save(vet2);

        System.out.println("Vets Loaded ...");




    }
}
