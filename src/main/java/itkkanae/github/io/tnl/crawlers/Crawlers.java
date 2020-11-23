package itkkanae.github.io.tnl.crawlers;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * @Author： kanae
 * @Date: 2020/11/23 20:06
 */
public class Crawlers {

    static public String bdCrawler() {
        Connection c = Jsoup.connect("http://top.baidu.com/buzz?b=341&c=513&fr=topbuzz_b42_c513");
        Document page;
        Elements es = null;
        try {
            page = c.get();
            es = page.select("table.list-table");//>tbody>tr
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null != es ? es.toString() : "";
    }

    static public String wbCrawler() {
        Connection c = Jsoup.connect("https://s.weibo.com/top/summary?cate=realtimehot");
        Document page;
        Elements es = null;
        try {
            page = c.get();
            es = page.select("#pl_top_realtimehot>table");//>tbody>tr
            for (Element e : es.select("tbody>tr")) {
                Element addr = e.select(".td-02>a").get(0);
                String newAddr = "https://s.weibo.com" + addr.attr("href");
                addr.attr("href", newAddr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null != es ? es.toString() : "";
    }

}
