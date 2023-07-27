package lab.space.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
@Table(name = "carousel")
@Data
@Accessors(chain = true)
public class Carousel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private Instant createAt;

    @UpdateTimestamp
    private Instant updateAt;

    @Column(length = 100, nullable = false)
    private String imgUrl;

    @Column(length = 2500, nullable = false)
    private String description;

    @Column(length = 50, nullable = false)
    private String login;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(length = 50, nullable = false)
    private String projectName;

    @Column(length = 100, nullable = false)
    private String projectUrl;

}
