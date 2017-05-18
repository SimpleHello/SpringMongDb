package com.demo.websocket;

import javax.annotation.Resource;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
* WebSocket 配置类
*/
//@Configuration //一定不能少
//@ImportResource("classpath*:conf/applicationContext.xml") //重要！！加载spring的其他的xml配置文件，这种方式是注解方式+xml方式 相结合的配置方式！！
//@EnableWebSocket //不能少
public class WebSocketTest2 extends WebMvcConfigurerAdapter implements WebSocketConfigurer {

    @Resource
    private WebsocketHandler clientHandler; //注入实例
    @Resource
    private WebsocketIterceptor interceptor; //注入实例

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {//重要！处理器 URL地址 拦截器！！ 都在这里加入！！//等会儿帖 处理器和 拦截器的代码        //你需要更多处理器 或者URL 都在这里填就是了。其实一般一个就够了，一个核心处理器做请求中转。
        registry.addHandler(clientHandler, "/bootstrap").addInterceptors(interceptor);
    }

    // Allow serving HTML files through the default Servlet    // 完全可以无视下面的代码    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

}