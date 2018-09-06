package com.pinyougou.manager.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;

import entity.PageResult;

@RestController
@RequestMapping("/brand")
public class BrandController {

	@Reference
	private BrandService brandService;
	
	@RequestMapping("/findAll")
	public List<TbBrand> findAll() {
		return brandService.findAll();
	}
	
	@RequestMapping("/findPage")
	public PageResult findPage(int page, int rows,TbBrand brand) {
		return brandService.findPage(page, rows,brand);
	}

	/**
	 * 新增
	 * @param brand
	 * @return
     */
	@RequestMapping("/addBrand")
	public String addBrand(TbBrand brand){
		if(brand.getId()==null) {brandService.addBrand(brand);}
		else{brandService.updateBrand(brand);}
		return "1";
	}


	/**
	 * 修改回显
	 * @param id
	 * @return
     */
	@RequestMapping("/selectBrand")
	public TbBrand selectBrand(String id){
		return brandService.selectBrand(id);
	}

	/**
	 * 删除
	 * @param ids
	 * @return
     */
	@RequestMapping("/delAllBrand")
	public String delAllBrand(String ids){
		brandService.delAllBrand(ids);
		return "1";
	}

}
