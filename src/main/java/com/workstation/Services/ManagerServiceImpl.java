package com.workstation.Services;

import com.workstation.Models.Manager;
import com.workstation.Repositories.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Šimon Hašák
 */
@Service
public class ManagerServiceImpl implements ManagerService{

    @Autowired
    private ManagerRepository managerRepository;

    @Override
    public List<Manager> getAll(){
        return managerRepository.findAll();
    }
}
