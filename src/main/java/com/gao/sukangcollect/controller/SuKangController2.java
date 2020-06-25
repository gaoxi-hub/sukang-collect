package com.gao.sukangcollect.controller;

import com.gao.sukangcollect.domain.StuInfo;
import com.gao.sukangcollect.mapper.StuInfoMapper;
import com.gao.sukangcollect.util.ZipUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * ClassName: SuKangController2
 * Description:
 * date: 2020/6/25 20:49
 *
 * @author gaoxi
 * @since JDK 1.8
 */
public class SuKangController2 {
    @Autowired
    private StuInfoMapper stuInfoMapper;

  /*  @ResponseBody
    @RequestMapping("getSubmitNum1")
    public int getSubmitNum(){
        LocalDate now = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String nowTime = dateTimeFormatter.format(now);
        File file = new File("/home/"+nowTime);
        if(!file.exists()){
            file.mkdir();
            return 0;
        }
        String[] list = file.list();
        return list.length;
    }*/





    /**
     * 提交图片
     */
    @ResponseBody
    @RequestMapping("submitPic1")
    public String submitPic(String stuId, MultipartFile picfile){
        try {
            StuInfo stuInfo = stuInfoMapper.selectStuByStuId(stuId);
            LocalDate now = LocalDate.now();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String nowTime = dateTimeFormatter.format(now);
            File file = new File("/home/"+nowTime);
            if(!file.exists())
            {
                file.mkdir();
            }
            File file1 = new File("/home/" + nowTime + "/" + stuInfo.getStuName().trim() + "-苏康码.jpg");
            picfile.transferTo(file1);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping("download1")
    public void download(HttpServletRequest request, HttpServletResponse response){
        try{
            LocalDate now = LocalDate.now();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String nowTime = dateTimeFormatter.format(now);
            File file = new File("/home/"+nowTime);
            if(!file.exists())
            {
                return;
            }
            response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(nowTime+"班级苏康码.zip", "UTF-8"));
            ZipUtils.toZip(file.getPath(),response.getOutputStream(),true);
        }catch (Exception e){
            e.printStackTrace();
        }
    }











}
