package com.workstation.Controllers;

import com.workstation.Models.Manager;
import com.workstation.Services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Šimon Hašák
 */
@RestController
@RequestMapping("/managers")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @GetMapping("/getAll")
    public List<Manager> getAll(){
        return managerService.getAll();
    }
}
