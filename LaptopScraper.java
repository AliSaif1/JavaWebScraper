import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LaptopScraper {
    public List<Laptop> scrapeLaptops(String url) throws IOException {
        List<Laptop> laptops = new ArrayList<>();
        Document doc = Jsoup.connect(url).get();
        Elements container = doc.select(".product-item-info");

        for (Element laptop : container) {
            Laptop laptopDetails = new Laptop();
            laptopDetails.setTitle(laptop.select(".product-item-link").text());
            laptopDetails.setPrice(laptop.select(".price").text());
            laptopDetails.setDescription(laptop.select(".mso_listing_detail").text());
            laptopDetails.setImgUrl(laptop.select(".product-image-photo.default_image")
                    .attr("data-amsrc"));
            laptops.add(laptopDetails);
        }
        return laptops;
    }
}
