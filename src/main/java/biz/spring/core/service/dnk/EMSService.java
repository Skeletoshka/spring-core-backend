package biz.spring.core.service.dnk;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;

@Service
public class EMSService {
    @Value("${spring.file.path}")
    private String path;

    public String upload(MultipartFile saveFile){
        try{
            BufferedInputStream buff = new BufferedInputStream(saveFile.getInputStream());
            String fileName = Arrays.hashCode(saveFile.getBytes())  + ".txt";
            File file = new File(path + File.separator + fileName);
            java.nio.file.Files.copy(buff, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            return fileName;
        }catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

   public String download(Integer appendix_id){
        return path + ".txt";
    }
}
