package com.sreeram.springpetclinic.services;

import com.sreeram.springpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner,Long> {

    Owner findByLastName(String lastName);



}
