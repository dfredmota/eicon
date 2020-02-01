package com.eicon.service;

import com.eicon.domain.Cliente;
import com.eicon.repository.ClienteRepository;
import com.eicon.service.ClienteService;
import com.eicon.service.ClienteServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
public class ClienteAppServiceImplTest {

	@TestConfiguration
    static class ClienteAppServiceImplTestContextConfiguration {

        @Bean
        public ClienteService clienteAppService() {
            return new ClienteServiceImpl();
        }
    }

	@Autowired
	private ClienteService clienteAppService;

	@MockBean
	private ClienteRepository clienteAppRepository;

	@Before
	public void setUp() {

		Cliente cliente = new Cliente();

        Mockito.when(clienteAppRepository.findById(1L).get()).thenReturn(cliente);

	}

	@Test
	public void whenFindByIdFound() {

		Long id = 1L;

		Cliente clienteFound = clienteAppService.getById(id);

		//assertThat(clienteFound.getId()).isEqualTo(id);
	}


}
