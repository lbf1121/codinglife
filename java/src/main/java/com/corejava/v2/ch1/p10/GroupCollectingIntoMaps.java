package com.corejava.v2.ch1.p10;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * TODO 类描述：
 *
 * @author liubf
 * @date 2024/4/9
 */
public class GroupCollectingIntoMaps {

    public static void main(String[] args) throws Exception {
        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
        Map<String, String> languageNames = locales.collect(Collectors.toMap(Locale::getDisplayName, l -> l.getDisplayLanguage(l), (existingValue, newValue) -> existingValue));
        System.out.println("languageNames:" + languageNames);

        locales = Stream.of(Locale.getAvailableLocales());
        Map<String, List<Locale>> countryToLocales = locales.filter(l->ObjectUtil.isNotEmpty(l.getCountry())).collect(Collectors.groupingBy(Locale::getCountry));
        System.out.println(countryToLocales);

        locales = Stream.of(Locale.getAvailableLocales());
        Map<Boolean, List<Locale>> englishAndOtherLocales = locales.filter(l->ObjectUtil.isNotEmpty(l.getLanguage())).collect(Collectors.partitioningBy(l->l.getLanguage().equals("en") ));
        List<Locale> englishLocales = englishAndOtherLocales.get(true);
        System.out.println(englishLocales);
        System.out.println(englishAndOtherLocales.get(false));
    }
}
