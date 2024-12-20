package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
public class EmployeeJpaTest extends EmployeeApplicationTests{

	@Autowired
	EmployeeRepository er;
    @Autowired
    private EntityManager te;



//    @BeforeEach
//    public void setUp() {
//        er.deleteAll();
//    }
    
	@Test
	public void storeData() {
	    Employee sa = er.save(new Employee("kumar", 5000, 18));
	    			er.save(new Employee("kholi", 100000, 0));
	    			er.save(new Employee("abishek", 50000, 0));
	    			er.save(new Employee("dhoni", 100000, 0));
	    assertThat(sa).hasFieldOrPropertyWithValue("name", "kumar")
	                  .hasFieldOrPropertyWithValue("salary", 5000)
	                  .hasFieldOrPropertyWithValue("a", 18);
	    
	}

    @Test
    public void mocikito_store_test(){

    }
	 @Test
	public void should_find_all_employees() throws Exception{
	        Employee abishek = new Employee("abishek", 50000, 0);
	        te.persist(abishek);//persist is used to save
	        Employee dhoni = new Employee("dhoni", 100000, 0);
	        te.persist(dhoni);
	        Employee kholi = new Employee("kholi", 100000, 0);
	        te.persist(kholi);
	        Employee kumar = new Employee("kumar", 5000, 18);
	        te.persist(kumar);
	        Iterable<Employee> e = er.findAll();
	        assertThat(e).hasSize(4).contains(abishek, dhoni, kholi, kumar);
	    }
    @Test
    public void should_find_employee_by_id() {
        Employee emp1 = new Employee("Abishek", 50000, 0);
        te.persist(emp1);
        Employee emp2 = new Employee("Dhoni", 100000, 0);
        te.persist(emp2);
        te.flush();
        Employee foundEmployee = er.findById(emp2.getId()).get();

        assertThat(foundEmployee).isEqualTo(emp2);
    }

    @Test
    public void should_delete_all_employees() {
        te.persist(new Employee("kumar", 5000, 18));
        te.persist(new Employee("Dhoni", 100000, 0));
        er.deleteAll();
        assertThat(er.findAll()).isEmpty();
    }

    @Test
    public void should_delete_employee_by_id() {
        // Given
        Employee emp1 = new Employee("Abishek", 50000, 0);
        te.persist(emp1);
        Employee emp2 = new Employee("Dhoni", 100000, 0);
        te.persist(emp2);
        Employee emp3 = new Employee("Kohli", 100000, 0);
        te.persist(emp3);
        te.flush();
        er.deleteById(emp2.getId());
        Iterable<Employee> employees = er.findAll();
        assertThat(employees).hasSize(2).contains(emp1, emp3);
    }
    
    @Test
    public void should_update_employee_by_id() {
        Employee emp1 = new Employee("Abishek", 50000, 0);
        te.persist(emp1);
        Employee emp2 = new Employee("Dhoni", 100000, 0);
        te.persist(emp2);
        te.flush();
        Employee updatedEmp = new Employee("Updated Dhoni", 120000, 0);
        Employee emp = er.findById(emp2.getId()).get();
        emp.setName(updatedEmp.getName());
        emp.setSalary(updatedEmp.getSalary());
        emp.setA(updatedEmp.getA());
        er.save(emp);
        Employee checkEmp = er.findById(emp2.getId()).get();
        assertThat(checkEmp.getId()).isEqualTo(emp2.getId());
        assertThat(checkEmp.getName()).isEqualTo(updatedEmp.getName());
        assertThat(checkEmp.getSalary()).isEqualTo(updatedEmp.getSalary());
        assertThat(checkEmp.getA()).isEqualTo(updatedEmp.getA());
    }
}
