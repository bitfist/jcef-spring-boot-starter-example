package io.github.bitfist.jcef.spring.example;

import io.github.bitfist.jcef.spring.tsobject.TypeScriptConfiguration;
import io.github.bitfist.jcef.spring.tsobject.TypeScriptObject;
import lombok.Data;

@TypeScriptObject
@TypeScriptConfiguration
class SomeJavaScriptObject {

    public ComplexType3 something(int id, String name, byte aByte, ComplexType2 type2) {
        return null;
    }

    @Data
    @TypeScriptConfiguration
    static class ComplexType1 {
        private String name;
    }

    @Data
    @TypeScriptConfiguration
    static class ComplexType2 {
        private ComplexType1 type1;
        private int age;
    }

    @Data
    static class ComplexType3 {
        private String message;
        private ComplexType2 type2;
    }
}
