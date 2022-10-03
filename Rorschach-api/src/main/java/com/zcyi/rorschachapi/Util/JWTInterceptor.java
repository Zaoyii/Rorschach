package com.zcyi.rorschachapi.Util;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zcyi.rorschachinfrastructure.Base.ApiResult;
import com.zcyi.rorschachinfrastructure.JWT.JwtUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JWTInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //获取请求头中的令牌
        String token = request.getHeader("Authorization");
        String s;
        try {
            JwtUtils.verify(token);
            return true;
        } catch (SignatureVerificationException e) {
            e.printStackTrace();
            s = new ObjectMapper().writeValueAsString(ApiResult.Failed("无效签名"));
        } catch (TokenExpiredException e) {
            e.printStackTrace();
            s = new ObjectMapper().writeValueAsString(ApiResult.Failed("token过期"));
        } catch (AlgorithmMismatchException e) {
            e.printStackTrace();
            s = new ObjectMapper().writeValueAsString(ApiResult.Failed("token算法不一致"));

        } catch (Exception e) {
            s = new ObjectMapper().writeValueAsString(ApiResult.Failed("token无效"));
            e.printStackTrace();
        }
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(s);
        return false;

    }

}
