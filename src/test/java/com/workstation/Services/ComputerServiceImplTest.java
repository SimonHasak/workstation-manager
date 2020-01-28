package com.workstation.Services;

import com.workstation.Builder.ComputerBuilder;
import com.workstation.Models.Computer;
import com.workstation.Models.Socket;
import com.workstation.Repositories.ComputerRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Šimon Hašák
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class ComputerServiceImplTest {

    @Configuration
    static class ComputerServiceImplTestContextConfiguration {

        @Bean
        public ComputerService computerService() {
            return new ComputerServiceImpl();
        }
        @Bean
        public ComputerRepository accountRepository() {
            return Mockito.mock(ComputerRepository.class);
        }
    }

    @Autowired
    private ComputerService computerService;

    @Autowired
    private ComputerRepository computerRepository;

    @Before
    public void setUp(){
        Socket socket1 = new Socket(1L, "room1");
        ComputerBuilder computer2 = new ComputerBuilder();
        computer2.ipAddress("120.84.168.150").macAddress("a5:01:77:e5:o9:17").hostName("computer2").socket(socket1);

        Socket socket2 = new Socket(2L, "room2");
        ComputerBuilder computer1 = new ComputerBuilder();
        computer1.ipAddress("220.78.168.0").macAddress("00:0a:95:9d:68:16").hostName("computer1").socket(socket2);

        Socket socket3 = new Socket(4L, "room2");
        ComputerBuilder computer5 = new ComputerBuilder();
        computer5.ipAddress("152.89.251.123").macAddress("77:e7:e8:9d:12:65").hostName("computer5").socket(socket3);

        List<Computer> computersInRoom2 = new ArrayList<>();
        computersInRoom2.add(computer1.build());

        List<Computer> managerComputers = new ArrayList<>();
        managerComputers.add(computer1.build());
        managerComputers.add(computer2.build());
        managerComputers.add(computer5.build());

        Mockito.when(computerRepository.findAllByManagers_Id(1L)).thenReturn(managerComputers);
        Mockito.when(computerRepository.findComputerByIpAddress("120.84.168.150")).thenReturn(computer2.build());
        Mockito.when(computerRepository.findComputersBySocket_Room("room2")).thenReturn(computersInRoom2 );
    }

    @After
    public void clean() {
        Mockito.reset(computerRepository);
    }

    @Test
    public void getAllManagerComputers_managerIdOne() {
        String[] computerNamesExpected = {"computer1", "computer2", "computer5"};
        List<Computer> managerComputersResult = computerService.getAllManagerComputers(1L);

        assertEquals(computerNamesExpected[0], managerComputersResult.get(0).getHostName());
        assertEquals(computerNamesExpected[1], managerComputersResult.get(1).getHostName());
        assertEquals(computerNamesExpected[2], managerComputersResult.get(2).getHostName());
    }

    @Test
    public void getRoomByIpAddress_validIpAddress() {
        String roomExpected = "room1";
        String roomResult = computerService.getRoomByIpAddress("120.84.168.150");

        assertEquals(roomExpected, roomResult);
    }

    @Test
    public void getAllStationsInTheRoom() {
        String stationExpected = "computer1";
        String stationResult = computerService.getAllStationsInTheRoom("room2").get(0);

        assertEquals(stationExpected, stationResult);
    }
}