package com.dsmanioto.httpimages.exception;

import java.io.IOException;

public class ImageNotFoundException extends RuntimeException {

    public ImageNotFoundException(IOException e) {
        super(e.getMessage());
    }

}
