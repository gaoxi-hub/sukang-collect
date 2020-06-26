package com.gao.sukangcollect.schedule;

import com.gao.sukangcollect.domain.StuInfo;
import com.gao.sukangcollect.mapper.StuInfoMapper;
import com.gao.sukangcollect.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private MailService mailService;



    @Scheduled(cron = "0 0 1 * * ?")
    public void clearSubmitTime(){
        stuInfoMapper.updateAllSubmitTime();
    }



    @Scheduled(cron = "0 0 9 * * ?")
    public void amRemind(){
        List<StuInfo> stuInfos = stuInfoMapper.selectStuQqEamil(0);
        if(stuInfos.size()==0) {
            return;
        }
        for(StuInfo stu:stuInfos)
        {
          mailService.amMailSender(stu);
        }
    }

    @Scheduled(cron = "0 10 9 * * ?")
    public void amRemind1(){
        List<StuInfo> stuInfos = stuInfoMapper.selectStuQqEamil(5);
        if(stuInfos.size()==0) {
            return;
        }
        for(StuInfo stu:stuInfos)
        {
            mailService.amMailSender(stu);
        }
    }

    @Scheduled(cron = "0 20 9 * * ?")
    public void amRemind2(){
        List<StuInfo> stuInfos = stuInfoMapper.selectStuQqEamil(10);
        if(stuInfos.size()==0) {
            return;
        }
        for(StuInfo stu:stuInfos)
        {
            mailService.amMailSender(stu);
        }
    }

    @Scheduled(cron = "0 30 9 * * ?")
    public void amRemind3(){
        List<StuInfo> stuInfos = stuInfoMapper.selectStuQqEamil(15);
        if(stuInfos.size()==0) {
            return;
        }
        for(StuInfo stu:stuInfos)
        {
            mailService.amMailSender(stu);
        }
    }

    @Scheduled(cron = "0 40 9 * * ?")
    public void amRemind4(){
        List<StuInfo> stuInfos = stuInfoMapper.selectStuQqEamil(20);
        if(stuInfos.size()==0) {
            return;
        }
        for(StuInfo stu:stuInfos)
        {
            mailService.amMailSender(stu);
        }
    }


    @Scheduled(cron = "0 50 9 * * ?")
    public void amRemind5(){
        List<StuInfo> stuInfos = stuInfoMapper.selectStuQqEamil(25);
        if(stuInfos.size()==0) {
            return;
        }
        for(StuInfo stu:stuInfos)
        {
            mailService.amMailSender(stu);
        }
    }


    @Scheduled(cron = "0 0 10 * * ?")
    public void amRemind6(){
        List<StuInfo> stuInfos = stuInfoMapper.selectStuQqEamil(30);
        if(stuInfos.size()==0) {
            return;
        }
        for(StuInfo stu:stuInfos)
        {
            mailService.amMailSender(stu);
        }
    }


    @Scheduled(cron = "0 10 10 * * ?")
    public void amRemind7(){
        List<StuInfo> stuInfos = stuInfoMapper.selectStuQqEamil(35);
        if(stuInfos.size()==0) {
            return;
        }
        for(StuInfo stu:stuInfos)
        {
            mailService.amMailSender(stu);
        }
    }


    @Scheduled(cron = "0 20 10 * * ?")
    public void amRemind8(){
        List<StuInfo> stuInfos = stuInfoMapper.selectStuQqEamil(40);
        if(stuInfos.size()==0) {
            return;
        }
        for(StuInfo stu:stuInfos)
        {
            mailService.amMailSender(stu);
        }
    }

    @Scheduled(cron = "0 30 10 * * ?")
    public void amRemind9(){
        List<StuInfo> stuInfos = stuInfoMapper.selectStuQqEamil(45);
        if(stuInfos.size()==0) {
            return;
        }
        for(StuInfo stu:stuInfos)
        {
            mailService.amMailSender(stu);
        }
    }




    @Scheduled(cron = "0 0 12 * * ?")
    public void pmRemind(){
        List<StuInfo> stuInfos = stuInfoMapper.selectStuQqEamil(0);
        if(stuInfos.size()==0) {
            return;
        }
        for(StuInfo stu:stuInfos)
        {
            mailService.pmMailSender(stu);
        }
    }


    @Scheduled(cron = "0 10 12 * * ?")
    public void pmRemind1(){
        List<StuInfo> stuInfos = stuInfoMapper.selectStuQqEamil(5);
        if(stuInfos.size()==0) {
            return;
        }
        for(StuInfo stu:stuInfos)
        {
            mailService.pmMailSender(stu);
        }
    }


    @Scheduled(cron = "0 15 12 * * ?")
    public void pmRemind2(){
        List<StuInfo> stuInfos = stuInfoMapper.selectStuQqEamil(10);
        if(stuInfos.size()==0) {
            return;
        }
        for(StuInfo stu:stuInfos)
        {
            mailService.pmMailSender(stu);
        }
    }


    @Scheduled(cron = "0 20 12 * * ?")
    public void pmRemind3(){
        List<StuInfo> stuInfos = stuInfoMapper.selectStuQqEamil(15);
        if(stuInfos.size()==0) {
            return;
        }
        for(StuInfo stu:stuInfos)
        {
            mailService.pmMailSender(stu);
        }
    }


    @Scheduled(cron = "0 0 14 * * ?")
    public void pmRemind4(){
        List<StuInfo> stuInfos = stuInfoMapper.selectStuQqEamil(20);
        if(stuInfos.size()==0) {
            return;
        }
        for(StuInfo stu:stuInfos)
        {
            mailService.pmMailSender(stu);
        }
    }

    @Scheduled(cron = "0 10 14 * * ?")
    public void pmRemind5(){
        List<StuInfo> stuInfos = stuInfoMapper.selectStuQqEamil(25);
        if(stuInfos.size()==0) {
            return;
        }
        for(StuInfo stu:stuInfos)
        {
            mailService.pmMailSender(stu);
        }
    }

    @Scheduled(cron = "0 20 14 * * ?")
    public void pmRemind6(){
        List<StuInfo> stuInfos = stuInfoMapper.selectStuQqEamil(30);
        if(stuInfos.size()==0) {
            return;
        }
        for(StuInfo stu:stuInfos)
        {
            mailService.pmMailSender(stu);
        }
    }

    @Scheduled(cron = "0 30 14 * * ?")
    public void pmRemind7(){
        List<StuInfo> stuInfos = stuInfoMapper.selectStuQqEamil(35);
        if(stuInfos.size()==0) {
            return;
        }
        for(StuInfo stu:stuInfos)
        {
            mailService.pmMailSender(stu);
        }
    }

    @Scheduled(cron = "0 40 14 * * ?")
    public void pmRemind8(){
        List<StuInfo> stuInfos = stuInfoMapper.selectStuQqEamil(40);
        if(stuInfos.size()==0) {
            return;
        }
        for(StuInfo stu:stuInfos)
        {
            mailService.pmMailSender(stu);
        }
    }

    @Scheduled(cron = "0 50 14 * * ?")
    public void pmRemind9(){
        List<StuInfo> stuInfos = stuInfoMapper.selectStuQqEamil(45);
        if(stuInfos.size()==0) {
            return;
        }
        for(StuInfo stu:stuInfos)
        {
            mailService.pmMailSender(stu);
        }
    }


    @Scheduled(cron = "0 0 21 * * ?")
    public void lastRemind(){
        List<StuInfo> stuInfos = stuInfoMapper.selectNoSubmitStuAll();
        if(stuInfos.size()==0){
            return;
        }
        for(StuInfo stu:stuInfos)
        {
           mailService.lastMailSender(stu);
        }
    }
}
