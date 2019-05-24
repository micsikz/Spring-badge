package hu.flowacademy.badge.controller;

import hu.flowacademy.badge.domain.User;
import hu.flowacademy.badge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/users")
public class UsersController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @DeleteMapping("/delete/{userName}")
    public ResponseEntity<Void> deleteUserByUserName (@PathVariable String userName) {
        userService.delete(userName);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/list-users")
    public ResponseEntity<List<User>> listUser() {
        return ResponseEntity.ok(userService.listUsers());
    }

    @GetMapping("/find-user/{userName}")
    public ResponseEntity<User> findOneUser(@PathVariable String userName) {
        return ResponseEntity.ok(userService.getOneUser(userName));
    }
}
