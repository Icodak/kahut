package fr.isep.arlara.kahut.model.database;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;

import java.net.URL;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;
    private URL url;
    @Lob
    @Type(type = "org.hibernate.type.ImageType")
    private byte[] data;
    private String legend;


    public Image(String legend, byte[] data){
        this.legend = legend;
        this.data = data;
    }

}