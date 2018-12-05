package com.wuxin.tong.service.impl;

import com.wuxin.tong.dao.entity.DajiInstantcallLimit;
import com.wuxin.tong.dao.entity.TableStatisticStatus;
import com.wuxin.tong.dao.mapper.secondary.DajiInstantcallLimitMapper;
import com.wuxin.tong.dao.mapper.primary.TableStatisticStatusMapper;
import com.wuxin.tong.service.service.TableStatisticStatusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: tongly
 * @contact:wuxin@yscredit.com
 * @file: TableStatisticStatusServiceImpl
 * @time: 2018/11/27 16:40
 * @desc:
 */
@Service("tableStatisticStatusService")
public class TableStatisticStatusServiceImpl implements TableStatisticStatusService {

    private static final Logger logger = LoggerFactory.getLogger(TableStatisticStatusService.class);

    @Autowired
    private DajiInstantcallLimitMapper dajiInstantcallLimitMapper;

    @Autowired
    private TableStatisticStatusMapper tableStatisticStatusMapper;

    @Override
    public String select(Long id) {
        TableStatisticStatus tableStatisticStatus = tableStatisticStatusMapper.selectByPrimaryKey(id);
        DajiInstantcallLimit dajiInstantcallLimit = dajiInstantcallLimitMapper.selectByPrimaryKey(id);
        if(null != tableStatisticStatus) {
            logger.info("获取部门名成功");
            return tableStatisticStatus.getDeptName();
        }else{
            logger.info("获取appkey成功");
            return dajiInstantcallLimit.getAppKey();
//            return null;
        }
    }
}