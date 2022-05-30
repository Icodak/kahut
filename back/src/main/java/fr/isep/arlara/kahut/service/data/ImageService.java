package fr.isep.arlara.kahut.service.data;

import fr.isep.arlara.kahut.model.database.Image;
import fr.isep.arlara.kahut.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ImageService {


    private final ImageRepository imageRepository;

    public ResponseEntity<Image> uploadImage(MultipartFile multipartImage) throws IOException {
        Image image = new Image();
        image.setLegend(multipartImage.getName());

        image.setData(multipartImage.getBytes());

        Image savedImage = imageRepository.save(image);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/resource/"+savedImage.getId()).toUriString());
        return ResponseEntity.created(uri).body(savedImage);
    }

    public Resource downloadImage(UUID imageId){
        byte[] image = imageRepository.findById(imageId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))
                .getData();

        return new ByteArrayResource(image);
    }

}
