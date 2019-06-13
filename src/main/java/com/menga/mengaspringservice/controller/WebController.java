package com.menga.mengaspringservice.controller;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.menga.mengaspringservice.util.HtmlUnitUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Marvel on 2019/6/13.
 */
@RestController
@RequestMapping("/api/web")
public class WebController {

    @RequestMapping("/hello")
    public String hello(@RequestParam(defaultValue = "wei") String name) {
        return "Hello " + name;
    }

    @RequestMapping("/visit")
    public String visit(String url, String type) {
        final WebClient webClient = HtmlUnitUtil.getWebClient();

        HtmlPage page = null;
        try {
            if (url != null && url.length() > 3) {
                page = webClient.getPage(url);//尝试加载上面图片例子给出的网页
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            webClient.close();
        }

        if (page != null) {
            if ("xml".equals(type)) {
                return page.asXml();
            } else if ("text".equals(type)) {
                return page.asText();
            } else {
                String text = page.asXml();
                String f = text.replaceAll("href=", "xx=").replaceAll("src=", "xx=");
                return f;
            }
        }
        return "some error";
    }
}
