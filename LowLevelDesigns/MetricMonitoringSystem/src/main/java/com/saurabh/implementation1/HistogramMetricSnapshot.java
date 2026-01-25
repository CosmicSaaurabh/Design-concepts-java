package com.saurabh.implementation1;

public class HistogramMetricSnapshot implements MetricSnapshot{
    private final MetricId metricId;
    private final double[] boundaries;
    private final long[] counts;

    public HistogramMetricSnapshot(MetricId metricId, double[] boundaries, long[] counts) {
        this.metricId = metricId;
        this.boundaries = boundaries;
        this.counts = counts;
    }
}
