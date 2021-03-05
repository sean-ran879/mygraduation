package com.zxr.mygraduation.controller;
import com.alibaba.fastjson.JSONArray;
import com.zxr.mygraduation.entity.UserInfo;
import com.zxr.mygraduation.model.Result;
import com.zxr.mygraduation.service.IUserInfoService;
import com.zxr.mygraduation.service.impl.UserInfoServiceImpl;
import com.zxr.mygraduation.tool.Base64Util;
import com.zxr.mygraduation.tool.FaceApi;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.*;
import java.util.Iterator;
import static com.zxr.mygraduation.tool.ApiOrcUtil.getPictureString;
/**
 * 图片上传
 *
 * @author FanChen
 * @since 2018年6月1日 上午12:46:29
 */
@RestController
@Controller
@RequestMapping("/upload")
public class UploadController {
    @Autowired
    private IUserInfoService userInfoServiceImpl=new UserInfoServiceImpl();
    private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
    private final static int TX_APP_ID = 2131046444;
    public final static String TX_APP_KEY = "aAScNqBOCIYk5iAq";
    private final static String TX_ORCURL = "https://api.ai.qq.com/fcgi-bin/ocr/ocr_idcardocr";
    @RequestMapping("/picture")
    @ApiOperation(value = "获取身份证信息", notes = "获取身份证信息")
    public String uploadPicture(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Result result = new Result();
        String zmUrl = "";
        String photoType = request.getParameter("photoType");
        Integer userId = Integer.parseInt(request.getParameter("userId"));
        System.out.println("上传的用户id为" + userId);
        //获取文件需要上传到的路径
        File directory = new File("..");
        String path = directory.getCanonicalPath() + "\\upload\\";
        // 判断存放上传文件的目录是否存在（不存在则创建）
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdir();
        }
        logger.debug("path=" + path);
        request.setCharacterEncoding("utf-8");
        JSONArray jsonArray = new JSONArray();
        try {
            StandardMultipartHttpServletRequest req = (StandardMultipartHttpServletRequest) request;
            Iterator<String> iterator = req.getFileNames();
            while (iterator.hasNext()) {
                HashMap<String, Object> res = new HashMap<String, Object>();
                MultipartFile file = req.getFile(iterator.next());
                // 获取文件名
                String fileNames = file.getOriginalFilename();
                int split = fileNames.lastIndexOf(".");
                //获取上传文件的后缀
                String extName = fileNames.substring(split + 1, fileNames.length());
                //申明UUID
                String uuid = UUID.randomUUID().toString().replace("-", "");
                //组成新的图片名称
                String newName = uuid + "." + extName;
                System.out.println(newName);
                String destPath = path + newName;
                logger.debug("destPath=" + destPath);
                //真正写到磁盘上
                File file1 = new File(destPath);
                OutputStream out = new FileOutputStream(file1);
                out.write(file.getBytes());
                res.put("url", destPath);
                zmUrl = destPath;
                jsonArray.add(res);
                out.close();
            }
        } catch (Exception e) {
            logger.error("", e);
        }
        result.setValue(jsonArray);
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        String ob=getPictureString(zmUrl);
        UserInfo userInfo=new UserInfo();
        userInfo.setCardFrontPhoto(zmUrl);
        userInfo.setUserId(userId);
        userInfoServiceImpl.updatePhoto(userInfo);
        System.out.println(ob);
        return ob;
    }
    @RequestMapping("/picture1")
    @ApiOperation(value = "获取身份证信息", notes = "获取身份证信息")
    public String uploadPicture1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Result result = new Result();
        String prePhoto = "";
        Integer userId = Integer.parseInt(request.getParameter("userId"));
        System.out.println("上传的用户id为" + userId);
        //获取文件需要上传到的路径
        File directory = new File("..");
        String path = directory.getCanonicalPath() + "\\upload\\";
        // 判断存放上传文件的目录是否存在（不存在则创建）
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdir();
        }
        logger.debug("path=" + path);
        request.setCharacterEncoding("utf-8");
        JSONArray jsonArray = new JSONArray();
        try {
            StandardMultipartHttpServletRequest req1 = (StandardMultipartHttpServletRequest) request;
            Iterator<String> iterator1 = req1.getFileNames();
            while (iterator1.hasNext()) {
                HashMap<String, Object> res = new HashMap<String, Object>();
                MultipartFile file = req1.getFile(iterator1.next());
                // 获取文件名
                String fileNames = file.getOriginalFilename();
                int split = fileNames.lastIndexOf(".");
                //获取上传文件的后缀
                String extName = fileNames.substring(split + 1, fileNames.length());
                //申明UUID
                String uuid = UUID.randomUUID().toString().replace("-", "");
                //组成新的图片名称
                String newName = uuid + "." + extName;
                System.out.println(newName);
                String destPath = path + newName;
                logger.debug("destPath=" + destPath);
                //真正写到磁盘上
                File file1 = new File(destPath);
                OutputStream out = new FileOutputStream(file1);
                out.write(file.getBytes());
                res.put("url", destPath);
                prePhoto = destPath;
                jsonArray.add(res);
                out.close();
            }
        } catch (Exception e) {
            logger.error("", e);
        }
        result.setValue(jsonArray);
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        UserInfo us = new UserInfo();
        us.setPrePhoto(prePhoto);
        us.setUserId(userId);
        UserInfo uf=new UserInfo();
        uf=userInfoServiceImpl.getByUserId(userId);
        String ob= FaceApi.faceMatch(uf.getPrePhoto(),prePhoto);
        System.out.println("插入的数据为" + us);
        userInfoServiceImpl.updateUserPhoto(us);
        return ob;
    }
}
