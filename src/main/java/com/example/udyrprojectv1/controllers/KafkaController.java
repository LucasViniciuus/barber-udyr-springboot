package com.example.udyrprojectv1.controllers;
import com.example.udyrprojectv1.services.KafkaProducerService;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {
    private final KafkaProducerService _kafkaProducerService;

    private KafkaController(KafkaProducerService kafkaProducerService) {
        this._kafkaProducerService = kafkaProducerService;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam("message") String message) {
        _kafkaProducerService.sendMessage(message);
        return "Mensagem enviada com sucesso.";
    }
}
