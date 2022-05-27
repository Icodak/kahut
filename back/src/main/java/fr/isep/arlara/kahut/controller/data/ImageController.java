package fr.isep.arlara.kahut.controller.data;

import fr.isep.arlara.kahut.model.database.Image;
import fr.isep.arlara.kahut.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@RequestMapping
@CrossOrigin
@RequiredArgsConstructor
public class ImageController {

    @Autowired
    ImageRepository imageRepository;

    @PostMapping("/api/image")
    UUID uploadImage(@RequestParam MultipartFile multipartImage) throws Exception {
        Image image = new Image();
        image.setLegend(multipartImage.getName());

        image.setData(multipartImage.getBytes());

        return imageRepository.save(image).getId();
    }

    @GetMapping(value = "/api/resources/{imageId}", produces = MediaType.IMAGE_JPEG_VALUE)
    Resource downloadImage(@PathVariable UUID imageId) {
        byte[] image = imageRepository.findById(imageId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))
                .getData();

        return new ByteArrayResource(image);
    }

}
