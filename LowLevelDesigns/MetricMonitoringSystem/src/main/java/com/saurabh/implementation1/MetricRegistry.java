package com.saurabh.implementation1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MetricRegistry {
    private final ConcurrentHashMap<MetricId, Metric> metrics = new ConcurrentHashMap<>();

    public CounterMetric counterMetric(String name, Map<String, String> labels) {
        MetricId metricId = new MetricId(name, labels);
        return (CounterMetric) metrics.computeIfAbsent(metricId, k -> new CounterMetric(metricId));
    }

    public HistogramMetric histogramMetric(String name, Map<String, String> labels, double[] boundaries){
        MetricId metricId = new MetricId(name, labels);

        return (HistogramMetric) metrics.computeIfAbsent(metricId, k -> new HistogramMetric(metricId, boundaries));
    }


    public Collection<MetricSnapshot> snapshotAll() {
        Collection<MetricSnapshot> collection = new ArrayList<>();
//        return collection.add(this.counterMetric().getSnapShot(), this.histogramMetric().getSnapShot());
        return collection;
    }
}
