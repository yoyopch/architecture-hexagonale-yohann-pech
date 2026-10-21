package org.formation.coffee.adapter.out.persistence;

import org.formation.coffee.application.port.out.LoadCoffeePort;
import org.formation.coffee.application.port.out.SaveCofeePort;
import org.formation.coffee.domain.exception.CoffeeNotFoundException;
import org.formation.coffee.domain.model.Coffee;
import org.formation.coffee.domain.model.CoffeeId;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
class CoffeePersistanceAdapter implements LoadCoffeePort, SaveCofeePort {
    private final CoffeeJpaRepository repository;
    private final CoffeePersistanceMapper mapper;

    CoffeePersistanceAdapter(CoffeeJpaRepository repository, CoffeePersistanceMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<Coffee> findAll(){
        return repository.findAllByOrderByIdAsc().stream().map(mapper::toDomain).toList();
    }

    @Override
    public Optional<Coffee> findById(CoffeeId id){
        return repository.findwithReviewsById(id.value()).map(mapper::toDomain);
    }

    @Override
    public Coffee save(Coffee coffee){
        CoffeeId id = coffee.getId();
        if(id == null){
            return mapper.toDomain(repository.save((mapper.toNewEntity(coffee))));
        }
        CoffeeJpaEntity managed = repository.findwithReviewsById(id.value()).orElseThrow(
                () -> new CoffeeNotFoundException(id)
        );
        mapper.updateEntity(coffee, managed);
        return mapper.toDomain(managed);
    }
}
