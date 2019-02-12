package com.wuxin.tong;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

import static com.wuxin.tong.SecondaryDataSourceConfig.BASE_PACKAGE;

/**
 * @author: tongly
 * @contact:wuxin@yscredit.com
 * @file: SecondaryDataSourceConfig
 * @time: 2018/12/4 17:16
 * @desc:
 */
@Configuration
@MapperScan(sqlSessionFactoryRef = "secondarySqlSessionFactory",basePackages = BASE_PACKAGE,sqlSessionTemplateRef  = "secondarySqlSessionTemplate")
public class SecondaryDataSourceConfig {

    private static final Logger log = LoggerFactory.getLogger(SecondaryDataSourceConfig.class);

    static final String BASE_PACKAGE = "com.wuxin.tong.dao.mapper.secondary" ;
    private static String MAPPER_LOCATION_SECONDARY = "classpath:com/wuxin/tong/dao/xml/secondary/*.xml"  ;

    @Bean(name = "secondaryDataSource")
    @ConfigurationProperties(prefix="spring.datasource.secondary")
    public DataSource secondaryDataSource() {
        log.info("secondary初始化");
        return new DruidDataSource();
    }

    @Bean(name = "secondaryTransactionManager")
    public DataSourceTransactionManager secondaryTransaction(@Qualifier("secondaryDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "secondarySqlSessionFactory")
    public SqlSessionFactory secondarySqlSessionFactory(@Qualifier("secondaryDataSource") DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(SecondaryDataSourceConfig.MAPPER_LOCATION_SECONDARY));
        return factoryBean.getObject();
    }

    @Bean(name = "secondarySqlSessionTemplate")
    public SqlSessionTemplate secondarySqlSessionTemplate(@Qualifier("secondarySqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}