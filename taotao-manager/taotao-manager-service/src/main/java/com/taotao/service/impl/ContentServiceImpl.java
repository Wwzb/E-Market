package com.taotao.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.EUTreeNode;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbContentExample;
import com.taotao.pojo.TbContentExample.Criteria;
@Service
public class ContentServiceImpl implements com.taotao.service.ContentService {
	
	@Autowired
	private TbContentMapper contentMapper;
	@Override
	public TaotaoResult insertContent(TbContent content) {
		//补全pojo内容
		content.setCreated(new Date());
		content.setUpdated(new Date());
		contentMapper.insert(content);
		
		return TaotaoResult.ok();
	}
	
	@Override
	public TaotaoResult updateContent(TbContent content) {
        // 将内容数据插入到内容表
        content.setCreated(new Date());
        content.setUpdated(new Date());
        // 插入到数据库
        contentMapper.updateByPrimaryKey(content);
        return TaotaoResult.ok();
	}
	@Override
	public EUDataGridResult getContentList(long catId, Integer page, Integer rows) {
		//根据category_id查询内容列表
		TbContentExample example = new TbContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(catId);
		//分页处理
		PageHelper.startPage(page, rows);
		List<TbContent> list = contentMapper.selectByExampleWithBLOBs(example);
		//取分页信息
		PageInfo<TbContent> pageInfo = new PageInfo<>(list);
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public TaotaoResult deleteContent(long[] itemId) {
	       for (long l : itemId) {
	    	   contentMapper.deleteByPrimaryKey(l);
	        }
	        return TaotaoResult.ok();	
	}

}
