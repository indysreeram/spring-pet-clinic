package com.sreeram.springpetclinic.services.map;

import com.sreeram.springpetclinic.model.Visit;
import com.sreeram.springpetclinic.services.VisitService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VisitServiceMap extends AbstractMapService<Visit,Long> implements VisitService {



    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Visit save(Visit visit) {



        if (visit.getPet() == null  || visit.getPet().getOwner() == null) {
            throw new RuntimeException("Invalid Visit Object!!!!");
        } else {
            return super.save(visit);
        }


    }

    @Override
    public void delete(Visit object) {
        super.delete(object);

    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }
}
