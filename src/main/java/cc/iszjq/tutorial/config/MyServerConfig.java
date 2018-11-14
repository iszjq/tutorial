package cc.iszjq.tutorial.config;

import cc.iszjq.tutorial.filter.MyFilter;
import cc.iszjq.tutorial.listener.MyListener;
import cc.iszjq.tutorial.servlet.MyServlet;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class MyServerConfig {

    //注册三大组件
    @Bean
    public ServletRegistrationBean<MyServlet> myServlet() {
        return new ServletRegistrationBean<>(new MyServlet(), "/myServlet");
    }

    @Bean
    public FilterRegistrationBean<MyFilter> myFilter() {
        FilterRegistrationBean<MyFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new MyFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/hello", "/myServlet"));
        return filterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean<MyListener> myListener() {
        return new ServletListenerRegistrationBean<>(new MyListener());
    }

    //配置嵌入式Servlet容器
   /* @Bean
    public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer() {
        return new EmbeddedServletContainerCustomizer() {
            //定制嵌入式Servlet的容器相关规则
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                container.setPort(8999);
            }
        };
    }*/


    /*SpringBoot2.0中EmbeddedServletContainerCustomizer
     被WebServerFactoryCustomizer替代
     */
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer() {
        return factory -> factory.setPort(8080);
    }
}
