package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.text.Bidi;
import java.util.ArrayList;
import java.util.List;

public final class World {
    List<Continent> continents = new ArrayList<>();

    public void addContinent(Continent continent){
        continents.add(continent);
        }

    public BigDecimal getPeopleQuantity(){
        return continents.stream()
                .flatMap(cont -> cont.getCountries().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, (sum, current) -> sum.add(current));

    }
}
