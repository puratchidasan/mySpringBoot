package com.tavant.spring.boot.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {
    @Autowired(required = false) DataSource dataSource;
//    @Autowired(required = false) RedisConnectionFactory redisConnectionFactory;
//    @Autowired(required = false) MongoDbFactory mongoDbFactory;
//    @Autowired(required = false) ConnectionFactory rabbitConnectionFactory;
//    
//    @Autowired ApplicationInstanceInfo instanceInfo;

    @RequestMapping("/")
    public String home(Model model) {
        Map<Class<?>, String> services = new LinkedHashMap();
        services.put(dataSource.getClass(), toString(dataSource));
//        services.put(mongoDbFactory.getClass(), toString(mongoDbFactory));
//        services.put(redisConnectionFactory.getClass(), toString(redisConnectionFactory));
//        services.put(rabbitConnectionFactory.getClass(), toString(rabbitConnectionFactory));
        model.addAttribute("services", services.entrySet());
        
//        model.addAttribute("instanceInfo", instanceInfo);
        
        return "home";
    }

//	private String toString(ConnectionFactory rabbitConnectionFactory2) {
//		return rabbitConnectionFactory2.toString();
//	}
//
//	private String toString(RedisConnectionFactory redisConnectionFactory2) {
//		return redisConnectionFactory2.toString();
//	}
//
//	private String toString(MongoDbFactory mongoDbFactory2) {
//		return mongoDbFactory2.toString();
//	}

	private String toString(DataSource dataSource2) {
		return dataSource2.toString();
	}
}
