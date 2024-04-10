package com.corejava.v2.ch1.p9;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * TODO 类描述：
 *
 * @author liubf
 * @date 2024/4/9
 */
public class CollectingIntoMaps {

    public static void main(String[] args) throws Exception{
        Map<Integer,String> idToName = people().collect(Collectors.toMap(Person::getId,Person::getName));
        System.out.println("idToName:"+idToName);

        Map<Integer,Person> idToPerson = people().collect(Collectors.toMap(Person::getId, Function.identity()));
        System.out.println("idToPerson:"+idToPerson.getClass().getName()+idToPerson);

        idToPerson = people().collect(Collectors.toMap(Person::getId,Function.identity(),(existingValue,newValue)->{throw new IllegalStateException();}, TreeMap::new));
        System.out.println("idToPerson:"+idToPerson.getClass().getName()+idToPerson);

        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
        Map<String,String> languageNames = locales.collect(Collectors.toMap(Locale::getDisplayName,l->l.getDisplayLanguage(l),(existingValue,newValue)->existingValue));
        System.out.println("languageNames:"+languageNames);

        Stream.of(Locale.getAvailableLocales())
                .filter(locale -> locale.getDisplayName().contains("瑞士"))
                .forEach(t->{System.out.println(t.getDisplayName()+":"+t.getDisplayName(t));});
        System.out.println("====================");

        Stream.of(Locale.getAvailableLocales())
                .filter(locale -> locale.getDisplayName().contains("瑞士"))
                .collect(Collectors.toMap(Locale::getDisplayName,l->l.getDisplayLanguage()))
                .forEach((k,v)->{System.out.println(k+":"+v);});

        locales = Stream.of(Locale.getAvailableLocales());
        Map<String, Set<String>> countyLanguageSets = locales.skip(1).collect(
                Collectors.toMap(
                        Locale::getDisplayCountry,
                        l->Collections.singleton(l.getDisplayLanguage()),
                        (a,b)->{   // 防止key值重复
                            Set<String> union = new HashSet<>(a);
                            union.addAll(b);
                            return union;
                        }
                ));
        System.out.println("countyLanguageSets:"+countyLanguageSets);
    }

    public static Stream<Person> people(){
        return Stream.of(new Person(1001,"Peter"),
                new Person(1002,"Paul"),
                new Person(1003,"Mary"));
    }

    public static class Person{
        private int id;
        private String name;

        public Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
