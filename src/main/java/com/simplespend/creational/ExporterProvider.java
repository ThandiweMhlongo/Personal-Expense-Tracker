package com.simplespend.creational;

interface Exporter {
    void export();
}

class CSVExporter implements Exporter {
    public void export() { System.out.println("Exporting data to CSV..."); }
}

public abstract class ExporterProvider {
    public abstract Exporter createExporter();
}

class CSVExporterProvider extends ExporterProvider {
    @Override
    public Exporter createExporter() { return new CSVExporter(); }
}
