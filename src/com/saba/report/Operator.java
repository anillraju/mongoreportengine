package com.saba.report;

public enum Operator {
    NOTEQUAL("$ne"), EQUAL("$e");

    String symbol;

    private Operator(String sym) {
        symbol = sym;
    }

    public String getSymbol() {
        return symbol;
    }
}
