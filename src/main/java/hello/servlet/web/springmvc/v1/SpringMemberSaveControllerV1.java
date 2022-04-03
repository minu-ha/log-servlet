package hello.servlet.web.springmvc.v1;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class SpringMemberSaveControllerV1 implements ControllerV3{


    @Override
    @RequestMapping()
    public ModelView process( Map< String, String > paramMap ){
        return null;
    }
}
