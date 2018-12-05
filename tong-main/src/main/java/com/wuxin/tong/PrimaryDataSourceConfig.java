package com.wuxin.tong;

import com.alibaba.druid.pool.DruidDataSource;
import com.mysql.jdbc.log.LogFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author: tongly
 * @contact:wuxin@yscredit.com
 * @file: DataSourceConfig
 * @time: 2018/12/4 16:04
 * @desc:
 */
@Configuration
@MapperScan(basePackages = PrimaryDataSourceConfig.BASE_PACKAGE,sqlSessionFactoryRef = "primarySqlSessionFactory",sqlSessionTemplateRef  = "primarySqlSessionTemplate")

public class PrimaryDataSourceConfig {

    private static final Logger log = LoggerFactory.getLogger(PrimaryDataSourceConfig.class);

    static final String BASE_PACKAGE = "com.wuxin.tong.dao.mapper.primary";
    private static String MAPPER_LOCATION_PRIMARY = "classpath:com/wuxin/tong/dao/xml/primary/*.xml" ;

    @Primary
    @Bean(name = "primaryDataSource")
    @ConfigurationProperties(prefix="spring.datasource.primary")
    public DataSource primaryDataSource() {
        log.info("primary初始化");
        return new DruidDataSource();
    }
    @Primary
    @Bean(name = "primaryTransactionManager")
    public DataSourceTransactionManager primaryTransaction(@Qualifier("primaryDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Primary
    @Bean(name = "primarySqlSessionFactory")
    public SqlSessionFactory primarySqlSessionFactory(@Qualifier("primaryDataSource") DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(PrimaryDataSourceConfig.MAPPER_LOCATION_PRIMARY));
        return factoryBean.getObject();
    }
    @Primary
    @Bean(name = "primarySqlSessionTemplate")
    public SqlSessionTemplate primarySqlSessionTemplate(@Qualifier("primarySqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}