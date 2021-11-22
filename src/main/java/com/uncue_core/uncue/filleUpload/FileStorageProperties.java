package com.uncue_core.uncue.filleUpload;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "file")
@Setter
@Getter
@Component
public class FileStorageProperties {
	private String uploadDir;
}
