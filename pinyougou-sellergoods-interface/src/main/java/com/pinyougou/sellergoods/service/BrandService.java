package com.pinyougou.sellergoods.service;

import java.util.List;
import java.util.TreeMap;

import com.pinyougou.pojo.TbBrand;

import entity.PageResult;

/**
 * 
 * <pre>项目名称：pinyougou-sellergoods-interface    
 * 类名称：BrandService    
 * 类描述：    品牌
 * 创建人：杨志超 yangzhichao150@126.com    
 * 创建时间：2018年9月4日 下午3:49:11    
 * 修改人：杨志超 yangzhichao150@126.com     
 * 修改时间：2018年9月4日 下午3:49:11    
 * 修改备注：       
 * @version </pre>
 */
public interface BrandService {

	/**
	 * <pre>findAll(这里用一句话描述这个方法的作用)   
	 * 创建人：杨志超 yangzhichao150@126.com    
	 * 创建时间：2018年9月4日 下午3:50:10    
	 * 修改人：杨志超 yangzhichao150@126.com     
	 * 修改时间：2018年9月4日 下午3:50:10    
	 * 修改备注： 品牌列表查询
	 * @return</pre>
	 */
	public List<TbBrand> findAll();
	
	/**
	 * <pre>findPage(品牌分页查询)   
	 * 创建人：杨志超 yangzhichao150@126.com    
	 * 创建时间：2018年9月4日 下午5:22:26    
	 * 修改人：杨志超 yangzhichao150@126.com     
	 * 修改时间：2018年9月4日 下午5:22:26    
	 * 修改备注： 
	 * @param page
	 * @param rows
	 * @return</pre>
	 */
	public PageResult findPage(int page, int rows,TbBrand brand);

	public void addBrand(TbBrand brand);

	public TbBrand selectBrand(String id);

	public void updateBrand(TbBrand brand);

	public void delAllBrand(String ids);
}
