package com.workstation.Repositories;

import com.workstation.Models.Computer;
import com.workstation.Models.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Šimon Hašák
 */
@Repository
public interface ComputerRepository extends JpaRepository<Computer, Long> {

    List<Computer> findAllByManagers_Id(Long id);

    Computer findComputerByIpAddress(String ipAddress);

    List<Computer> findComputersBySocket_Room(String room);

}
