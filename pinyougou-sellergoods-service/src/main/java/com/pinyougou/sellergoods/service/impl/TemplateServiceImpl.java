package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbTypeTemplateMapper;
import com.pinyougou.pojo.TbTypeTemplate;
import com.pinyougou.pojo.TbTypeTemplateExample;
import com.pinyougou.sellergoods.service.TemplateService;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * Created by admin on 2018/9/6.
 */
@Service
public class TemplateServiceImpl implements TemplateService{
    @Autowired
    private TbTypeTemplateMapper tbTypeTemplateMapper;


    @Override
    public PageResult findPage(int page, int rows, TbTypeTemplate tbTypeTemplate) {

        PageHelper.startPage(page,rows);

        TbTypeTemplateExample tbTypeTemplateExample = new TbTypeTemplateExample();

        if(tbTypeTemplate!=null){
            if(tbTypeTemplate.getName()!=null && !"".equals(tbTypeTemplate.getName())){
                TbTypeTemplateExample.Criteria criteria = tbTypeTemplateExample.createCriteria();
                criteria.andNameLike("%"+tbTypeTemplate.getName()+"%");
            }
            Page<TbTypeTemplate> p = (Page<TbTypeTemplate>) tbTypeTemplateMapper.selectByExample(tbTypeTemplateExample);

            return new PageResult(p.getTotal(),p.getResult());
        }

        Page<TbTypeTemplate> p = (Page<TbTypeTemplate>) tbTypeTemplateMapper.selectByExample(null);

        return new PageResult(p.getTotal(),p.getResult());
    }
}
