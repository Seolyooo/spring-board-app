package kr.co.sboard.intercepter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.sboard.config.AppInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
public class AppInfoIntercepter implements HandlerInterceptor {

    /*
    *   interceptor
    * - 클라이언트 요청을 컨트롤러 사이엥서 특정 작없을 수행하는 컴포넌트
    * - http 요청을 가로채소. 요청이 컨트롤러에 도달 전 후에 추가작업
    *

    * */

    private final AppInfo appInfo;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if(modelAndView != null) {

            modelAndView.addObject("appInfo", appInfo);
        }
    }
}
