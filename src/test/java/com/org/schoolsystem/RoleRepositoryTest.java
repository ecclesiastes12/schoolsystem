package com.org.schoolsystem;



import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.org.schoolsystem.entities.Role;
import com.org.schoolsystem.repositories.RoleRepository;

//@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class RoleRepositoryTest {

	@Autowired
	RoleRepository roleRepo;
	
	@Test
	public void createFirstRole() {
		Role roleAdmin = new Role("Admin", "Manages everything");
		Role savedRole = roleRepo.save(roleAdmin);
		
		assertThat(savedRole.getId()).isGreaterThan(0);
	}
	
	@Test
	public void createSecondtRole() {
		Role roleEditor = new Role("Editor","Manage categories, brands, "
				+ "products, articles and menus");
		Role savedRole = roleRepo.save(roleEditor);
		
		assertThat(savedRole.getId()).isGreaterThan(0);
	}
	
	@Test
	public void testCreateAllRoles() {
		Role roleHeadMaster = new Role("HeadMaster","Manage academic and administraion of the school");
		Role roleHeadTeacher = new Role("HeadTeacher","Manage staff and students");
		Role roleTeacher = new Role("Teacher","Teaches Students");
		Role roleLiberian = new Role("Liberian","Manage school library");
	
		
		roleRepo.saveAll(List.of(roleHeadMaster,roleHeadTeacher,roleTeacher,roleLiberian));
	}
}
