package com.workstation.Services;

import com.workstation.Models.Computer;

import java.util.List;

/**
 * @author Šimon Hašák
 */
public interface ComputerService {

    /**
     * Get all computers in management manager
     * @param id, id of manager
     * @return List of all computers in management manager
     */
    List<Computer> getAllManagerComputers(Long id);

    /**
     * Get room where the computer with ipAddress is.
     * @param ipAddress, ipAddress of computer
     * @return room
     */
    String getRoomByIpAddress(String ipAddress);

    /**
     * Get all pc stations in the room.
     * @param room, name of the room
     * @return List of all hostNames of computers in the room.
     */
    List<String> getAllStationsInTheRoom(String room);

}
