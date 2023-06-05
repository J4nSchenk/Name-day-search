package com.example.names;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NameService {

//Všechna uložená jména s id(nepoužil jsem), name(jméno), date(datum svátku) a count(počet zobrazení jména)
    private static List<Names> names = Arrays.asList(
            new Names("1", "Jan", "24. června", 0),
            new Names("2", "Tomáš", "7. března", 0),
            new Names("3", "Lukáš", "18. října", 0),
            new Names("4","Ondra","30. listopadu", 0)
    );

    //ukázání statistik jmen
    public static Map<String, Integer> getAllNames() {
        Map<String, Integer> nameCounts = new HashMap<>();
        for (Names name : names) {
            String firstName = name.getName();
            int count = name.getCount();
            nameCounts.put(firstName, count);
        }
        return nameCounts;
    }


//nacházení jména + pokud se jméno nenajde hodí zpět IllegalArgumentException("Name was not found")
    public static Names GetName(String name) {
        Optional<Names> optionalName = names.stream()
                .filter(t -> t.getName().equals(name))
                .findFirst();

        if (optionalName.isPresent()) {
            Names foundName = optionalName.get();
            foundName.setCount(foundName.getCount() + 1);
            return foundName;
        } else {
            throw new IllegalArgumentException("Name was not found");
        }
    }




}
