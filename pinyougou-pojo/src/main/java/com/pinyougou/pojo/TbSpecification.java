package com.pinyougou.pojo;

import java.io.Serializable;
import java.util.List;

public class TbSpecification implements Serializable{

    private static final long serialVersionUID = 1688071031543855088L;

    private Long id;

    private String specName;

    private List<TbSpecificationOption> specificationOptionList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName == null ? null : specName.trim();
    }

    public List<TbSpecificationOption> getSpecificationOptionList() {
        return specificationOptionList;
    }

    public void setSpecificationOptionList(List<TbSpecificationOption> specificationOptionList) {
        this.specificationOptionList = specificationOptionList;
    }
}