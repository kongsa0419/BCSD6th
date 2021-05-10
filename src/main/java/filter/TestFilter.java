package filter;

import javax.servlet.*;
import java.io.IOException;

//web.xml에서 필터로 빈 등록해둠
public class TestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("create filter");
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("filter before ");
        chain.doFilter(request, response);
        System.out.println("filter after");
    }

    @Override
    public void destroy() {
        System.out.println("destroy filter");
        Filter.super.destroy();
    }
}
