package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {

    public static List<Address> collect(List<Profile> profiles) {
        List<Address> adress = new ArrayList<>();
        adress = profiles.stream()
                .map(s -> s.getAddress())
                .collect(Collectors.toList());
        return adress;
    }

    public static List<Address> collectSortWithoutDuplicate(List<Profile> profiles) {
        List<Address> adress = new ArrayList<>();
        adress = collect(profiles)
                .stream()
                .sorted(Comparator.comparing(Address::getCity))
                .distinct().toList();
        return adress;
    }
}