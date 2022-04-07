package fr.isep.arlara.kahut.model;

import jakarta.persistence.*;
import lombok.*;

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
    private String legend;


}