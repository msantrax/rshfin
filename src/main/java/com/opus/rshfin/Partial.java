package com.opus.rshfin;

import javax.persistence.*;

@Entity
@Table(name = "PARTIALS")
public class Partial {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ROOTUID", nullable = false)
    private Header rootuid;

    @Column(name = "CREATED", nullable = false, length = 2000000000)
    private String created;

    @Column(name = "PLOAD", nullable = false)
    private Double pload;

    @Column(name = "PEXPAND", nullable = false)
    private Double pexpand;

    @Column(name = "DENSITY", nullable = false)
    private Double density;

    @Column(name = "TEMP", nullable = false)
    private Double temp;

    @Column(name = "VOLUME", nullable = false)
    private Double volume;

    @Column(name = "QUALITY", nullable = false, length = 2000000000)
    private String quality;

    @Column(name = "INCLUDED", nullable = false)
    private Integer included;

    @Column(name = "ELAPSED_LOAD", nullable = false)
    private Integer elapsedLoad;

    @Column(name = "ELAPSED_EXP", nullable = false)
    private Integer elapsedExp;

    @Column(name = "RSDSTATUS", nullable = false, length = 2000000000)
    private String rsdstatus;

    @Column(name = "CYCLE_RSD", nullable = false)
    private Double cycleRsd;

    @Column(name = "CYCLE_AVG", nullable = false)
    private Double cycleAvg;

    @Column(name = "CYCLE_INIT", nullable = false)
    private Integer cycleInit;

    @Column(name = "CYCLE_END", nullable = false)
    private Integer cycleEnd;

    public Integer getCycleEnd() {
        return cycleEnd;
    }

    public void setCycleEnd(Integer cycleEnd) {
        this.cycleEnd = cycleEnd;
    }

    public Integer getCycleInit() {
        return cycleInit;
    }

    public void setCycleInit(Integer cycleInit) {
        this.cycleInit = cycleInit;
    }

    public Double getCycleAvg() {
        return cycleAvg;
    }

    public void setCycleAvg(Double cycleAvg) {
        this.cycleAvg = cycleAvg;
    }

    public Double getCycleRsd() {
        return cycleRsd;
    }

    public void setCycleRsd(Double cycleRsd) {
        this.cycleRsd = cycleRsd;
    }

    public String getRsdstatus() {
        return rsdstatus;
    }

    public void setRsdstatus(String rsdstatus) {
        this.rsdstatus = rsdstatus;
    }

    public Integer getElapsedExp() {
        return elapsedExp;
    }

    public void setElapsedExp(Integer elapsedExp) {
        this.elapsedExp = elapsedExp;
    }

    public Integer getElapsedLoad() {
        return elapsedLoad;
    }

    public void setElapsedLoad(Integer elapsedLoad) {
        this.elapsedLoad = elapsedLoad;
    }

    public Integer getIncluded() {
        return included;
    }

    public void setIncluded(Integer included) {
        this.included = included;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Double getDensity() {
        return density;
    }

    public void setDensity(Double density) {
        this.density = density;
    }

    public Double getPexpand() {
        return pexpand;
    }

    public void setPexpand(Double pexpand) {
        this.pexpand = pexpand;
    }

    public Double getPload() {
        return pload;
    }

    public void setPload(Double pload) {
        this.pload = pload;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public Header getRootuid() {
        return rootuid;
    }

    public void setRootuid(Header rootuid) {
        this.rootuid = rootuid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}