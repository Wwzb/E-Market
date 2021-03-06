package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;
import com.taotao.service.ContentService;

@Controller
@RequestMapping("/content")
public class ContentController {
	@Autowired
	private ContentService contentService;
	
	/**
     * 更新内容
     */
    @RequestMapping("/update")
    @ResponseBody
    public TaotaoResult updateContent(TbContent content) {
    	TaotaoResult result = contentService.updateContent(content);
        return result;
    }

    /**
     * 内容管理列表查询
     */
    @RequestMapping("/query/list")
    @ResponseBody
    public EUDataGridResult getContentList(long categoryId, Integer page, Integer rows) {
        EUDataGridResult content = contentService.getContentList(categoryId, page, rows);
        return content;
    }

    /**
     * 删除内容
     */
    @RequestMapping("/delete")
    @ResponseBody
    public TaotaoResult deleteContent(@RequestParam("ids") long[] itemId) {
    	TaotaoResult result = contentService.deleteContent(itemId);
        return result;
    }
    
	@RequestMapping("/save")
	@ResponseBody
	public TaotaoResult insertContent(TbContent content) {
		TaotaoResult result = contentService.insertContent(content);
		return result;
	}

}
