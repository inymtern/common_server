package com.ruoyi.web.controller.biz;

import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.system.domain.BizArticle;
import com.ruoyi.system.service.IBizArticleService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 创建视频
 *
 * @Author Lostceleste
 * @Version 1.0
 * @Date 2023-07-14 14:58
 */
@RestController
@RequestMapping("/create/video")
public class CreateVideoController {
    private static final String article_path = "D:/create_video/article/";
    private static final String video_path = "D:/create_video/video/";
    private static final String temp_path = "D:/create_video/temp/";
    private static final String bat_path = "D:/create_video/bat/";

    public static void preInit() {
        try {
            FileUtils.forceMkdir(new File(article_path));
            FileUtils.forceMkdir(new File(video_path));
            FileUtils.forceMkdir(new File(temp_path));
            FileUtils.forceMkdir(new File(bat_path));

        } catch (IOException e) {
            throw new RuntimeException("创建文件夹失败");
        }
    }

    public void execBat(String batName, String articleName) {
        try {
            // 构造命令数组
            String[] command = {"cmd", "/c", bat_path + batName, article_path + articleName};
            // 执行命令
            Process process = Runtime.getRuntime().exec(command);
            // 读取命令输出
//            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
//            String line;
//            while ((line = reader.readLine()) != null) {
//                System.out.println(line);
//            }
            // 等待命令执行完成
            int exitCode = process.waitFor();
        } catch (IOException | InterruptedException ignored) {
        }
    }

    @Autowired
    private IBizArticleService bizArticleService;

    /**
     * 生成文本浏览器打开
     */
    @GetMapping("/txtGenAndOpen")
    @Anonymous
    public void txt_gen_bat() {
        BizArticle one = bizArticleService.getOne()
                .orElseThrow(() -> new RuntimeException("找不到未使用的文案了"));
        String text = one.getText();
        try {
            FileUtils.writeStringToFile(new File(article_path + "read.txt"), text, "UTF-8");
            execBat("open_b.bat", "read.txt");
        } catch (IOException e) {
            throw new RuntimeException("");
        }
    }




}
