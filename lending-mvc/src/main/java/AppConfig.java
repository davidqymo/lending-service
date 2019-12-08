import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

import com.xxxx.corebanking.config.CoreBankingPackageConfig;
import com.xxxx.corebanking.lending.config.LendingPackageConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import java.util.List;

@Configuration
@EnableWebMvc
@ComponentScan("com.xxxx.corebanking.lending.mvc")
@Import({LendingPackageConfig.class, CoreBankingPackageConfig.class})
public class AppConfig implements WebMvcConfigurer {

    //e.g. sample to config MessageConvertor

    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.stream( ).forEach( System.out::println );
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter( );
        converters.add( converter );
    }
}
