package com.opus.rshfin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HEADER")
public class Header {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "CREATED", nullable = false, length = 2000000000)
    private String created;

    @Column(name = "SID", nullable = false, length = 2000000000)
    private String sid;

    @Column(name = "TYPE", nullable = false, length = 2000000000)
    private String type;

    @Column(name = "LOTE", nullable = false, length = 2000000000)
    private String lote;

    @Column(name = "OWNER", nullable = false, length = 2000000000)
    private String owner;

    @Column(name = "DENSITY", nullable = false)
    private Double density;

    @Column(name = "TEMP", nullable = false)
    private Double temp;

    @Column(name = "VOLUME", nullable = false)
    private Double volume;

    @Column(name = "LRSD", nullable = false)
    private Double lrsd;

    @Column(name = "MASS", nullable = false)
    private Double mass;

    @Column(name = "VARIANCE", nullable = false, length = 2000000000)
    private String variance;

    @Column(name = "CELL", nullable = false, length = 2000000000)
    private String cell;

    @Column(name = "VADDEDUID", nullable = false)
    private Integer vaddeduid;

    @Column(name = "VCELLID", nullable = false)
    private Integer vcellid;

    @Column(name = "VALIDUID", nullable = false)
    private Integer validuid;

    public Integer getValiduid() {
        return validuid;
    }

    public void setValiduid(Integer validuid) {
        this.validuid = validuid;
    }

    public Integer getVcellid() {
        return vcellid;
    }

    public void setVcellid(Integer vcellid) {
        this.vcellid = vcellid;
    }

    public Integer getVaddeduid() {
        return vaddeduid;
    }

    public void setVaddeduid(Integer vaddeduid) {
        this.vaddeduid = vaddeduid;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getVariance() {
        return variance;
    }

    public void setVariance(String variance) {
        this.variance = variance;
    }

    public Double getMass() {
        return mass;
    }

    public void setMass(Double mass) {
        this.mass = mass;
    }

    public Double getLrsd() {
        return lrsd;
    }

    public void setLrsd(Double lrsd) {
        this.lrsd = lrsd;
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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}