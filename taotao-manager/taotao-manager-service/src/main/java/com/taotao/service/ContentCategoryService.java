package com.taotao.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.EUTreeNode;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;

public interface ContentCategoryService {

	List<EUTreeNode> getCategoryList(long parentId);
	TaotaoResult insertContentCategory(long parentId, String name);
    TaotaoResult upadateContentCategory(long id, String name);
    TaotaoResult deleteContentCategory(long id);
}
