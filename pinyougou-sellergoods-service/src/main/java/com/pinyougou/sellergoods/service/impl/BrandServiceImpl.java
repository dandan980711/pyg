package com.pinyougou.sellergoods.service.impl;

import java.util.Date;
import java.util.List;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.pinyougou.pojo.TbBrandExample;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;

import entity.PageResult;
@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private TbBrandMapper brandMapper;
	
	@Override
	public List<TbBrand> findAll() {
		return brandMapper.selectByExample(null);
	}

	@Override
	public PageResult findPage(int page, int rows,TbBrand brand) {
		PageHelper.startPage(page,rows);
		if(brand!=null){
			TbBrandExample tbBrandExample = new TbBrandExample();
			if(brand.getName()!=null && !"".equals(brand.getName())){

				TbBrandExample.Criteria criteria = tbBrandExample.createCriteria();

				criteria.andNameLike("%"+brand.getName()+"%");

			}
			Page<TbBrand> tbBrands = (Page<TbBrand>) brandMapper.selectByExample(tbBrandExample);
			return new PageResult(tbBrands.getTotal(),tbBrands.getResult());

		}else{
			Page<TbBrand> tbBrands = (Page<TbBrand>) brandMapper.selectByExample(null);
			return new PageResult(tbBrands.getTotal(),tbBrands.getResult());
		}


	}

	@Override
	public void addBrand(TbBrand brand) {
		brand.setId(new Date().getTime());
		brandMapper.insert(brand);
	}

	@Override
	public TbBrand selectBrand(String id) {
		return brandMapper.selectByPrimaryKey(Long.valueOf(id));
	}

	@Override
	public void updateBrand(TbBrand brand) {
		brandMapper.updateByPrimaryKey(brand);
	}

	@Override
	public void delAllBrand(String ids) {
		brandMapper.delAllBrand(ids);
	}

}
