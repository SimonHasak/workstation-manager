package com.workstation.Builder;

import com.workstation.Models.Computer;
import com.workstation.Models.Manager;
import com.workstation.Models.Socket;

import java.util.Set;

/**
 * @author Šimon Hašák
 */
public class ComputerBuilder {

    private Long id;
    private String ipAddress;
    private String hostName;
    private String macAddress;
    private Socket socket;
    private Set<Manager> managers;

    public ComputerBuilder id(long id){
        this.id = id;
        return this;
    }

    public ComputerBuilder ipAddress(String ipAddress){
        this.ipAddress = ipAddress;
        return this;
    }
    public ComputerBuilder hostName(String hostName){
        this.hostName = hostName;
        return this;
    }
    public ComputerBuilder macAddress(String macAddress){
        this.macAddress = macAddress;
        return this;
    }
    public ComputerBuilder socket(Socket socket){
        this.socket = socket;
        return this;
    }
    public ComputerBuilder managers(Set<Manager> managers){
        this.managers = managers;
        return this;
    }

    public Computer build() {
        Computer computer = new Computer();
        computer.setId(id);
        computer.setIpAddress(ipAddress);
        computer.setHostName(hostName);
        computer.setMacAddress(macAddress);
        computer.setSocket(socket);
        computer.setManagers(managers);
        return computer;
    }

}
