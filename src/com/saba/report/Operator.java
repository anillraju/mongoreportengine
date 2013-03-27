package com.saba.report;

public enum Operator {
    NOTEQUAL("$ne");

    String symbol;

    private Operator(String sym) {
        symbol = sym;
    }
}