package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbSpecification;
import entity.PageResult;

/**
 * Created by wangyanci on 2018/9/5.
 */
public interface SpecificationService {
    PageResult findPage(int page, int rows,TbSpecification specification);

    void saveSpecification(TbSpecification specification);

    void delSpecifica(String ids);

    TbSpecification selectOneSp(String id);

    void updateSpecification(TbSpecification specification);
}
