package pl.coderslab.sampleboot.web;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebAppConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/logout").setViewName("logoutView");
        registry.addViewController("/login").setViewName("loginView");
        registry.addViewController("/403").setViewName("403");
    }
}
