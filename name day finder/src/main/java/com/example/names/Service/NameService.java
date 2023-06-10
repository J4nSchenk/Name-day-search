package com.example.names.Service;


import com.example.names.Entity.Nameday;
import com.example.names.Repository.NamedayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NameService {

    private final NamedayRepository namedayRepository;

    @Autowired
    public NameService(NamedayRepository namedayRepository) {
        this.namedayRepository = namedayRepository;
    }

    public List<String> getAllNames() {
        List<Nameday> namedays = namedayRepository.findAll();

        // Create a list to store the names
        List<String> names = new ArrayList<>();

        // Retrieve all the unique names
        for (Nameday nameday : namedays) {
            String nameValue = nameday.getName();
            if (!names.contains(nameValue)) {
                names.add(nameValue);
            }
        }

        return names;
    }
    public Nameday getNameday(String name) {
        Optional<List<Nameday>> namedaysOptional = namedayRepository.findByNameIgnoreCase(name);
        if (namedaysOptional.isPresent()) {
            List<Nameday> namedays = namedaysOptional.get();
            if (!namedays.isEmpty()) {
                Nameday nameday = namedays.get(0);
                nameday.setRequestCount(nameday.getRequestCount() + 1);
                namedayRepository.save(nameday);
                return nameday;
            }
        }
        throw new IllegalArgumentException("Nameday not found for name: " + name);
    }






    public Nameday createNameday(String date, String name) {
        Nameday nameday = new Nameday();
        nameday.setDate(date);
        nameday.setName(name);
        return namedayRepository.save(nameday);
    }


} /*private final NameRepository nameRepository;

    @GetMapping
    public List<Name> getNames() {
        return nameRepository.findAll();
    }

    @Autowired
    public NameService(NameRepository nameRepository) {
        this.nameRepository = nameRepository;
    }
*/