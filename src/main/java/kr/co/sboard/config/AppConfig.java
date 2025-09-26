package kr.co.sboard.config;

import kr.co.sboard.intercepter.AppInfoIntercepter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {

    private AppInfo appInfo;

    @Bean
    public AppInfo getAppInfo() {
        appInfo = new AppInfo();
        return new AppInfo();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AppInfoIntercepter(appInfo));
    }
}