import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OOGallery extends HttpServlet {
    public OOGallery() {}
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter(); // 获取 response 写入器

        // 获取前端表单值
        String theme = request.getParameter("theme");
        String bgrnd = request.getParameter("bgrnd");

        // 构造 HtmlPage 对象
        HtmlPage page = new HtmlPage();

        // 背景图片赋初值
        String background = "";

        // 按照文档要求设置背景图片
        if (bgrnd.equals("Sunshine"))
            background = "Sunshine.gif";
        if (bgrnd.equals("Spring"))
            background = "Spring.gif";
        if (bgrnd.equals("Rain"))
            background = "Rain.gif";

        // 声明 HtmlImage 对象
        HtmlImage image1;
        HtmlImage image2;

        // 按照文档要求设置图片
        if (theme.equals("Animal")) {
            image1 = new HtmlImage("AnimalOne.jpg","");
            image2 = new HtmlImage("AnimalTwo.jpg","");
        }
        else if (theme.equals("Flower")) {
            image1 = new HtmlImage("FlowerOne.jpg","");
            image2 = new HtmlImage("FlowerTwo.jpg","");
        }
        else {
            image1 = new HtmlImage("","");
            image2 = new HtmlImage("","");
        }

        // 为 HtmlPage 设置背景图片
        page.setBackgroundImage(background);

        // 为 HtmlPage 设置图片
        page.addText(image1.buildHtml());
        page.addText(image2.buildHtml());

        // 获取 HTML 序列化结果并输出
        writer.println(page.buildHtml());
    }
}
