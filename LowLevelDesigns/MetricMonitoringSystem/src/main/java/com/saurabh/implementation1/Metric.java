package com.saurabh.implementation1;

import java.util.Map;

interface Metric {
    void record(Long value);
    MetricSnapshot getSnapShot();
    String getName();
    Map<String, String> getLabels();
}
