package com.gao.sukangcollect.service;

import com.gao.sukangcollect.domain.StuInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * ClassName: MailService
 * Description:
 * date: 2020/6/26 14:31
 *
 * @author gaoxi
 * @since JDK 1.8
 */
@Service
public class MailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;


    @Async
    public void amMailSender(StuInfo stu){
        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setFrom(sender);
        mailMessage.setCc(sender);
        mailMessage.setTo(stu.getQqMail());
        mailMessage.setSubject("苏康码上午打卡提醒");
        mailMessage.setText("上午好,"+stu.getStuName()+"，记得打卡,这次打卡不用提交！！");
        try {
            javaMailSender.send(mailMessage);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("发送简单邮件失败"+stu.getStuName());
        }
    }

    @Async
    public void pmMailSender(StuInfo stu)
    {
        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setFrom(sender);
        mailMessage.setCc(sender);
        mailMessage.setTo(stu.getQqMail());
        mailMessage.setSubject("苏康码下午打卡提醒");
        mailMessage.setText("下午好,"+stu.getStuName()+"，记得打卡、交码哟！！ "+"上传地址："+"http://39.107.250.200:16105/");
        try {
            javaMailSender.send(mailMessage);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("发送简单邮件失败"+stu.getStuName());
        }
    }

    @Async
    public void lastMailSender(StuInfo stu){
        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setFrom(sender);
        mailMessage.setCc(sender);
        mailMessage.setTo(stu.getQqMail());
        mailMessage.setSubject("苏康码未交提醒");
        mailMessage.setText("请赶快提交苏康码！！");
        try {
            javaMailSender.send(mailMessage);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("发送简单邮件失败"+stu.getStuName());
        }
    }
}
