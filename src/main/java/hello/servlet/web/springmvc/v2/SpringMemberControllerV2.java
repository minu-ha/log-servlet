package hello.servlet.web.springmvc.v2;


import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SpringMemberControllerV2{


    private MemberRepository memberRepository = MemberRepository.getInstance();


    @RequestMapping( value = "/new-form", method = RequestMethod.GET )
    public String newForm(){
        return "new-form";
    }


}
