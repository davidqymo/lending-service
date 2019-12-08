import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class MyMVCApplicationInitializer implements WebApplicationInitializer {

    @Transactional(isolation = Isolation.DEFAULT)
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext( );
        ac.register( AppConfig.class );
//        ac.refresh();

        //create and Register DispatcherServlet

        DispatcherServlet servlet = new DispatcherServlet( ac );
        ServletRegistration.Dynamic registration = servletContext.addServlet( "lending-mvc", servlet );
        registration.setLoadOnStartup( 1 );
        registration.addMapping( "/*" );

    }
}
