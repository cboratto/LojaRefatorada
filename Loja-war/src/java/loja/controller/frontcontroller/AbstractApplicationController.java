package loja.controller.frontcontroller;

import javax.servlet.http.HttpServletRequest;

public abstract class AbstractApplicationController implements ApplicationController {

    private HttpServletRequest request;
    protected String returnPage;

    @Override
    public void init(HttpServletRequest request) {
        this.setRequest(request);
    }

    public void setReturnPage(String page) {
        returnPage = page;
    }

    @Override
    public String getReturnPage() {
        return returnPage;
    }


    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }
}
