package com.sreeram.springpetclinic.repositories;

import com.sreeram.springpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet,Long> {
}
