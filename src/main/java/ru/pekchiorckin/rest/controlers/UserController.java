package ru.pekchiorckin.rest.controlers;

import org.springframework.web.bind.annotation.*;
import ru.pekchiorckin.rest.user.User;
import ru.pekchiorckin.rest.user.UserRepository;

import java.util.List;

@RestController
public class UserController {
    private final UserRepository repository;

    UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/usersAll/")
    List<User> all() {
        return repository.findAll();
    }

    @PostMapping("/users")
    User newEmployee(@RequestBody User newUser) {
        return repository.save(newUser);
    }

    // Single item

    @GetMapping("/user/{id}")
    User one(@PathVariable Integer id) {

        return repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @PutMapping("/usersput/{id}")
    User replaceEmployee(@RequestBody User newUser, @PathVariable Integer id) {

          return repository.findById(id)
                .map(user -> {
                    user.setName(newUser.getName());
                    user.setPhone(newUser.getPhone());
                    return repository.save(user);
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return new User(0, "не найден с таким ID", 0);
                    //repository.save(newUser);
                });
    }

    @DeleteMapping("/users/{id}")
    void deleteEmployee(@PathVariable Integer id) {
        repository.deleteById(id);
    }

}
