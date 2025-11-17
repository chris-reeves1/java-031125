import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import Rtesting.UserService;
import Rtesting.UserService.*;

@ExtendWith(MockitoExtension.class) // fake classes built + object at runtime. 
public class UserServiceTest {
// @Mock // alternative to the annotation.
// UserRepository repo;
  
// flow - force email isnt registered, call register check it returns a user.
@Test
void register_saves_new_user_and_returns_it(){
    // arrange
    UserRepository repo = mock(UserRepository.class); // only gets refered to at runtime. 
    when(repo.existsByEmail("test@test.com")).thenReturn(false); // stubbing - just offer what your test needs.

    UserService sut = new UserService(repo); // system under test - just conventional.

    // act
    User result = sut.register("test@test.com");

    // Assert
    assertNotNull(result);
    assertEquals("test@test.com", result.getEmail());

    // Assert interactions
    ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);
    verify(repo, times(1)).save(captor.capture());
    assertEquals("test@test.com", captor.getValue().getEmail());
    // simpler alternative:
    //verify(repo).save(any());
    verifyNoMoreInteractions(repo);
}
    
// invlaid email
@Test
void invalid_email_gets_rejected(){
    UserRepository repo = mock(UserRepository.class);
    UserService sut = new UserService(repo);

    assertThrows(IllegalArgumentException.class, () -> sut.register("invalid-email"));
    verifyNoMoreInteractions(repo);
}


// duplicate 
@Test
void rejects_deplicate(){
    UserRepository repo = mock(UserRepository.class);
    when(repo.existsByEmail("test@test.com")).thenReturn(true);
    UserService sut = new UserService(repo);

    assertThrows(IllegalStateException.class, () -> sut.register("test@test.com"));
    verify(repo).existsByEmail("test@test.com");
    // verify(repo).existsByEmail(anyString());
    // verify(repo).existsByEmail(eq("a@b.com"));
    verifyNoMoreInteractions(repo);
}
// in-order

// spy() - use the real resource if safe to do so. 

}
