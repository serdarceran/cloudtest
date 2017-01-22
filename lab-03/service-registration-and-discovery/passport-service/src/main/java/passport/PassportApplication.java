package passport;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
@EnableHystrixDashboard
public class PassportApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(PassportApplication.class)
//                .web(false)
                .run(args);
    }
}

@Controller
class UiController {

    @Autowired
    private BookmarkClient bookmarkClient;

    @RequestMapping("/{userId}/bookmarks")
    @HystrixCommand(fallbackMethod = "defaultBookmarks")
    public String getBookmarks(Model model, @PathVariable String userId) {
        List<Bookmark> bookmarks = bookmarkClient.getBookmarks(userId);
        System.out.println(">> Number of bookmarks: " + bookmarks.size());
        model.addAttribute("userId", userId);
        model.addAttribute("bookmarks", bookmarks);
        return "bookmarks";
    }

    public String defaultBookmarks(Model model, @PathVariable String userId) {
        model.addAttribute("userId", userId);
        model.addAttribute("bookmarks", new ArrayList<Bookmark>());
        return "bookmarks";
    }
}

//@Component
class DiscoveryClientExample implements CommandLineRunner {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Override
    public void run(String... strings) throws Exception {
        discoveryClient.getInstances("photo-service").forEach((ServiceInstance s) -> {
            System.out.println(">>>> " + ToStringBuilder.reflectionToString(s));
        });
        discoveryClient.getInstances("bookmark-service").forEach((ServiceInstance s) -> {
            System.out.println(">>>>> " + ToStringBuilder.reflectionToString(s));
        });
    }
}

//@Component
class FeignExample implements CommandLineRunner {

    @Autowired
    private BookmarkClient bookmarkClient;

    @Override
    public void run(String... strings) throws Exception {
        System.out.print(">>>> Getting Bookmarks...");
        this.bookmarkClient.getBookmarks("cemre").forEach(b-> System.out.println(">>>>> " + b.getId() + ", " + b.getHref()));
        System.out.print(">>>> Getting Bookmarks...DONE");
    }
}

@FeignClient("bookmark-service")
interface BookmarkClient {

    @RequestMapping(method = RequestMethod.GET, value = "/{userId}/bookmarks")
    List<Bookmark> getBookmarks(@PathVariable("userId") String userId);
}

class Bookmark {
    private Long id;
    private String href, label, description, userId;

    @Override
    public String toString() {
        return "Bookmark{" +
                "id=" + id +
                ", href='" + href + '\'' +
                ", label='" + label + '\'' +
                ", description='" + description + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    public Bookmark() {
    }

    public Long getId() {
        return id;
    }

    public String getHref() {
        return href;
    }

    public String getLabel() {
        return label;
    }

    public String getDescription() {
        return description;
    }

    public String getUserId() {
        return userId;
    }
}

