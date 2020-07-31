package com.badese.mes.mapper;


import com.badese.common.config.db.DataSource;
import com.badese.common.config.db.DataSourceType;
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
