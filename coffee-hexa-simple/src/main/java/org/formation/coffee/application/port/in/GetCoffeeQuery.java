package org.formation.coffee.application.port.in;

import org.formation.coffee.domain.model.Coffee;
import org.formation.coffee.domain.model.CoffeeId;

public interface GetCoffeeQuery {
    Coffee getCoffee(CoffeeId coffeeId);
}
