package com.ruoyi.quartz.task;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import javax.imageio.ImageIO;
import javax.mail.internet.MimeMessage;

@Component("birthdayTask")
public class BirthdayTask {

    @Autowired
    private com.ruoyi.customer.service.ICustomerService customerService;
    @Autowired
    private com.ruoyi.employee.service.IEmployeeService employeeService;
    @Autowired
    private JavaMailSender mailSender;
    @Value("${spring.mail.username}")
    private String from;

    public void checkTodayBirthday() {
        List<com.ruoyi.customer.domain.Customer> customerList = customerService.getTodayBirthdayCustomers();
        for (com.ruoyi.customer.domain.Customer customer : customerList) {
            try {

                BufferedImage image = generateBirthdayCard(customer.getCustomerName());

                File file = new File("birthday_" + customer.getCustomerId() + ".png");
                ImageIO.write(image, "png", file);
                MimeMessage message = mailSender.createMimeMessage();
                MimeMessageHelper helper =
                        new MimeMessageHelper(message, true, "UTF-8");

                helper.setFrom(from);
                helper.setTo(customer.getCustomerEmail());
                helper.setSubject("【お誕生日お祝い】心よりお祝い申し上げます");
                helper.setText("""
                        <html>
                        <body style="text-align:center;">
                          <p>心ばかりではございますが、バースデーカードをお届けいたします。</p>
                          <img src="cid:cardImage"/>
                        </body>
                        </html>
                        """, true);
                helper.addInline("cardImage", file);
                mailSender.send(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public BufferedImage generateBirthdayCard(String customerName) {

        int width = 960;
        int height = 600;

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();

        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // ===== 柔和渐变背景 =====
        GradientPaint bg = new GradientPaint(
                0, 0, new Color(255, 228, 235),
                0, height, new Color(255, 245, 220)
        );
        g.setPaint(bg);
        g.fillRect(0, 0, width, height);

        // ===== 卡片主体 =====
        g.setColor(Color.WHITE);
        g.fillRoundRect(40, 40, width - 80, height - 80, 50, 50);

        // ===== 金色边框 =====
        g.setColor(new Color(218, 180, 80));
        g.setStroke(new BasicStroke(4));
        g.drawRoundRect(40, 40, width - 80, height - 80, 50, 50);

        // ===== 彩带装饰 =====
        drawRibbon(g, 40, 40);
        drawRibbon(g, width - 120, 40);

        // ===== 花瓣飘落 =====
        for (int i = 0; i < 12; i++) {
            drawPetal(g,
                    120 + i * 60,
                    80 + (i % 3) * 20,
                    new Color(255, 180, 200, 180));
        }

        // ===== 蛋糕 =====
        drawLuxuryCake(g, width / 2 - 90, 130);

        // ===== 标题 =====
        g.setColor(new Color(190, 90, 110));
        g.setFont(new Font("Serif", Font.BOLD, 30));
        g.drawString("Happy Birthday", width / 2 - 105, 280);

        // ===== 正文 =====
        g.setColor(new Color(90, 70, 60));
        g.setFont(new Font("Serif", Font.PLAIN, 21));

        int y = 320;
        g.drawString(customerName + " 様", 200, y);
        y += 34;
        g.drawString("平素より格別のお引き立てを賜り、誠にありがとうございます。", 200, y);
        y += 32;
        g.drawString("本日、お誕生日を迎えられましたことを、心よりお祝い申し上げます。", 200, y);
        y += 32;
        g.drawString("これからの一年が、笑顔と幸せに満ちた", 200, y);
        y += 32;
        g.drawString("素晴らしい日々となりますよう、心よりお祈り申し上げます。", 200, y);

        // ===== 分割线 =====
        g.setColor(new Color(220, 200, 170));
        g.setStroke(new BasicStroke(2));
        g.drawLine(260, height - 150, width - 260, height - 150);

        // ===== 落款 =====
        g.setColor(new Color(130, 110, 100));
        g.setFont(new Font("Serif", Font.BOLD, 20));

        String companyName = "SNSソフト株式会社";

// 计算字符串宽度，用来右对齐
        FontMetrics fm = g.getFontMetrics();
        int textWidth = fm.stringWidth(companyName);

// 右边距（离卡片右边留一点空白）
        int rightMargin = 80;

// 公司名 X 坐标（贴右）
        int companyX = width - rightMargin - textWidth;
        int companyY = height - 120;

        g.drawString(companyName, companyX, companyY);

// ===== 日期 =====
        g.setFont(new Font("Serif", Font.PLAIN, 18));
        FontMetrics dateFm = g.getFontMetrics();

        String today = java.time.LocalDate.now()
                .format(java.time.format.DateTimeFormatter.ofPattern("yyyy年MM月dd日"));

        int dateWidth = dateFm.stringWidth(today);
        int dateX = width - rightMargin - dateWidth;
        int dateY = height - 90;

        g.drawString(today, dateX, dateY);

        g.dispose();
        return image;
    }
    private void drawRibbon(Graphics2D g, int x, int y) {
        g.setColor(new Color(255, 170, 190));
        g.fillArc(x, y, 120, 120, 0, 180);
    }
    private void drawPetal(Graphics2D g, int x, int y, Color color) {
        g.setColor(color);
        g.fillOval(x, y, 18, 10);
    }
    private void drawLuxuryCake(Graphics2D g, int x, int y) {

        // 底层
        g.setColor(new Color(255, 210, 190));
        g.fillRoundRect(x, y + 70, 180, 50, 30, 30);

        // 中层
        g.setColor(new Color(255, 230, 210));
        g.fillRoundRect(x + 15, y + 40, 150, 45, 30, 30);

        // 顶层
        g.setColor(new Color(255, 245, 225));
        g.fillRoundRect(x + 30, y + 15, 120, 40, 30, 30);

        // 奶油点
        g.setColor(Color.WHITE);
        for (int i = 0; i < 6; i++) {
            g.fillOval(x + 40 + i * 18, y + 10, 14, 14);
        }

        // 蜡烛
        g.setColor(Color.WHITE);
        g.fillRect(x + 85, y - 10, 10, 25);

        // 火焰
        g.setColor(Color.ORANGE);
        g.fillOval(x + 82, y - 22, 16, 16);
    }
}

