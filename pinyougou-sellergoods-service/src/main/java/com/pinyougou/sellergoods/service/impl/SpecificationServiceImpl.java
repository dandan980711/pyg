package com.pinyougou.sellergoods.service.impl;/**
 * Created by wangyanci on 2018/9/5.
 */

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbSpecificationMapper;
import com.pinyougou.mapper.TbSpecificationOptionMapper;
import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.pojo.TbSpecificationExample;
import com.pinyougou.pojo.TbSpecificationOption;
import com.pinyougou.sellergoods.service.SpecificationService;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * &lt;pre&gt;项目名称：
 * 类名称：
 * 类描述：
 * 创建人：王晏赐
 * 创建时间：
 * 修改人：王晏赐
 * 修改时间：
 * 修改备注：
 *
 * @version &lt;/pre&gt;
 */
@Service
public class SpecificationServiceImpl implements SpecificationService{

    @Autowired
    private TbSpecificationMapper tbSpecificationMapper;

    @Autowired
    private TbSpecificationOptionMapper tbSpecificationOptionMapper;

    @Override
    public PageResult findPage(int page, int rows,TbSpecification specification) {

        PageHelper.startPage(page,rows);

        TbSpecificationExample tbSpecificationExample = new TbSpecificationExample();

        if(specification!=null){
            if(specification.getSpecName()!=null && !"".equals(specification.getSpecName())){
                TbSpecificationExample.Criteria criteria = tbSpecificationExample.createCriteria();
                criteria.andSpecNameLike("%"+specification.getSpecName()+"%");
            }
            Page<TbSpecification> p = (Page<TbSpecification>) tbSpecificationMapper.selectByExample(tbSpecificationExample);

            return new PageResult(p.getTotal(),p.getResult());
        }

        Page<TbSpecification> p = (Page<TbSpecification>) tbSpecificationMapper.selectByExample(null);

        return new PageResult(p.getTotal(),p.getResult());
    }

    /**
     * 新增
     * @param specification
     */
    public void saveSpecification(TbSpecification specification) {

        long time = new Date().getTime();

        specification.setId(time);
        tbSpecificationMapper.insert(specification);

        saveSpecificationOption(specification.getSpecificationOptionList(),time);
    }

    /**
     * 删除
     * @param ids
     */
    public void delSpecifica(String ids) {
        String[] split = ids.split(",");

        for (int i = 0; i<split.length;i++){
            tbSpecificationMapper.deleteByPrimaryKey(Long.valueOf(split[i]));
            tbSpecificationOptionMapper.deleteSp(Long.valueOf(split[i]));
        }
    }

    /**
     * 回显
     * @param id
     * @return
     */
    public TbSpecification selectOneSp(String id) {
        TbSpecification tbSpecification = tbSpecificationMapper.selectByPrimaryKey(Long.valueOf(id));

        List<TbSpecificationOption> list = tbSpecificationOptionMapper.selectSpOp(id);

        tbSpecification.setSpecificationOptionList(list);

        return tbSpecification;
    }

    /**
     * 修改
     * @param specification
     */
    public void updateSpecification(TbSpecification specification) {
        //修改
        tbSpecificationMapper.updateByPrimaryKey(specification);
        //删除
        tbSpecificationOptionMapper.deleteSp(specification.getId());
        //新增尺码
        saveSpecificationOption(specification.getSpecificationOptionList(),specification.getId());
    }

    /**
     * 新增尺码
     * @param list
     * @param id
     */
    public void saveSpecificationOption(List<TbSpecificationOption> list,Long id){
        for (int i = 0; i<list.size();i++){
            TbSpecificationOption tbSpecificationOption = list.get(i);
            tbSpecificationOption.setSpecId(id);
            tbSpecificationOptionMapper.insert(tbSpecificationOption);
        }
    }


}
