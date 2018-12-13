package com.sreeram.springpetclinic.services.map;

import com.sreeram.springpetclinic.model.Speciality;
import com.sreeram.springpetclinic.model.Vet;
import com.sreeram.springpetclinic.services.SpecialtyService;
import com.sreeram.springpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default","map"})
public class VetServiceMap extends AbstractMapService<Vet,Long> implements VetService {

    private final SpecialtyService specialtyService;

    public VetServiceMap(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        if(object.getSpecialities().size() >0){
            object.getSpecialities().forEach(speciality -> {
                if(speciality.getId() == null){

                    Speciality savedSpeciality = specialtyService.save(speciality);
                    speciality.setId(savedSpeciality.getId());

                }
            });
        }
        return super.save(object);
    }

    @Override
    public void delete(Vet object) {
             super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
            super.deleteById(id);
    }
}
