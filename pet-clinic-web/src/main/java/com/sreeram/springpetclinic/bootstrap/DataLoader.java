package com.sreeram.springpetclinic.bootstrap;

import com.sreeram.springpetclinic.model.*;
import com.sreeram.springpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {


    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;



    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialtyService specialtyService , VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService=petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        if(petTypeService.findAll().size() == 0){
            loadData();
        }


    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);


        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialtyService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");

        Speciality savedSurgery = specialtyService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");

        Speciality savedDentistry = specialtyService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Sreeram");
        owner1.setLastName("Srinivasaragavan");
        owner1.setAddress("125 s west st");
        owner1.setCity("Wilmington");
        owner1.setTelephone("3022002525");

        Pet sreesPet = new Pet();
        sreesPet.setPetType(savedDogType);
        sreesPet.setBirthDate(LocalDate.now());
        sreesPet.setName("Spot");
        sreesPet.setOwner(owner1);
        owner1.getPets().add(sreesPet);

        ownerService.save(owner1);

/*        Visit dogVisit = new Visit();
        dogVisit.setPet(sreesPet);
        dogVisit.setDate(LocalDate.now());
        dogVisit.setDescription("Sneezy Dog!!!");

        visitService.save(dogVisit);*/

        Owner owner2 = new Owner();
        owner2.setFirstName("Rohan");
        owner2.setLastName("Sreeram");
        owner2.setAddress("125 s west st");
        owner2.setCity("Wilmington");
        owner2.setTelephone("3022002525");

        Pet rohansPet = new Pet();
        rohansPet.setOwner(owner2);
        rohansPet.setName("mowy");
        rohansPet.setBirthDate(LocalDate.now());
        rohansPet.setPetType(savedCatType);
        owner2.getPets().add(rohansPet);

        ownerService.save(owner2);
/*
        Visit catVisit = new Visit();
        catVisit.setPet(rohansPet);
        catVisit.setDescription("Sneezy Cat");
        catVisit.setDate(LocalDate.now());
        visitService.save(catVisit);*/

        System.out.println("Owners Loaded ....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Pranav");
        vet1.setLastName("Sreeram");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Nivethitha");
        vet2.setLastName("Mathan Mohan");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Vets Loaded ...");
    }
}
