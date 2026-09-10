package com.instantsystem.parkingaroundme.client.provider;

import com.instantsystem.parkingaroundme.exception.CityNotSupportedException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class CityClientFactory {
    private final Map<String, ICityClientProvider> providers;

    public CityClientFactory(List<ICityClientProvider> providerList) {
        this.providers = providerList.stream()
                .collect(Collectors.toMap(
                        p -> p.getCityName().toUpperCase(),
                        Function.identity()
                ));
    }

    public ICityClientProvider getProvider(String cityName) {
        ICityClientProvider provider = providers.get(cityName.toUpperCase());
        if (provider == null) {
            throw new CityNotSupportedException(cityName);
        }
        return provider;
    }
}
