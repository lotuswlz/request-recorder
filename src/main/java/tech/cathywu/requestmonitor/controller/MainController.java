package tech.cathywu.requestmonitor.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.cathywu.requestmonitor.model.RequestDto;
import tech.cathywu.requestmonitor.service.RequestService;

import java.util.Iterator;

@RequestMapping("/")
@Controller
public class MainController {

    @Autowired
    private RequestService requestService;

    @RequestMapping("/**")
    public String recordRequest(@RequestBody(required = false) Object object, HttpServletRequest request) throws JsonProcessingException {
        RequestDto requestDto = new RequestDto();
        requestDto.setUrl(request.getRequestURL().toString());
        requestDto.setMethod(request.getMethod());
        requestDto.setHeaders(concatHeaders(request));
        requestDto.setClientIp(request.getRemoteAddr());
        requestDto.setBody(object);
        requestDto.setQueryParam(request.getQueryString());
        requestService.saveRequest(requestDto);
        return "redirect:/admin/records";
    }

    private String concatHeaders(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> iterator = request.getHeaderNames().asIterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            sb.append(key).append("=").append(request.getHeader(key)).append(";");
        }
        return sb.toString();
    }
}
