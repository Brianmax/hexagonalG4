package com.codigo.msregistro.application.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "reniec", url = "https://api.apis.net.pe/v2/reniec/dni")
public interface ReniecClient {
    @GetMapping
    ResponseReniec getPersona(@RequestParam("numero") String dni, @RequestHeader("Authorization") String token);
}
