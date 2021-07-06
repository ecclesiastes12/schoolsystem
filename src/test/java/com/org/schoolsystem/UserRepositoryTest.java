
  package com.org.schoolsystem;
  
  
  
  import static org.assertj.core.api.Assertions.assertThat;
  
  import java.util.List;
  
  import org.junit.jupiter.api.Test; import
  org.springframework.beans.factory.annotation.Autowired; import
  org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
  import
  org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.
  Replace; import
  org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest; import
  org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager; import
  org.springframework.test.annotation.Rollback;
  
  import com.org.schoolsystem.entities.Role; import
  com.org.schoolsystem.entities.User; import
  com.org.schoolsystem.repositories.UserRepository; import
  com.org.schoolsystem.services.UserService;
  
  //@RunWith(SpringRunner.class)
  
  @DataJpaTest
  
  @AutoConfigureTestDatabase(replace = Replace.NONE)
  
  @Rollback(false) public class UserRepositoryTest {
  
  @Autowired UserRepository userRepo;
  
  
  
  @Autowired TestEntityManager entityManager;
  
  @Test public void testCreateNewUser() { Role roleAdmin =
  entityManager.find(Role.class, 1);
  
  User userJames = new User("danny@gmail.com","Dannis","Osei","danny123");
  userJames.addRole(roleAdmin);
  
  userJames.setEnabled(true); User savedUser = userRepo.save(userJames);
  assertThat(savedUser.getId()).isGreaterThan(0);
  
  
  }
  
  @Test public void testListAllUsers() { List<User> listUsers =
  userRepo.findAll();
  
  System.out.println("List of Users:" + listUsers); }
  
  @Test public void testGetUserById() { User userById =
  userRepo.findById(1).get(); System.out.println("List of Users:" + userById);
  assertThat(userById).isNotNull(); }
  
  }
 