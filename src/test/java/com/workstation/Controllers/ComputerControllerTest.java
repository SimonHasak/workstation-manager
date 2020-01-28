package com.workstation.Controllers;

import com.workstation.Builder.ComputerBuilder;
import com.workstation.Models.Computer;
import com.workstation.Models.Socket;
import com.workstation.Services.ComputerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Šimon Hašák
 */
@RunWith(SpringRunner.class)
@WebMvcTest(ComputerController.class)
public class ComputerControllerTest {


    @Autowired
    private MockMvc mvc;

    @MockBean
    private ComputerService service;

    @Test
    public void getManagerComputers_thenReturnJsonArray_statusIs200() throws Exception {

        Socket socket1 = new Socket(1L, "room1");
        ComputerBuilder computer2 = new ComputerBuilder();
        computer2.ipAddress("120.84.168.150").macAddress("a5:01:77:e5:o9:17").hostName("computer2").socket(socket1);

        Socket socket2 = new Socket(2L, "room2");
        ComputerBuilder computer1 = new ComputerBuilder();
        computer1.ipAddress("220.78.168.0").macAddress("00:0a:95:9d:68:16").hostName("computer1").socket(socket2);

        Socket socket3 = new Socket(4L, "room2");
        ComputerBuilder computer5 = new ComputerBuilder();
        computer5.ipAddress("152.89.251.123").macAddress("77:e7:e8:9d:12:65").hostName("computer5").socket(socket3);

        List<Computer> managerComputers = new ArrayList<>();
        managerComputers.add(computer1.build());
        managerComputers.add(computer2.build());
        managerComputers.add(computer5.build());

        given(service.getAllManagerComputers(1L)).willReturn(managerComputers);

        mvc.perform(get("/computers/getAllManagerComputers/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].hostName").value(managerComputers.get(0).getHostName()))
                .andExpect(jsonPath("$[1].hostName").value(managerComputers.get(1).getHostName()))
                .andExpect(jsonPath("$[2].hostName").value(managerComputers.get(2).getHostName()));
    }

    @Test
    public void getRoomByIpAddress_returnStringFormat_statusIs200() throws Exception {

        String validIpAddress = "120.84.168.150";
        String expectedRoom = "room1";
        given(service.getRoomByIpAddress(validIpAddress)).willReturn(expectedRoom);

        MvcResult result = mvc.perform(get("/computers/getRoomByIpAddress/{ipAddress}", validIpAddress)
                .accept(MediaType.TEXT_PLAIN)).andExpect(status().isOk()).andReturn();

        assertThat(result.getResponse().getContentAsString().equals(expectedRoom));
    }

    @Test
    public void getAllStationsInTheRoom_returnJsonFormat_statusIs200() throws Exception {

        String validRoom = "room1";

        List<String> expectedComputers = new ArrayList<>();
        expectedComputers.add("computer2");

        given(service.getAllStationsInTheRoom(validRoom)).willReturn(expectedComputers);

        MvcResult result = mvc.perform(get("/computers/getAllStationsInTheRoom/{room}", validRoom)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andReturn();

        assertThat(result.getResponse().getContentAsString().equals(expectedComputers.get(0)));
    }

}