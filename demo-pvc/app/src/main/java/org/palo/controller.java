package org.palo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.nio.file.*;
import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;

@RestController
public class controller {

	@Value("${SPRING_APPLICATION_NAME}")
	String appName;

    @Value("${PVC_MOUNT_PATH:.}")
    String pvcMountPath;

    @GetMapping("/appname")
    public String appName() {
        return appName;
    }

    @GetMapping("/")
    public String example() {
        return "Hello World !!";
    }

    @PostMapping("/pvc/upload_file")
    public String example(@RequestBody FileDetails fileDetails) throws IOException {
        SecureRandom secureRandom = new SecureRandom();
        Path path = Paths.get(String.format("%s/%d.txt", pvcMountPath, System.currentTimeMillis()));
        byte[] strToBytes = fileDetails.getFileContent().getBytes();

        Files.write(path, strToBytes);
        return path + ": File created successfully";
    }

    @GetMapping("/pvc/{file_name}")
    public String listFileContent(@PathVariable("file_name") String file_name) throws IOException {

        FileInputStream fis = new FileInputStream(String.format("%s/%s", pvcMountPath, file_name));

        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(fis))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }

    @GetMapping("/pvc/files")
    public List<String> listFiles() {

        List<String> fileNames = new LinkedList<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(pvcMountPath))) {
            for (Path file : stream) {
                fileNames.add(file.getFileName().toString());
                System.out.println(file.getFileName());
            }
        } catch (IOException | DirectoryIteratorException x) {
            // IOException can never be thrown by the iteration.
            // In this snippet, it can only be thrown by newDirectoryStream.
            System.err.println(x);
        }

        return fileNames;
    }
}
