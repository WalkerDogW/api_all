package com.ruoyi.project.tool.gen.mapper;


import com.ruoyi.framework.aspectj.lang.annotation.DataSource;
import com.ruoyi.framework.aspectj.lang.enums.DataSourceType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author Tao
 * @Date 2020/7/29
 * @Time 15:17
 */
@Mapper
public interface HelloMapper {
    @DataSource(value = DataSourceType.MASTER)
    @Select("select 1 ")
    public String hello();


    @DataSource(value = DataSourceType.SLAVE)
    @Select("select top 1 * from inventory_evidence order by evidence_number ")
    public String hello2();
}
