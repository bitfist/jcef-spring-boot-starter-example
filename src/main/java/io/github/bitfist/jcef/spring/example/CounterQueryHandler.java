package io.github.bitfist.jcef.spring.example;

import io.github.bitfist.jcef.spring.query.CefQueryHandler;
import io.github.bitfist.jcef.spring.query.TypeScriptConfiguration;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@CefQueryHandler("/counter")
@TypeScriptConfiguration(packageName = "io.github.bitfist.jcef.spring.example.infrastructure")
class CounterQueryHandler {

    private final SomeJavaScript someJavaScript;

    CounterQueryHandler(SomeJavaScript someJavaScript) {
        this.someJavaScript = someJavaScript;
    }

    @CefQueryHandler("{id}")
    CounterResponse count(int id, CounterQuery query) {
        log.info("Object counter with ID {}: {}", id, query.counter);
        return new CounterResponse(String.valueOf(id), query.counter);
    }

    @CefQueryHandler("simple")
    int simple(int counter) {
        log.info("Simple counter: {}", counter);
        return counter;
    }

    @CefQueryHandler("logRandom")
    void logRandom() {
        someJavaScript.execute((int) (Math.random() * 100_000));
    }

    @Data
    static class CounterQuery {
        private int counter;
    }
    @Data
    @AllArgsConstructor
    static class CounterResponse {
        private String id;
        private int counter;
    }
}
