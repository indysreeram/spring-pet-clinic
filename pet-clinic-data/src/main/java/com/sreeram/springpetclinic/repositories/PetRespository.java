package com.sreeram.springpetclinic.repositories;

import com.sreeram.springpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRespository extends CrudRepository<Pet,Long> {
}
