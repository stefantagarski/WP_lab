package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.User;
import mk.finki.ukim.mk.lab.model.exceptions.PasswordsDontMatchException;
import mk.finki.ukim.mk.lab.model.exceptions.UserDoesNotExistException;
import mk.finki.ukim.mk.lab.model.exceptions.UsernameAlreadyExistsException;
import mk.finki.ukim.mk.lab.repository.jpa.UserRepository;
import mk.finki.ukim.mk.lab.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            throw new UserDoesNotExistException();
        }
        return userRepository.findByUsernameAndPassword(username, password)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public User register(String username, String password, String repeatPassword) {
        if (username.isEmpty() || password.isEmpty() || repeatPassword.isEmpty() ) {
            throw new RuntimeException();
        }

        if (!password.equals(repeatPassword)) {
            throw new PasswordsDontMatchException();
        }

        if (!userRepository.findByUsername(username).isEmpty()
                || userRepository.findByUsername(username).isPresent()) {
            throw new UsernameAlreadyExistsException(username);
        }

        return userRepository.save(new User(username, password));
    }
}
