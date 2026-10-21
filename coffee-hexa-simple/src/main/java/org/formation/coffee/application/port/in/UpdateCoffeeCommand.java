package org.formation.coffee.application.port.in;

import org.formation.coffee.domain.model.CoffeeId;
import org.formation.coffee.domain.model.Price;
import org.jspecify.annotations.Nullable;

import java.util.Objects;

public record UpdateCoffeeCommand(CoffeeId id, @Nullable String name, @Nullable Price price) {
    public UpdateCoffeeCommand {
        Objects.requireNonNull(id, "id must not be null");
    }
}
