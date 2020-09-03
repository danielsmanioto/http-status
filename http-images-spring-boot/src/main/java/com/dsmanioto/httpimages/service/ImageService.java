package com.dsmanioto.httpimages.service;

import com.dsmanioto.httpimages.exception.ImageNotFoundException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import java.io.IOException;

@Service
public class ImageService {

    private static final String IMAGES_FOUDER = "image";

    public byte[] getImage(String code) {
        var imgFile = new ClassPathResource(IMAGES_FOUDER + "/" + code + ".jpg");
        try {
            return StreamUtils.copyToByteArray(imgFile.getInputStream());
        } catch (IOException e) {
            throw new ImageNotFoundException(e);
        }
    }
}
