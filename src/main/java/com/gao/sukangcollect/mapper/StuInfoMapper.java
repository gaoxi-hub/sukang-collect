package com.gao.sukangcollect.mapper;

import com.gao.sukangcollect.domain.StuInfo;
import org.springframework.stereotype.Repository;

/**
 * ClassName: StuInfoMapper
 * Description:
 * date: 2020/6/25 13:50
 *
 * @author gaoxi
 * @since JDK 1.8
 */
@Repository
public interface StuInfoMapper {
    StuInfo selectStuByStuId(String stuId);
}
