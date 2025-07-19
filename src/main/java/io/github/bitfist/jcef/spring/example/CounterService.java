package io.github.bitfist.jcef.spring.example;

import io.github.bitfist.jcef.spring.tsobject.TypeScriptConfiguration;
import io.github.bitfist.jcef.spring.tsobject.TypeScriptObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;

@Slf4j
@TypeScriptObject
@TypeScriptConfiguration
class CounterService {

    private final SomeJavaScript someJavaScript;

    CounterService(@Lazy SomeJavaScript someJavaScript) {
        this.someJavaScript = someJavaScript;
    }

    public int simple(int count) {
        log.info("simple count {}", count);
        return count + 1;
    }

    public CountResponse count(int count, CountRequest request) {
        log.info("count {} {}", count, request);
        return new CountResponse(request.count + 1);
    }

    public int random() {
        int random = (int) (Math.random() * 1_000_000);
        someJavaScript.execute(random);
        return random;
    }

    @Data
    static class CountRequest {
        private int count;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class CountResponse {
        private int count;
    }
}
