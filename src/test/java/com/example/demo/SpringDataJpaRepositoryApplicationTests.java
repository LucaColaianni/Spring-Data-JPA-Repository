package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.demo.model.Impiegato;
import com.example.demo.model.Progetto;
import com.example.demo.model.Task;
import com.example.demo.repsoitory.ImpiegatoRepository;

import jakarta.persistence.EntityManager;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class SpringDataJpaRepositoryApplicationTests {
	
	@Autowired
	private ImpiegatoRepository impiegatoRepository;

	@Autowired
	private EntityManager entityManager;
	
	@BeforeEach
	public void createData() {
		Impiegato i = new Impiegato();
		i.setNome("Luca");
		i.setCognome("Colaianni");
		i.setEmail("lucacolaianni26@gmail.com");
		
		Progetto p1 = new Progetto();
		p1.setTitolo("Distruzione JS");
		p1.setDescrizione("Eliminare js dalla terra");
		p1.setDataInizio("13042023");
		
		Progetto p2 = new Progetto();
		p2.setTitolo("Distruzione php");
		p2.setDescrizione("Eliminare php dalla terra");
		p2.setDataInizio("13042023");
		
		Task t1= new Task();
		t1.setTitolo("Algoritmi");
		t1.setDescrizione("Ordinami una lista con le lamda exp");
		t1.setData("12042023");
		
		Task t2= new Task();
		t2.setTitolo("OOP");
		t2.setDescrizione("Spiegami l'OOp");
		t2.setData("11042023");


		entityManager.persist(i);
		entityManager.persist(p1);
		entityManager.persist(p2);
		entityManager.persist(t1);
		entityManager.persist(t2);
	}
	
	
	//test del repository
	@Test
	void impipiegatoRepositoryCheck() {
		assertThat( impiegatoRepository.count()).isEqualTo(1);
		
	}
	
	
	/*@Test
	void initialCheck() {
	List<Impiegato>	impiegati = entityManager.createQuery
			("SELECT i FROM Impiegato i", Impiegato.class).getResultList();
	
	assertThat(impiegati).hasSize(1);
	}*/
	
	/*@Test
	void progettoCheck() {
	List<Progetto>	progetti = entityManager.createQuery
			("SELECT p FROM Progetto p", Progetto.class).getResultList();
	
	List<Task> taskProgetto1 = entityManager.createQuery("SELECT t FROM Task WHERE t.progetto.id = ?1", Task.class)
	.setParameter(1, progetti.get(0).getId()).getResultList();
	
	assertThat(taskProgetto1).hasSize(2);
	
	List<Progetto>	progetti2 = entityManager.createQuery
			("SELECT p FROM Progetto p", Progetto.class).getResultList();
	
	List<Task> taskProgetto2 = entityManager.createQuery("SELECT t FROM Task WHERE t.progetto.id = ?1", Task.class)
	.setParameter(1, progetti.get(1).getId()).getResultList();
	
	assertThat(taskProgetto2).hasSize(0);

	}*/
	
	/*@Test
	void taskCheck() {
	List<Impiegato>	impiegati = entityManager.createQuery
			("SELECT i FROM Impiegato i", Impiegato.class).getResultList();
	
	assertThat(impiegati).hasSize(1);
	}*/
	

}
