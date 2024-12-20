package ru.job4j.tracker;

import lombok.*;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Entity
@Table(name = "items")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    private String name;
    @Column(name = "time")
    private LocalDateTime created = LocalDateTime.now().truncatedTo(TimeUnit.MINUTES.toChronoUnit());
}
