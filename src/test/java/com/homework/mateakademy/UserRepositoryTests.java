package com.homework.mateakademy;

import com.homework.mateakademy.domain.User;
import com.homework.mateakademy.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTests {

        @Autowired
        private UserRepository userRepository;

        @Test
        public void testSaveEmployee() {
            User user = new User("admin", "123)%", true, "ADMIN");
            userRepository.save(user);
           User user2 = userRepository.findByUsername("admin");
            assertNotNull(user);
            assertEquals(user2.getUsername(), user.getUsername());
            assertEquals(user2.getPassword(), user.getPassword());
        }

        @Test
        public void testDeleteEmployee() {
            User user = new User("admin", "123)%", true, "ADMIN");
            userRepository.save(user);
            userRepository.delete(user);
        }
}
