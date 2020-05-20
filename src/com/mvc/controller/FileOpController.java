package com.mvc.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Shieh
 * @Date 2020-04-08 11:12:33
 * @Description 上传和下载
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
		// 3、获得文件保存的路径
		String docmSavePath = "E:/Workspace/SpringToolSuite/SpringMVCUploadAndDownload/WebContent/WEB-INF/upload/";
		System.out.println(docmSavePath);
		// 4、构建文件file对象；
		File fi = new File(docmSavePath, docm);
		// 5、通过工具类实现文件上传。
		FileUtils.copyInputStreamToFile(file.getInputStream(), fi);
		return new ModelAndView("index");
	}

	// 文件下载
	@RequestMapping("/downLoad.do")
	public void downloadMethod(String filename, HttpServletRequest req, HttpServletResponse res) throws IOException {
		// 1、获得文件---改成相对路径；
//		String file = req.getServletContext().getRealPath("/upload/" + filename);
		String file = "E:/Workspace/SpringToolSuite/SpringMVCUploadAndDownload/WebContent/WEB-INF/upload/" + filename;
		// 2、根据文件构建一个文件输入流；
		FileInputStream fis = new FileInputStream(file);
		// 3、中文乱码处理；
		filename = new String(filename.getBytes("UTF-8"), "ISO-8859-1");
		// 4、设置响应信息；
		res.setHeader("content-disposition", "attchment;filename=" + filename);// 设置响应头
		res.setContentType("application/octet-stream");// 设置内容响应
		res.setContentLength(fis.available());// 设置内容大小
		// 5、构建一个缓冲区；
		byte[] by = new byte[2048];// 单位是字节
		// 6、循环的读写；
		int len = 0;
		while ((len = fis.read(by)) != -1) {
			res.getOutputStream().write(by, 0, len);// 写的操作
		}
		// 7、刷新；
		res.getOutputStream().flush();
		// 8、关闭资源。
		res.getOutputStream().close();
		fis.close();
	}

}
