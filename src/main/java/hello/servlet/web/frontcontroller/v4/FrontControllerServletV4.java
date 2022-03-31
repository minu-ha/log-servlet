package hello.servlet.web.frontcontroller.v4;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v4.ControllerV4;
import hello.servlet.web.frontcontroller.v4.controller.MemberFormControllerV4;
import hello.servlet.web.frontcontroller.v4.controller.MemberListControllerV4;
import hello.servlet.web.frontcontroller.v4.controller.MemberSaveControllerV4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@WebServlet( name = "frontControllerServletV4", urlPatterns = "/front-controller/v4/*" )
public class FrontControllerServletV4 extends HttpServlet{

    private HashMap< String, ControllerV4 > controllerV4Map = new HashMap<>();

    public FrontControllerServletV4(){

        controllerV4Map.put( "/front-controller/v4/members/new-form" , new MemberFormControllerV4() );
        controllerV4Map.put( "/front-controller/v4/members/save" , new MemberSaveControllerV4() );
        controllerV4Map.put( "/front-controller/v4/members" , new MemberListControllerV4() );
    }

    @Override
    protected void service( HttpServletRequest request , HttpServletResponse response ) throws ServletException, IOException{

        String requestURI = request.getRequestURI();

        ControllerV4 controller = controllerV4Map.get( requestURI );
        if ( controller == null ) {
            response.setStatus( HttpServletResponse.SC_NOT_FOUND );
            return;
        }

        Map< String, String > paramMap = createParamMap( request );
        Map< String, Object > model = new HashMap<>();

        String viewName = controller.process( paramMap , model );

        MyView view = viewRosolver( viewName );
        view.render( request , response );

    }

    private Map< String, String > createParamMap( HttpServletRequest request ){

        Map< String, String > paraMap = new HashMap<>();
        request.getParameterNames().asIterator().forEachRemaining( paramName -> paraMap.put( paramName , request.getParameter( paramName ) ) );
        return paraMap;
    }

    private MyView viewRosolver( String viewName ){
        return new MyView( "WEB-INF/views/" + viewName + ".jsp" );
    }


}
