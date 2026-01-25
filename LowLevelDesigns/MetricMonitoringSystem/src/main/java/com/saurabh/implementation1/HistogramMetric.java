package com.saurabh.implementation1;

import java.util.Map;
import java.util.concurrent.atomic.LongAdder;

public class HistogramMetric implements Metric{
    private final MetricId metricId;
    private final double[] boundaries;
    private final LongAdder[] bucketCounters;

    public HistogramMetric(MetricId metricId, double[] boundaries) {
        this.metricId = metricId;
        this.boundaries = boundaries.clone();
        this.bucketCounters = new LongAdder[boundaries.length+1];
        for (int i = 0; i < this.bucketCounters.length; i++) {
            this.bucketCounters[i] = new LongAdder();
        }
    }

    @Override
    public void record(Long value) {
        int bucket = findBucket(value);
        bucketCounters[bucket].increment();

    }

    private int findBucket(Long value) {
        // implement this
        return 0;
    }

    @Override
    public MetricSnapshot getSnapShot() {
        long[] counts = new long[bucketCounters.length];
        for (int i= 0; i < counts.length; i++) {
            counts[i] = bucketCounters[i].sum();
        }

        return new HistogramMetricSnapshot(metricId, boundaries, counts);
    }

    @Override
    public String getName() {
        return metricId.name();
    }

    @Override
    public Map<String, String> getLabels() {
        return metricId.labels();
    }
}
