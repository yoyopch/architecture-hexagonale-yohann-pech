package org.formation.coffee.application.port.out;

import java.util.function.Supplier;

public interface TransactionRunner {
    <T> T execute(Supplier<T> work);
    <T> T executeReadOnly(Supplier<T> work);
}
