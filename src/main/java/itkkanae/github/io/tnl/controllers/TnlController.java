package itkkanae.github.io.tnl.controllers;

import itkkanae.github.io.tnl.crawlers.Crawlers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author： kanae
 * @Date: 2020/11/23 20:09
 */
@RestController
public class TnlController {

    @GetMapping("/bdl")
    public String getBdTnl(){
        return Crawlers.bdCrawler();
    }

    @GetMapping("/wbl")
    public String getWbTnl(){
        return Crawlers.wbCrawler();
    }

}
