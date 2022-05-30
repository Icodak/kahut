package fr.isep.arlara.kahut.controller.data;

import fr.isep.arlara.kahut.model.database.Image;
import fr.isep.arlara.kahut.service.data.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping
@CrossOrigin
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @PostMapping("/api/image")
    ResponseEntity<Image> uploadImage(@RequestParam MultipartFile multipartImage) throws IOException {
        return imageService.uploadImage(multipartImage);
    }

    @GetMapping(value = "/api/resources/{imageId}", produces = MediaType.IMAGE_JPEG_VALUE)
    Resource downloadImage(@PathVariable UUID imageId) {
        return imageService.downloadImage(imageId);
    }

}
