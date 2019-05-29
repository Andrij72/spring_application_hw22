package com.homework.mateakademy.controller;

import com.homework.mateakademy.domain.Role;
import com.homework.mateakademy.domain.User;
import com.homework.mateakademy.repositories.UserRepository;
import com.homework.mateakademy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RegistrationController {

    private final UserService userService;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@NotNull User user, Map<String, Object> model) {
        User userFromDb = userService.getByUsername(user.getUsername());

        if (userFromDb != null) {
            model.put("message", "User exists!");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userService.saveUser(user);

        return "redirect:/login";
    }
}
