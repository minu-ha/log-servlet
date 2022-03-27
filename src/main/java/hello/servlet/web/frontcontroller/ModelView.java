package hello.servlet.web.frontcontroller;

import java.util.HashMap;

public class ModelView{


    private String viewName;
    private HashMap< String, Object > model = new HashMap<>();

    public ModelView( String viewName ){
        this.viewName = viewName;
    }

    public String getViewName(){
        return viewName;
    }

    public void setViewName( String viewName ){
        this.viewName = viewName;
    }

    public HashMap< String, Object > getModel(){
        return model;
    }

    public void setModel( HashMap< String, Object > model ){
        this.model = model;
    }
}
