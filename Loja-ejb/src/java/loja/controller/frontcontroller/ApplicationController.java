package loja.controller.frontcontroller;

import javax.servlet.http.HttpServletRequest;

public interface ApplicationController {
    
    public void execute();
    public void init(HttpServletRequest request);
    public String getReturnPage();
}
