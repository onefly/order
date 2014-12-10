package com.qianqian.common.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.framelib.common.CommonConstants;
import com.framelib.dfs.FastDFSUtil;
import com.qianqian.common.utils.EditUploadConstants;
import com.qianqian.report.util.JSONMsgUtil;

/**
 * Title:UploadServletController
 * 产品详情页图片上传
 * @Description:
 * @Create_by:shensheng
 * @Create_date:2014-7-7
 * @Last_Edit_By:
 * @Edit_Description:
 * @version:manager.maxtp 1.0
 */
public class UploadServletController extends HttpServlet {
	
	private Logger log = LoggerFactory.getLogger(UploadServletController.class);

	private static final long serialVersionUID = 1L;
	
	private static final ResourceBundle res = ResourceBundle.getBundle(EditUploadConstants.IMG_CONFIG_PATH);
	
	private static final String imagePath = CommonConstants.IMAGE_PATH;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		setResponseParam(response);
		PrintWriter out = response.getWriter();
		// 定义允许上传的文件扩展名
		HashMap<String, String> extMap = new HashMap<String, String>();
		extMap.put("image", EditUploadConstants.IMAGE_TYPE);
		extMap.put("flash", EditUploadConstants.FLASH_TYPE);
		extMap.put("media", EditUploadConstants.MEDIA_TYPE);
		extMap.put("file", EditUploadConstants.FILE_TYPE);
		if (!ServletFileUpload.isMultipartContent(request)) {
			out.println(res.getString("m.selectFile"));
			return;
		}
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("UTF-8");
		List items;
		try {
			items = upload.parseRequest(request);
			Iterator itr = items.iterator();
			while (itr.hasNext()) {
				FileItem item = (FileItem) itr.next();
				String fileName = item.getName();
				long fileSize = item.getSize();
				if (!item.isFormField()) {
					// 检查文件大小
					if (item.getSize() > EditUploadConstants.MAX_SIZE) {
						out.println(JSONMsgUtil.getError(res.getString("m.maxSize")));
						return;
					}
					// 检查扩展名
					String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
					String image = "image";	//上传图片文件的类型
					if (!Arrays.<String> asList(extMap.get(image).split(","))
							.contains(fileExt)) {
						out.println(JSONMsgUtil.getError(res.getString("m.ext")));
						return;
					}
//					SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
//					String newFileName = df.format(new Date()) + "_"
//							+ new Random().nextInt(1000) + "." + fileExt;
					String url = "";	//上传路径
					String[] urls = FastDFSUtil.uploadFromStream(item.getInputStream(), fileSize, fileExt, null);
					url = urls[0]+"/"+urls[1];
//						File uploadedFile = new File(savePath, newFileName);
//						item.write(uploadedFile);
					JSONObject obj = new JSONObject();
					obj.put("error", 0);
					obj.put("url", imagePath+"/"+url);
					
					log.info("图片路径为："+imagePath+"/"+url);
					
					out.println(obj);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			out.println(JSONMsgUtil.getError(res.getString("m.failed")));
		} finally {
			if (out != null) {
				out.flush();
				out.close();
			}
		}
	}

	/**
	 * 设置response参数
	 * @Create_by:shensheng
	 * @Create_date:2014-7-7
	 * @param response
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:manager.maxtp 1.0
	 */
	private void setResponseParam(HttpServletResponse response) {
		response.setContentType("text/html; charset=UTF-8");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
	}
}
