package com.example.names.Controller;



import com.example.names.Entity.Nameday;
import com.example.names.Repository.NamedayRepository;
import com.example.names.Service.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.*;

@RestController
public class NamesController {

    @Autowired
    private NamedayRepository namedayRepository;

    @Autowired
    private NameService nameService;

    @PostMapping("/namedays")
    public ResponseEntity<Nameday> createNameday(@RequestBody Nameday nameday) {
        Nameday createdNameday = namedayRepository.save(nameday);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdNameday);
    }

    @RequestMapping("/allnames")
    public ResponseEntity<List<String>> getAllNames() {
        List<Nameday> namedays = namedayRepository.findAll();

        // Create a map to store the names and their request counts
        Map<String, Integer> nameCounts = new HashMap<>();

        // Retrieve all the unique names and count the requests
        for (Nameday nameday : namedays) {
            String nameValue = nameday.getName();
            int count = nameday.getCount();
            if (!nameCounts.containsKey(nameValue)) {
                nameCounts.put(nameValue, count);
            } else {
                int totalCount = nameCounts.get(nameValue) + count;
                nameCounts.put(nameValue, totalCount);
            }
        }

        // Create a list to store the names and request counts
        List<String> names = new ArrayList<>();

        // Format the names and request counts as a string
        for (Map.Entry<String, Integer> entry : nameCounts.entrySet()) {
            String name = entry.getKey();
            int count = entry.getValue();
            String nameWithCount = name + " (Requests: " + count + ")";
            names.add(nameWithCount);
        }

        return ResponseEntity.ok(names);
    }


    @GetMapping("/name/{name}")
    public ResponseEntity<?> getNameday(@PathVariable("name") String name) {
        Optional<List<Nameday>> optionalNamedays = namedayRepository.findByNameIgnoreCase(name);
        if (optionalNamedays.isPresent()) {
            List<Nameday> namedays = optionalNamedays.get();
            Nameday nameday = namedays.get(0);
            nameday.setCount(nameday.getCount() + 1);
            namedayRepository.save(nameday);
            return ResponseEntity.ok(nameday);
        } else {
            String message = "Name not found: " + name;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<?> deleteNameday(@PathVariable("name") String name) {
        Optional<List<Nameday>> optionalNamedays = namedayRepository.findByNameIgnoreCase(name);
        if (optionalNamedays.isPresent()) {
            List<Nameday> namedays = optionalNamedays.get();
            namedayRepository.deleteAll(namedays);
            return ResponseEntity.ok("Names deleted: " + name);
        } else {
            String message = "Names not found: " + name;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }







}

