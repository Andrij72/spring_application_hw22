package com.homework.mateakademy.controller;

import com.homework.mateakademy.domain.Message;
import com.homework.mateakademy.domain.User;
import com.homework.mateakademy.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MainController {

    private final MessageService messageService;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model) {

        List<Message> messsage = (filter != null && !filter.isEmpty())? messageService.getByTag(filter) : messageService.findAllMessage();

        model.addAttribute("messages", messsage);
        model.addAttribute("filter", filter);

        return "main";
    }

    @PostMapping("/main")
    public String add(@AuthenticationPrincipal User user, @RequestParam String text, @RequestParam String tag, Map<String, Object> model
    ) {
        Message message = new Message(text, tag, user);

        messageService.saveMessage(message);

        List<Message> messages = messageService.findAllMessage();

        model.put("messages", messages);

        return "main";
    }
}
