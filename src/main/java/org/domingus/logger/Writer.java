package org.domingus.logger;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Writer {

	private String path;

	public Writer(String path) {
		this.path = path;
	}
	
	public void write(List<Notification> data) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(path);
            objectMapper.writeValue(file, data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
}