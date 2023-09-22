import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String url = "https://myshop.pk/laptops-desktops-computers/laptops";
        String fileName = "laptop_data.xlsx";

        LaptopScraper laptopScraper = new LaptopScraper();
        ExcelWriter excelWriter = new ExcelWriter();

        try {
            List<Laptop> laptops = laptopScraper.scrapeLaptops(url);
            excelWriter.writeLaptopsToExcel(laptops, fileName);
            System.out.println("Data saved to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
