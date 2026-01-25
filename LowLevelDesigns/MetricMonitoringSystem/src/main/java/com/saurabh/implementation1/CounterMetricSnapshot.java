package com.saurabh.implementation1;

public class CounterMetricSnapshot implements MetricSnapshot{
    private final MetricId metricId;
    private final Long sum;

    public CounterMetricSnapshot(MetricId metricId, Long sum) {
        this.metricId = metricId;
        this.sum = sum;
    }
}
