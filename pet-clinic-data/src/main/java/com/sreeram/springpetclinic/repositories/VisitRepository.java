package com.sreeram.springpetclinic.repositories;

import com.sreeram.springpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit,Long> {
}
