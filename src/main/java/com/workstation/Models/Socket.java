package com.workstation.Models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Šimon Hašák
 */
@Entity
@Table(name = "socket")
public class Socket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 40)

    private String room;

    public Socket() {}

    public Socket(Long id, String room) {
        this.id = id;
        this.room = room;
    }

    @Override
    public String toString() {
        return String.format("Socket{ id= {}, room= {}}", id, room);
    }

    public Long getId() {
        return id;
    }

    public String getRoom() {
        return room;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}
