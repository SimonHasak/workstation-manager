package com.workstation.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * @author Šimon Hašák
 */

@Entity
@Table(name = "computer")
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 100)
    private String ipAddress;
    @NotNull
    @Size(max = 100)
    private String hostName;
    @NotNull
    @Size(max = 100)
    private String macAddress;

    @OneToOne
    private Socket socket;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "computer_managers", joinColumns = {@JoinColumn(name = "computer_id")},
            inverseJoinColumns = {@JoinColumn(name = "managers_id")})
    @JsonIgnore
    private Set<Manager> managers;

    public Computer(){}

    public Computer(String ipAddress, String hostName, String macAddress, Socket socket, Set<Manager> managers) {
        this.ipAddress = ipAddress;
        this.hostName = hostName;
        this.macAddress = macAddress;
        this.socket = socket;
        this.managers = managers;
    }

    @Override
    public String toString() {
        return String.format("Computer{ id= {}, ipAddress= {}, " +
                        "hostName= {}, macAddress= {}, socket= {}, managers= {}",
                         id, ipAddress, hostName, macAddress, socket, managers);
    }

    public Long getId() {
        return id;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getHostName() {
        return hostName;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public Socket getSocket() {
        return socket;
    }

    public Set<Manager> getManagers() {
        return managers;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public void setManagers(Set<Manager> managers) {
        this.managers = managers;
    }
}
