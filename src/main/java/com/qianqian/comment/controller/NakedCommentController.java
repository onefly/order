package com.qianqian.comment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/comment")
public class NakedCommentController {
	private static final Logger log = LoggerFactory.getLogger(NakedCommentController.class);
	
	private static final String NAKED_COMMENT = "comment/nakedComment";
	
	@RequestMapping("/nakedComment")
	public String toNakedComment(){
		
		return NAKED_COMMENT;
	}
}
