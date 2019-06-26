package com.menga.mengaspringservice.controller;

import com.menga.mengaspringservice.util.ShellUtil;
import com.menga.mengaspringservice.util.ViewUitl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

/**
 * Created by Marvel on 2019/6/26.
 */
@RestController
@RequestMapping("/api/webhook")
public class WebhookController {

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
}
