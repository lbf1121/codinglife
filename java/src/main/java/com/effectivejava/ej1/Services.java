package com.effectivejava.ej1;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Noninstantiable class for service registration and access
 * instantiable(可实例化)
 **/
public class Services {
    private Services(){}

    private static final Map<String,Provider> providers = new ConcurrentHashMap<String,Provider>();

    private static final String DEFAULT_PROVIDER_NAME = "<def>";

    public static void registerDefaultProvider(Provider provider){
        registerProvider(DEFAULT_PROVIDER_NAME,provider);
    }

    private static void registerProvider(String defaultProviderName,Provider provider) {
        providers.put(defaultProviderName,provider);
    }

    public static Service newInstance(){
        return newInstance(DEFAULT_PROVIDER_NAME);
    }

    private static Service newInstance(String defaultProviderName) {
        Provider provider = providers.get(defaultProviderName);
        if(provider==null){
            throw new IllegalArgumentException("No provider registered with name："+defaultProviderName);
        }
        return provider.newService();
    }
}
