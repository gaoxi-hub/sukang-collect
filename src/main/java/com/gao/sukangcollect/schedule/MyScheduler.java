package com.gao.sukangcollect.schedule;

import com.gao.sukangcollect.domain.StuInfo;
import com.gao.sukangcollect.mapper.StuInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName: MyScheduler
 * Description:
 * date: 2020/6/25 21:43
 *
 * @author gaoxi
 * @since JDK 1.8
 */
@Component
public class MyScheduler {
    @Resource
    private StuInfoMapper stuInfoMapper;
    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String sender;
    @Scheduled(cron = "0 0 1 * * ?")
    public void clearSubmitTime(){
        stuInfoMapper.updateAllSubmitTime();
    }


    @Async
    @Scheduled(cron = "0 0 9 * * ?")
    public void amRemind(){
        List<StuInfo> stuInfos = stuInfoMapper.selectStuQqEamil();
        for(StuInfo stu:stuInfos)
        {
            SimpleMailMessage mailMessage=new SimpleMailMessage();
            mailMessage.setFrom(sender);
            mailMessage.setTo(stu.getQqMail());
            mailMessage.setSubject("苏康码上午打卡提醒");
            mailMessage.setText("上午好,"+stu.getStuName()+"，记得打卡！！");
            try {
                javaMailSender.send(mailMessage);
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("发送简单邮件失败"+stu.getStuName());
            }
        }
    }


    @Async
    @Scheduled(cron = "0 0 14 * * ?")
    public void pmRemind(){
        List<StuInfo> stuInfos = stuInfoMapper.selectStuQqEamil();
        for(StuInfo stu:stuInfos)
        {
            SimpleMailMessage mailMessage=new SimpleMailMessage();
            mailMessage.setFrom(sender);
            mailMessage.setTo(stu.getQqMail());
            mailMessage.setSubject("苏康码下午打卡提醒");
            mailMessage.setText("下午好,"+stu.getStuName()+"，记得打卡、交码哟！！");
            try {
                javaMailSender.send(mailMessage);
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("发送简单邮件失败"+stu.getStuName());
            }
        }
    }


    @Async
    @Scheduled(cron = "0 0 21 * * ?")
    public void lastRemind(){
        List<StuInfo> stuInfos = stuInfoMapper.selectNoSubmitStu();
        for(StuInfo stu:stuInfos)
        {
            SimpleMailMessage mailMessage=new SimpleMailMessage();
            mailMessage.setFrom(sender);
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








}
