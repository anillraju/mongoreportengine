package com.saba.report;

public class FilterCondition implements ReportFilter {
    private String   fieldName;
    private Operator operator;
    private String   value;

    /*
     *  (non-Javadoc)
     *     @see com.saba.report.ReportFilter#getFieldName()
     */
    @Override
    public String getFieldName() {
        return fieldName;
    }

    /*
     *  (non-Javadoc)
     * @see com.saba.report.ReportFilter#setFieldName(java.lang.String)
     */
    @Override
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    /*
     *  (non-Javadoc)
     * @see com.saba.report.ReportFilter#getOperator()
     */
    @Override
    public Operator getOperator() {
        return operator;
    }

    /*
     *  (non-Javadoc)
     * @see com.saba.report.ReportFilter#setOperator(com.saba.report.Operator)
     */
    @Override
    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    /*
     *  (non-Javadoc)
     * @see com.saba.report.ReportFilter#getValue()
     */
    @Override
    public String getValue() {
        return value;
    }

    /*
     *  (non-Javadoc)
     * @see com.saba.report.ReportFilter#setValue(java.lang.String)
     */
    @Override
    public void setValue(String value) {
        this.value = value;
    }
}
