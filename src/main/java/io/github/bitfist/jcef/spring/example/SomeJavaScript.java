package io.github.bitfist.jcef.spring.example;

import io.github.bitfist.jcef.spring.jsexecution.JavaScriptCode;

public interface SomeJavaScript {

    @JavaScriptCode(
            // language=javascript
            "console.log(:random)"
    )
    void execute(int random);
}
