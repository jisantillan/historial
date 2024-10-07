package org.domingus.logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
	
	private String path;

	public DataReader(String path) {
		this.path = path;
	}
	
	public List<Notification> read() {
        try {
            File file = new File(path);
            if (file .exists()) {
                String data = Files.readString(Path.of(path));
                ObjectMapper objectMapper = new ObjectMapper();
                return objectMapper.readValue(data, new TypeReference<List<Notification>>() {});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<Notification>();
    }

}