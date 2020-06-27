package com.gao.sukangcollect.controller;

import com.gao.sukangcollect.domain.StuInfo;
import com.gao.sukangcollect.mapper.StuInfoMapper;
import com.gao.sukangcollect.util.ZipUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: SuKangController
 * Description:
 * date: 2020/6/25 13:52
 *
 * @author gaoxi
 * @since JDK 1.8
 */
@Controller
public class SuKangController {
    @Autowired
    private StuInfoMapper stuInfoMapper;

    private List<String> specialStuId= Arrays.asList("20160505133","20160505122");

    @ResponseBody
    @RequestMapping("getSubmitNum")
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
    }
    /**
     * 提交图片
     */
    @ResponseBody
    @RequestMapping("submitPic")
    public String submitPic(String stuId, MultipartFile picfile){
        try {
        StuInfo stuInfo = stuInfoMapper.selectStuByStuId(stuId);
        if(picfile.getSize()<=0){
            return "fail";
        }
        LocalDate now = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String nowTime = dateTimeFormatter.format(now);
        File file = new File("/home/"+nowTime);
        if(!file.exists())
        {
            file.mkdir();
        }
        File file1=null;
        if(specialStuId.contains(stuId)){
             file1 = new File("/home/" + nowTime + "/" + stuId.substring(9)+stuInfo.getStuName().trim() + "-苏康码.jpg");
        }else{
             file1 = new File("/home/" + nowTime + "/" + stuInfo.getStuName().trim() + "-苏康码.jpg");
        }

        picfile.transferTo(file1);
        //更新时间
        stuInfoMapper.updateSubmitTime(stuId);
        return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }


    @RequestMapping("download")
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
            ZipUtils.toZip(file.getPath(),response.getOutputStream(),false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @ResponseBody
    @RequestMapping("getSubmitRecord")
    public List<StuInfo> getSubmitRecord(){
        return stuInfoMapper.selectAllStuInfo();
    }


    @ResponseBody
    @RequestMapping("openOrCloseRemind")
    public String openOrCloseRemind(String stuId){
        try{
            StuInfo stuInfo = stuInfoMapper.selectStuByStuId(stuId);
            if(stuInfo.getOpenReminder()==1){
                stuInfoMapper.updateRemind(stuId,0);
            }else{
                stuInfoMapper.updateRemind(stuId,1);
            }
            return "success";
        }catch(Exception e){
            e.printStackTrace();
            return "fail";
        }
    }



}
