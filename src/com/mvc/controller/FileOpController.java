/**
 * 
 */
package com.mvc.controller;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

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

	@RequestMapping("/doUpload.do")
	// 文件上传
	// 注意：参数里面要有MultipartFile这个参数且file名称要和表单的name属性值保持一致
	public ModelAndView fileUploadMethod(MultipartFile file, HttpServletRequest request) throws Exception {
		// 1、获得文件名称；
		String fname = file.getOriginalFilename();
		// 2、对文件进行处理(例如生成随机文件名)
		// a.获取文件的后缀名
		String txt = FilenameUtils.getExtension(fname);
		// b.使用UUID生成随机文件名--推荐，可以接近全球唯一
//		String docmString=System.currentTimeMillis()+"."+docm;
		String docm = UUID.randomUUID() + "." + txt;
		System.out.println(docm);
		// 3、获得文件保存的路径；
		String docmSavePath = "E:/Workspace/Spring Tool Suite/SpringMVCUploadAndDownload/WebContent/WEB-INF/upload";
		System.out.println(docmSavePath);
		// 4、构建文件file对象；
		File fi = new File(docmSavePath, docm);
		// 5、通过工具类实现文件上传。
		FileUtils.copyInputStreamToFile(file.getInputStream(), fi);
		return new ModelAndView("index");
	}
}
