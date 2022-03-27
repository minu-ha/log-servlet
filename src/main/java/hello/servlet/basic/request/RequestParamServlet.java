package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( name = "requestParamServlet", urlPatterns = "/request-param" )
public class RequestParamServlet extends HttpServlet{


    @Override
    protected void service( HttpServletRequest request , HttpServletResponse response ) throws ServletException, IOException{

        System.out.println( "전체 파라미터 조회 시작" );
        request.getParameterNames().asIterator().forEachRemaining( paramName -> System.out.println( request.getParameter( paramName ) ) );
        System.out.println( "전체 파라미터 조회 끝" );

        System.out.println( "단일 파라미터 조회 시작" );
        String username = request.getParameter( "username" );
        System.out.println( "단일 파라미터 조회 끝" );


    }
}
