package com.workstation.Services;

import com.workstation.Builder.ManagerBuilder;
import com.workstation.Models.Manager;
import com.workstation.Repositories.ManagerRepository;
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
public class ManagerServiceImplTest {

    @Configuration
    static class ManagerServiceImplTestContextConfiguration {

        @Bean
        public ManagerService managerService() {
            return new ManagerServiceImpl();
        }
        @Bean
        public ManagerRepository accountRepository() {
            return Mockito.mock(ManagerRepository.class);
        }
    }

    @Autowired
    private ManagerService managerService;

    @Autowired
    private ManagerRepository managerRepository;

    @Before
    public void setUp(){
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

        Mockito.when(managerRepository.findAll()).thenReturn(managers);
    }

    @After
    public void clean() {
        Mockito.reset(managerRepository);
    }

    @Test
    public void getAllManagers() {
        String[] managersNamesExpected = {"Jozko Vajda", "Peter Ondras", "Peter Vajda", "Petronela Slivkova",
                "Simona Sokolovska", "Igor Romanovsky"};
        List<Manager> managersResult = managerService.getAll();

        assertEquals(managersNamesExpected[0], managersResult.get(0).getName());
        assertEquals(managersNamesExpected[1], managersResult.get(1).getName());
        assertEquals(managersNamesExpected[2], managersResult.get(2).getName());
        assertEquals(managersNamesExpected[3], managersResult.get(3).getName());
        assertEquals(managersNamesExpected[4], managersResult.get(4).getName());
        assertEquals(managersNamesExpected[5], managersResult.get(5).getName());
    }
}