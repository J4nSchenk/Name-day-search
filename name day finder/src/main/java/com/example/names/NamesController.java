package com.example.names;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
public class NamesController {

    /*             ---------- test připojení -----------
@RequestMapping("/testos")
    public String test(){
        return "test successful";
    }
                   ---------- test připojení -----------
     */


    //Získání statistik jmen
    @RequestMapping("/allnames")
    public Map<String, Integer> getAllNames(){
        return NameService.getAllNames();
    }


    //Nácházení jména + chytne IllegalArgumentException pokud se jméno nenajde a pošle ResponseStatusException
    @RequestMapping("/name/{name}")
    public Names getName(@PathVariable String name) {
        try {
            return NameService.GetName(name);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Name was not found", e);
        }
    }


}
