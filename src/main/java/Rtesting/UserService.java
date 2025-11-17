package Rtesting;

import java.util.Objects;

// A tiny “service” with a dependency we’ll mock in tests.
// handles user registration and relies on UserRepository. 
public class UserService {
    private final UserRepository repo;  // dependency

    public UserService(UserRepository repo) {
        this.repo = Objects.requireNonNull(repo, "UserRepository  cannot be null!!");
    }

    // register a user - checks if email is valid. 
    // sav doesnt do anything we just want to know if it gets called. 
    public User register(String email) {
        if (email == null || !email.contains("@"))
            throw new IllegalArgumentException("invalid email");

        if (repo.existsByEmail(email))
            throw new IllegalStateException("already registered");

        User user = new User(email);
        repo.save(user); // side effect we’ll verify
        return user;
    }

    
    public static class User {
        private final String email;
        public User(String email) { this.email = email; }
        public String getEmail() { return email; }
    }

    // this is not implemetnted in the serivce class so we mock or provide an implemtnation. 
    // simulates a db. 
    public interface UserRepository {
        boolean existsByEmail(String email);
        void save(User user);
    }
}