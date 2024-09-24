package com.siteshkumar.em_project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.siteshkumar.em_project.Model.EmpEntity;

public interface EmpRepository extends JpaRepository<EmpEntity, Long>{
    // You can make custom method here.
    // Otherwise no need to write anything here.
    // Like: findbyName(), findbyAge() anything else you can make it from here.
}
