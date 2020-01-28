package com.workstation.Repositories;

import com.workstation.Models.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Šimon Hašák
 */
@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long>{

}
