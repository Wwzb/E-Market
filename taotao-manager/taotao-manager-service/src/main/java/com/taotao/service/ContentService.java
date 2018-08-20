package com.taotao.service;

import org.springframework.web.bind.annotation.RequestParam;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;

public interface ContentService {
	
	TaotaoResult insertContent(TbContent content);
    // 更新内容方法
    TaotaoResult updateContent(TbContent content);

    // 内容管理列表查询
    EUDataGridResult getContentList(long categoryId, Integer page, Integer rows);

    //删除内容
    TaotaoResult deleteContent(@RequestParam("ids") long[] itemId);
}
