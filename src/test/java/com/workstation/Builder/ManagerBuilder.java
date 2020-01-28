package com.workstation.Builder;

import com.workstation.Models.Computer;
import com.workstation.Models.Manager;

import java.util.Set;

/**
 * @author Šimon Hašák
 */
public class ManagerBuilder {

    private Long id;
    private String name;
    private Set<Computer> computers;

    public ManagerBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public ManagerBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ManagerBuilder setComputers(Set<Computer> computers) {
        this.computers = computers;
        return this;
    }

    public Manager build() {
        Manager manager = new Manager();
        manager.setId(id);
        manager.setName(name);
        manager.setComputers(computers);
        return manager;
    }

}
