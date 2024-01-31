package ra.projectmd3.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {
//    private static final String LOCATION = "C:\\Users\\AD\\Documents";
//    private static final long MAX_FILE_SIZE = 1024 * 1024 * 25;//25MB
//    private static final long MAX_REQUEST_SIZE = 1024 * 1024 * 30;//30MB
//    private static final int FILE_SIZE_THRESHOLD = 0;
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    // cấu hin utf-8
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setForceEncoding(true);
        filter.setEncoding("utf-8");
        return new Filter[]{filter};
    }

//    private MultipartConfigElement getMultipartConfigElement(){
//        MultipartConfigElement multipartConfigElement = new MultipartConfigElement(LOCATION, MAX_FILE_SIZE, MAX_REQUEST_SIZE, FILE_SIZE_THRESHOLD);
//        return multipartConfigElement;
//    }
}
