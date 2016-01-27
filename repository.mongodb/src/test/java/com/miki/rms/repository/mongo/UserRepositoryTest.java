package com.miki.rms.repository.mongo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.miki.rms.domain.model.user.User;
import com.miki.rms.domain.model.user.UserBuilder;
import com.miki.rms.domain.model.user.UserFactory;
import com.miki.rms.repository.mongo.model.MongoUserRepository;

/** Created by mikibrv on 27/01/16. */
@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations = { "classpath:mongorepository/repository.xml" })
public class UserRepositoryTest {

    @Resource
    private MongoUserRepository mongoUserRepository;

    UserRepository userRepository;

    @Before
    public void init() {
        this.userRepository = new UserRepository(mongoUserRepository);
    }

    @Test
    public void testContextLoad() {
        assertNotNull(mongoUserRepository);
    }

    @Test
    public void saveAndRemove() {
        User userToSave = UserFactory.getFactory(
                new UserBuilder()
                        .setUserIdentity(UserFactory.fromSerializedString("miki@miki.com")))
                .build();
        User savedUser = userRepository.save(userToSave);
        assertNotNull(savedUser);
        assertEquals(userToSave, savedUser);

        // let's see if we can find him
        User foundUser = userRepository.findOne(userToSave.getUserIdentity());
        assertNotNull(foundUser);
        assertEquals(savedUser, foundUser);

        userRepository.delete(foundUser);
        foundUser = userRepository.findOne(userToSave.getUserIdentity());
        assertNull(foundUser);
    }

}
