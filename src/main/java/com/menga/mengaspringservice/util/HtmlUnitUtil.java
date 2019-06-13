package com.menga.mengaspringservice.util;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/**
 * Created by Marvel on 2019/6/13.
 */
public class HtmlUnitUtil {

    private static WebClient webClient = null;

    private HtmlUnitUtil() {}

    public static WebClient getWebClient() {
        if (webClient == null) {
            synchronized (HtmlUnitUtil.class) {
                if (webClient == null) {
                    webClient = new WebClient(BrowserVersion.CHROME);//新建一个模拟谷歌Chrome浏览器的浏览器客户端对象

                    webClient.getOptions().setThrowExceptionOnScriptError(false);//当JS执行出错的时候是否抛出异常, 这里选择不需要
                    webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);//当HTTP的状态非200时是否抛出异常, 这里选择不需要
                    webClient.getOptions().setActiveXNative(false);
                    webClient.getOptions().setCssEnabled(true);//是否启用CSS, 因为不需要展现页面, 所以不需要启用
                    webClient.getOptions().setJavaScriptEnabled(false); //很重要，启用JS
                    webClient.setAjaxController(new NicelyResynchronizingAjaxController());//很重要，设置支持AJAX
                }
            }
        }
        return webClient;
    }

    public static void main(String[] args) {
        final WebClient webClient = HtmlUnitUtil.getWebClient();

        HtmlPage page = null;
        try {
            page = webClient.getPage("https://jsoup.org/");//尝试加载上面图片例子给出的网页
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            webClient.close();
        }

        webClient.waitForBackgroundJavaScript(1000);//异步JS执行需要耗时,所以这里线程要阻塞30秒,等待异步JS执行结束

        if (page != null) {
            String text = page.asXml();
            System.out.println(text);
        }
    }
}
