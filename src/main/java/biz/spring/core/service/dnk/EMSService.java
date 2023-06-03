package biz.spring.core.service.dnk;

import biz.spring.core.repository.dnk.AppendixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.UUID;
import java.util.regex.Matcher;

@Service
public class EMSService {
    @Value("${spring.file.path}")
    private String path;

    @Autowired
    private AppendixRepository appendixRepository;

    public String upload(MultipartFile saveFile){
        try(BufferedInputStream buff = new BufferedInputStream(saveFile.getInputStream())){
            String fileName = UUID.randomUUID()
                    + saveFile.getOriginalFilename().substring(saveFile.getOriginalFilename().lastIndexOf("."));
            File file = new File(path + File.separator + fileName);
            java.nio.file.Files.copy(buff, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            return fileName;
        }catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public void delete(String pathFile){
        try {
            java.nio.file.Files.delete(new File(pathFile).toPath());
        }catch (Exception e){
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public String getPath(){
        return path;
    }

    public String download(Integer appendixId){
        return appendixRepository.get(appendixId).getAppendixPath();
    }
}
