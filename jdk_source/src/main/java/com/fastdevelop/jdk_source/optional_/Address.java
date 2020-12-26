package com.fastdevelop.jdk_source.optional_;

import java.util.Optional;

public class Address {
    private Country country;

    public Optional<Country> getCountry() {
        return Optional.ofNullable(country);
    }

}
