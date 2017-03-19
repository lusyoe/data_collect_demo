package com.infosys.datacollect.config;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.pagehelper.PageHelper;

import tk.mybatis.spring.mapper.MapperScannerConfigurer;

@Configuration
public class MyBatisMapperScannerConfig {

    
    private static final Logger log = LoggerFactory.getLogger(MyBatisMapperScannerConfig.class);

    
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        
        log.info("开始扫描Mapper.....mapperScannerConfigurer");

        
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.infosys.datacollect.dao");
        
        Properties prop = new Properties();
        prop.setProperty("mappers", "com.infosys.datacollect.config.BaseDao");
        prop.setProperty("notEmpty", "false");
        prop.setProperty("IDEENTITY", "MYSQL");
        
        mapperScannerConfigurer.setProperties(prop);
        
        return mapperScannerConfigurer;
    }
    
    @Bean
    public PageHelper pageHelper() {
        log.info("注册MyBatis分页插件pageHelper.....");

        PageHelper pageHelper = new PageHelper();
        
        Properties prop = new Properties();
        prop.setProperty("offsetAsPageNum", "true");
        prop.setProperty("rowBoundsWithCount", "true");
        prop.setProperty("reasonable", "true");
        
        pageHelper.setProperties(prop);
        return pageHelper;
    }
}
