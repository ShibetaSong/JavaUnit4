package com.shibeta.unit4.day01.Demo1;

public class Interface1 implements InterfaceName<String>{
    private String text;
    @Override
    public String getData() {
        return text;
    }

}

class Interface2 <T> implements InterfaceName<T> {
    private T data;
    @Override
    public T getData() {
        return data;
    }
}
