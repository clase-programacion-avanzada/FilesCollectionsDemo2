package com.company.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public abstract class Content implements Playable, Serializable {


    private static Long nextId = 1L;

    protected Long id;
    protected String name;
    protected Integer duration;
    protected Integer numberOfDownloads;
    protected final Set<Producer> producers;
    public Content(
            String name,
            Integer duration
            ) {
        this.id = nextId++;
        this.name = name;
        this.duration = duration;
        this.numberOfDownloads = 0;
        this.producers = new HashSet<Producer>();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void setNumberOfDownloads(Integer numberOfDownloads) {
        this.numberOfDownloads = numberOfDownloads;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getDuration() {
        return duration;
    }

    public Integer getNumberOfDownloads() {
        return numberOfDownloads;
    }
    public void addProducer(Producer producer) {
        producers.add(producer);
        producer.addContent(this);

    }

    public Set<Producer> getProducers() {
        return producers;
    }

    public void removeProducerById(Long id) {


        producers.removeIf(producer -> producer.getId().equals(id));

    }


}
