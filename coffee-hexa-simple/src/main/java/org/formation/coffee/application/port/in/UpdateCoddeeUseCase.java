package org.formation.coffee.application.port.in;

import org.formation.coffee.domain.model.Coffee;

public interface UpdateCoddeeUseCase {
    Coffee updateCoffee(UpdateCoffeeCommand command);
}
