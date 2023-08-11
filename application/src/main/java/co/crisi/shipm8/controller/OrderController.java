package co.crisi.shipm8.controller;

import co.crisi.shipm8.port.api.IOrderServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final IOrderServicePort servicePort;



}
