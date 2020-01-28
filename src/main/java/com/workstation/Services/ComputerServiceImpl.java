package com.workstation.Services;

import com.workstation.Models.Computer;
import com.workstation.Repositories.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Šimon Hašák
 */
@Service
public class ComputerServiceImpl implements ComputerService{

    @Autowired
    private ComputerRepository computerRepository;

    @Override
    public List<Computer> getAllManagerComputers(Long id) {
        return computerRepository.findAllByManagers_Id(id);
    }

    @Override
    public String getRoomByIpAddress(String ipAddress){
        return computerRepository.findComputerByIpAddress(ipAddress).getSocket().getRoom();
    }

    @Override
    public List<String> getAllStationsInTheRoom(String room){
        return computerRepository.findComputersBySocket_Room(room).stream().map(c -> c.getHostName()).collect(Collectors.toList());
    }

}
