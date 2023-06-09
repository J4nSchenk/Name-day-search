package com.example.names.Service;

import com.example.names.Entity.Name;
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

    public List<Name> getAllNames() {
        List<Name> names = new ArrayList<>();
        List<Nameday> namedays = namedayRepository.findAll();

        for (Nameday nameday : namedays) {
            Name name = new Name();
            name.setName(nameday.getName());
            name.setDate(nameday.getDate());
            name.setCount(nameday.getRequestCount());

            names.add(name);
        }

        return names;
    }
    public Name getName(String name) {
        Optional<List<Nameday>> namedayOptional = namedayRepository.findByNameIgnoreCase(name);
        if (namedayOptional.isPresent()) {
            Nameday nameday = (Nameday) namedayOptional.get();
            nameday.setRequestCount(nameday.getRequestCount() + 1);
            namedayRepository.save(nameday);

            Name result = new Name();
            result.setName(nameday.getName());
            result.setDate(nameday.getDate());
            result.setCount(nameday.getRequestCount());
            return result;
        } else {
            throw new IllegalArgumentException("Name was not found");
        }
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