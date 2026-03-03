package com.example.actionservice.repo;
@java.lang.FunctionalInterface
public interface FunctionalInterface {
    abstract void walk();
    default void bark() {}
    default void ran(){}
    private void talk() {}
    private void speak(){}
    static void running(){}
    static void play(){}
}
