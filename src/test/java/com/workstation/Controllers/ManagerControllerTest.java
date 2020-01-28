package com.workstation.Controllers;

import com.workstation.Builder.ManagerBuilder;
import com.workstation.Models.Manager;
import com.workstation.Services.ManagerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Šimon Hašák
 */
@RunWith(SpringRunner.class)
@WebMvcTest(ManagerController.class)
public class ManagerControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ManagerService managerService;

    @Test
    public void getManagerComputers_thenReturnJsonArray_statusIs200() throws Exception {

        ManagerBuilder manager1 = new ManagerBuilder();
        ManagerBuilder manager2 = new ManagerBuilder();
        ManagerBuilder manager3 = new ManagerBuilder();
        ManagerBuilder manager4 = new ManagerBuilder();
        ManagerBuilder manager5 = new ManagerBuilder();
        ManagerBuilder manager6 = new ManagerBuilder();

        manager1.setName("Jozko Vajda");
        manager2.setName("Peter Ondras");
        manager3.setName("Peter Vajda");
        manager4.setName("Petronela Slivkova");
        manager5.setName("Simona Sokolovska");
        manager6.setName("Igor Romanovsky");

        List<Manager> managers = new ArrayList<>();
        managers.add(manager1.build());
        managers.add(manager2.build());
        managers.add(manager3.build());
        managers.add(manager4.build());
        managers.add(manager5.build());
        managers.add(manager6.build());

        given(managerService.getAll()).willReturn(managers);

        mvc.perform(get("/managers/getAll")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(6)))
                .andExpect(jsonPath("$[0].name").value(managers.get(0).getName()))
                .andExpect(jsonPath("$[1].name").value(managers.get(1).getName()))
                .andExpect(jsonPath("$[2].name").value(managers.get(2).getName()))
                .andExpect(jsonPath("$[3].name").value(managers.get(3).getName()))
                .andExpect(jsonPath("$[4].name").value(managers.get(4).getName()))
                .andExpect(jsonPath("$[5].name").value(managers.get(5).getName()));
    }

}