package com.xianbester.service;

import com.alibaba.dubbo.registry.dubbo.DubboRegistryFactory;
import com.alibaba.dubbo.rpc.protocol.dubbo.DubboProtocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author liuwen
 * @date 2019/1/7
 */
@WebListener
public class DubboServiceListener implements ServletContextListener {

    /** 日志记录 */
    private Logger logger = LoggerFactory.getLogger(DubboServiceListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("初始化");
    }



    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("销毁dubbo实例中....");
        DubboRegistryFactory.destroyAll();
        DubboProtocol.getDubboProtocol().destroy();
        logger.info("销毁dubbo服务完成！");
    }
}
