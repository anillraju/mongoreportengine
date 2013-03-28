package com.saba.report;

public interface ReportFilter {
    public abstract String getFieldName();

    public abstract void setFieldName(String fieldName);

    public abstract Operator getOperator();

    public abstract void setOperator(Operator operator);

    public abstract String getValue();

    public abstract void setValue(String value);
}
