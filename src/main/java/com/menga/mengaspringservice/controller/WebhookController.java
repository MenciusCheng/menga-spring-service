package com.menga.mengaspringservice.controller;

import com.menga.mengaspringservice.util.ShellUtil;
import com.menga.mengaspringservice.util.ViewUitl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * Created by Marvel on 2019/6/26.
 */
@RestController
@RequestMapping("/api/webhook")
public class WebhookController {
    private static final Logger logger = LoggerFactory.getLogger(WebhookController.class);

    @RequestMapping("/test")
    public String test(String name) {
        return "OK, " + name;
    }

    @RequestMapping("/exec")
    public String exec(String cmd, String path) {
        if (path == null || path.length() == 0) {
            path = "./";
        }
        File file = new File(path);
        return ViewUitl.lineToBr(ShellUtil.execCmd(cmd, file));
    }

    @RequestMapping("/git-push")
    public String gitPush(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        StringBuilder builder = new StringBuilder();
        String aux;

        while ((aux = req.getReader().readLine()) != null) {
            builder.append(aux);
        }

        String text = builder.toString();
        logger.info("gitPush=\n" + text);

        return "success";
    }

    @RequestMapping("/git-push-code-generator")
    public String gitPushCodeGenerator(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        File file = new File("/opt/web/code-generator");
        String result = ShellUtil.execCmd("git pull", file);
        logger.info("gitPushCodeGenerator.result=\n" + result);
        return result;
    }
}
