package com.saurabh.implementation1;

import java.util.Map;
import java.util.concurrent.atomic.LongAdder;

public class CounterMetric implements Metric{
    private final MetricId id;
    private final LongAdder counter = new LongAdder();

    public CounterMetric(MetricId id) {
        this.id = id;
    }

    @Override
    public void record(Long value) {
        if (value < 0) throw new IllegalArgumentException("Counter value cannot be less zero, as it cannot decrease");
        counter.add(value);
    }

    @Override
    public MetricSnapshot getSnapShot() {
        return new CounterMetricSnapshot(id, counter.sum());
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public Map<String, String> getLabels() {
        return Map.of();
    }
}
