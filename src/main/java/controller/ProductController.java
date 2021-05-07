package controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value = "/scott/test")
@Controller
public class ProductController {

    //기본적으로 RequestMethod.GET 메서드일껄? : 맞음
    @RequestMapping(value = "/football")
    public String football(){
        return "football";
    }

    @RequestMapping(value = "/link", method = RequestMethod.GET)
    public String linkPage(){
        return "link";
    }


    @RequestMapping(value = "/interest")
    public String interest(){
        return "interest";
    }

    @ResponseBody
    @RequestMapping(value = "/rpbody")
    public String rpResponse(){
        return "this return @ResponseBody. \n it's just a test :)" +
                "\n if you don't put @ResponseBody on your method, and then when VIEWRESOLVER couldn't match name.jsp, then error rises.";
    }
}
