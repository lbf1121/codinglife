package com.corejava.v2.ch1.p11;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * TODO 类描述：
 *
 * @author liubf
 * @date 2024/4/10
 */
public class DownstreamCollectors {

    public static void main(String[] args) throws Exception {
        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
        Map<String, Set<Locale>> countryToLocaleSet = locales.collect(Collectors.groupingBy(Locale::getCountry, Collectors.toSet()));
        System.out.println("countryToLocaleSet:" + countryToLocaleSet);

        locales = Stream.of(Locale.getAvailableLocales());
        Map<String, Long> countyToLocaleCount = locales.collect(Collectors.groupingBy(Locale::getCountry, Collectors.counting()));
        System.out.println("countyToLocaleCount:" + countyToLocaleCount);

        String cityFile = "./java/src/main/java/com/corejava/v2/gutenberg/cities.txt";
        Stream<City> cities = readCities(cityFile);
        Map<String, Integer> stateToCityPopulation = cities.collect(Collectors.groupingBy(City::getState, Collectors.summingInt(City::getPopulation)));
        System.out.println("stateToCityPopulation:" + stateToCityPopulation);

        cities = readCities(cityFile);
        Map<String, Optional<String>> stateToLongestCityName = cities.collect(Collectors.groupingBy(City::getState,
                Collectors.mapping(City::getName,
                        Collectors.maxBy(Comparator.comparing(String::length)))));
        System.out.println("stateToLongestCityName:" + stateToLongestCityName);

        locales = Stream.of(Locale.getAvailableLocales());
        Map<String, Set<String>> countyToLanguages = locales.collect(Collectors.groupingBy(Locale::getCountry, Collectors.mapping(Locale::getDisplayLanguage, Collectors.toSet())));
        System.out.println("countyToLanguages:" + countyToLanguages);

        cities = readCities(cityFile);
        Map<String, IntSummaryStatistics> stateToCityPopulationSummary = cities.collect(Collectors.groupingBy(City::getState,
                Collectors.summarizingInt(City::getPopulation)));
        System.out.println(stateToCityPopulationSummary.get("NY"));

        cities = readCities(cityFile);
        Map<String, String> stateToCityNames = cities.collect(Collectors.groupingBy(City::getState,
                Collectors.reducing("", City::getName, (s, t) -> s.length() == 0 ? t : s + "." + t)));
        System.out.println("stateToCityNames:" + stateToCityNames);

        cities = readCities(cityFile);
        stateToCityNames = cities.collect(Collectors.groupingBy(City::getState,
                Collectors.mapping(City::getName,Collectors.joining("."))));
        System.out.println("stateToCityNames:" + stateToCityNames);
    }

    public static Stream<City> readCities(String filename) throws Exception {

        return Files.lines(Paths.get(filename))
                .map(l -> l.split(","))
                .map(a -> new City(a[0].trim(), a[1].trim(), Integer.parseInt(a[2].trim())));
    }

    public static class City {
        private String name;
        private String state;
        private int population;

        public City(String name, String state, int population) {
            this.name = name;
            this.state = state;
            this.population = population;
        }

        public String getName() {
            return name;
        }

        public String getState() {
            return state;
        }

        public int getPopulation() {
            return population;
        }
    }
}
