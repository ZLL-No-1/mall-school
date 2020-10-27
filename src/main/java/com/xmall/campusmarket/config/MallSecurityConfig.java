package com.xmall.campusmarket.config;


import com.xmall.campusmarket.security.component.DynamicSecurityService;
import com.xmall.campusmarket.security.config.SecurityConfig;
import com.xmall.campusmarket.xback.ums.model.UmsResource;
import com.xmall.campusmarket.xback.ums.service.UmsAdminService;
import com.xmall.campusmarket.xback.ums.service.UmsResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created with IntelliJ IDEA.
 * Description: mall-security模块相关配置
 *
 * @author: zl
 * @date: 2020-10-27
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MallSecurityConfig extends SecurityConfig {
    @Autowired
    private UmsAdminService adminService;
    @Autowired
    private UmsResourceService resourceService;

    @Bean
    public UserDetailsService userDetailsService() {
        //获取登录用户信息
        return username -> adminService.loadUserByUsername(username);
    }

    @Bean
    public DynamicSecurityService dynamicSecurityService() {
        return new DynamicSecurityService() {
            @Override
            public Map<String, ConfigAttribute> loadDataSource() {
                Map<String, ConfigAttribute> map = new ConcurrentHashMap<>();
                List<UmsResource> resourceList = resourceService.list();
                for (UmsResource resource : resourceList) {
                    map.put(resource.getUrl(), new org.springframework.security.access.SecurityConfig(resource.getId() + ":" + resource.getName()));
                }
                return map;
            }
        };
    }
}
