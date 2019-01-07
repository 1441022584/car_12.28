package com.jk.car.model;

import java.io.Serializable;

public class ParamsBean implements Serializable {

    private static final long serialVersionUID = -5202135651965084335L;

    private Integer id;

    private String name;

    private String codetype;

    private Integer codeid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCodetype() {
        return codetype;
    }

    public void setCodetype(String codetype) {
        this.codetype = codetype == null ? null : codetype.trim();
    }

    public Integer getCodeid() {
        return codeid;
    }

    public void setCodeid(Integer codeid) {
        this.codeid = codeid;
    }
}