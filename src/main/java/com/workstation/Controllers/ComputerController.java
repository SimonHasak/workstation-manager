package com.workstation.Controllers;

import com.workstation.Models.Computer;
import com.workstation.Services.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Šimon Hašák
 */
@RestController
@RequestMapping("/computers")
public class ComputerController {

    @Autowired
    private ComputerService computerService;

    @GetMapping("/getAllManagerComputers/{id}")
    public List<Computer> getAllManagerComputers(@PathVariable Long id) {
        return computerService.getAllManagerComputers(id);
    }

    @GetMapping("/getRoomByIpAddress/{ipAddress}")
    public String getRoomByIpAddress(@PathVariable String ipAddress){
        return computerService.getRoomByIpAddress(ipAddress);
    }

    @GetMapping("getAllStationsInTheRoom/{room}")
    public List<String> getAllStationsInTheRoom(@PathVariable String room){
        return computerService.getAllStationsInTheRoom(room);
    }

}
