package com.saurabh.implementation1;

import java.util.Collection;

public class MetricExporter implements Runnable{
    private final MetricRegistry registry;
    private final MetricSender sender;

    public MetricExporter(MetricRegistry registry, MetricSender sender) {
        this.registry = registry;
        this.sender = sender;
    }

    @Override
    public void run() {
        Collection<MetricSnapshot> snapshots = registry.snapshotAll();
        sender.send(snapshots);
    }
}
