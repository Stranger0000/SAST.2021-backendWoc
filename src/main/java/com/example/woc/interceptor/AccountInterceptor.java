package com.example.woc.interceptor;

import com.example.woc.entity.Account;
import com.example.woc.exception.MyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xyx
 * @date 2022/2/14 21:08
 */
@Slf4j
public class AccountInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {



        Account userLogin = (Account) request.getSession().getAttribute("userLogin");
        String requestURI = request.getRequestURI();
        log.info("拦截的请求路径是" + requestURI);


        if (userLogin == null) {
            throw new MyException(-7,"用户未登录");
        } else if (userLogin.getRole()==0||userLogin.getRole()==1&&request.getRequestURI().equals("/admin/update")){
            throw new MyException(-8,"权限不足");
        } else{
            return true;
        }
    }
}


