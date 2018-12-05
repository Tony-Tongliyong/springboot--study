package com.wuxin.tong.dao.mapper.primary;

import com.wuxin.tong.dao.entity.TableStatisticStatus;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TableStatisticStatusMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table table_statistic_status
     *
     * @mbggenerated Tue Nov 27 16:54:26 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table table_statistic_status
     *
     * @mbggenerated Tue Nov 27 16:54:26 CST 2018
     */
    int insert(TableStatisticStatus record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table table_statistic_status
     *
     * @mbggenerated Tue Nov 27 16:54:26 CST 2018
     */
    int insertSelective(TableStatisticStatus record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table table_statistic_status
     *
     * @mbggenerated Tue Nov 27 16:54:26 CST 2018
     */
    TableStatisticStatus selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table table_statistic_status
     *
     * @mbggenerated Tue Nov 27 16:54:26 CST 2018
     */
    int updateByPrimaryKeySelective(TableStatisticStatus record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table table_statistic_status
     *
     * @mbggenerated Tue Nov 27 16:54:26 CST 2018
     */
    int updateByPrimaryKey(TableStatisticStatus record);
}