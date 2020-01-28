package com.workstation.Services;

import com.workstation.Models.Manager;

import java.util.List;

/**
 * @author Šimon Hašák
 */
public interface ManagerService {

    /**
     * Get all managers.
     * @return List of managers
     */
    List<Manager> getAll();
}
