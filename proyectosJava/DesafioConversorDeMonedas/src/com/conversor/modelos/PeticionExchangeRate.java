package com.conversor.modelos;

import com.google.gson.JsonObject;

public record PeticionExchangeRate(
        String result,
        String base_code,
        JsonObject conversion_rates
) {
}
