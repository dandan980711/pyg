package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbTypeTemplate;
import entity.PageResult;

/**
 * Created by admin on 2018/9/6.
 */
public interface TemplateService {
    PageResult findPage(int page, int rows, TbTypeTemplate tbTypeTemplate);
}
