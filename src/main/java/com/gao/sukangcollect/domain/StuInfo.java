package com.gao.sukangcollect.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * ClassName: StuInfo
 * Description:
 * date: 2020/6/25 13:49
 *
 * @author gaoxi
 * @since JDK 1.8
 */
@Data
public class StuInfo {
    private String stuId;
    private String stuName;
    @JsonFormat(pattern = "HH:mm:ss",timezone="GMT+8")
    private Date submitTime;
    private String qqMail;
    private Integer openReminder;
}
