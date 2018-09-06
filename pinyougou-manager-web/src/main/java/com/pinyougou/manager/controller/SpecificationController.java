package com.pinyougou.manager.controller;/**
 * Created by wangyanci on 2018/9/5.
 */

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.sellergoods.service.SpecificationService;
import entity.PageResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * &lt;pre&gt;项目名称：
 * 类名称：规格controller
 * 类描述：
 * 创建人：王晏赐
 * 创建时间：
 * 修改人：王晏赐
 * 修改时间：
 * 修改备注：
 *
 * @version &lt;/pre&gt;
 */
@RestController
@RequestMapping("/specification")
public class SpecificationController {

    @Reference
    private SpecificationService specificationService;

    /**
     * 查询规格列表
     * @return
     */
    @RequestMapping("/findPage")
    public PageResult findPage(int page, int rows, TbSpecification specification){
        return specificationService.findPage(page,rows,specification);
    }

    /**
     * 新增
     * @param specification
     * @return
     */
    @RequestMapping("/saveSpecification")
    public String saveSpecification(@RequestBody TbSpecification specification){

        if(specification.getId()!=null){
            specificationService.updateSpecification(specification);
        }else{
            specificationService.saveSpecification(specification);
        }
        return "1";
    }

    /**
     * 删除
     * @return
     */
    @RequestMapping("/delSpecifica")
    public String delSpecifica(String ids){
        specificationService.delSpecifica(ids);
        return "1";
    }

    /**
     * 回显
     */
    @RequestMapping("/selectOneSp")
    public TbSpecification selectOneSp(String id){
        return specificationService.selectOneSp(id);
    }

}
