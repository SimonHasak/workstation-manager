package com.workstation.Models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Šimon Hašák
 */
@Entity
@Table(name = "managers")
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 50)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "managers")
    private Set<Computer> computers;

    public Manager(String name, Set<Computer> computers) {
        this.name = name;
        this.computers = computers;
    }

    public Manager() { }

    @Override
    public String toString() {
        return String.format("Manager{ id= {}, name= {}, computers= {}", id, name, computers);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Computer> getComputers() {
        return computers;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setComputers(Set<Computer> computers) {
        this.computers = computers;
    }
}
