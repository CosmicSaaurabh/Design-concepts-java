package com.saurabh.implementation1;

import java.util.Map;

public class GaugeMetric implements Metric{
    @Override
    public void record(Long value) {

    }

    @Override
    public MetricSnapshot getSnapShot() {
        return null;
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
