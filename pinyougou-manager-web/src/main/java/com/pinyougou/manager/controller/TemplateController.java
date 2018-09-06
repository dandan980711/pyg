package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbTypeTemplate;
import com.pinyougou.sellergoods.service.TemplateService;
import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;
import entity.PageResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by admin on 2018/9/6.
 */

@RestController
@RequestMapping("/template")
public class TemplateController {
    @Reference
    private TemplateService templateService;

    @RequestMapping("/findPage")
    public PageResult findPage(int page, int rows, TbTypeTemplate tbTypeTemplate){
        return templateService.findPage(page,rows,tbTypeTemplate);
    }


}
