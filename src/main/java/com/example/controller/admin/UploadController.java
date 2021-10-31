package com.example.controller.admin;

import com.example.config.Constants;
import com.example.util.Result;
import com.example.util.ResultGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author: ming
 * @date: 2021/10/31 17:29
 */
@Controller
@RequestMapping("/admin")
public class UploadController {

    @PostMapping("upload/file")
    @ResponseBody
    public Result upload(@RequestParam("file") MultipartFile file) throws IOException {
        if (file == null) {
            return ResultGenerator.genFailResult("上传失败");
        }
        String tempName = file.getName();
        StringBuilder stringBuilder = new StringBuilder();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Random random = new Random();
        stringBuilder.append(dateFormat.format(new Date()))
                .append(random.nextInt(1000));
        int lastIndexOf = tempName.lastIndexOf(".");
        if (lastIndexOf > 0) {
            stringBuilder.append(tempName, 0, lastIndexOf);
        }else {
            stringBuilder.append(tempName);
        }
        String newFilename = stringBuilder.toString();
        file.transferTo(new File(Constants.FILE_UPLOAD_PATH + newFilename));
        Result result = ResultGenerator.genSuccessResult();
        result.setData("/files/"+newFilename);
        return result;
    }
}
