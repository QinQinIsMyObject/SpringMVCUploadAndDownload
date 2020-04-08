/**
 * 
 */
package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Shieh
 * @Date 2020-04-08 11:12:33
 * @Description
 *
 */
@Controller
public class FileOpController {

	@RequestMapping("/toIndex.do")
	public String toIndex() {
		return "index";
	}

//	@RequestMapping("/doUpload.do")
//	// 文件上传
//	// 注意：参数里面要有MultipartFile这个参数且file名称要和表单的name属性值保持一致
//	public ModelAndView fileUploadMethod(MultipartFile file, HttpServletRequest request) {
//		return null;
//	}
}
