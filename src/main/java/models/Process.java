package models;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class Process {
    private final UUID pid = UUID.randomUUID();
    private final String name;
    private final int priority;
    private LocalDateTime creationDate;
    private LocalDateTime modificationDate;
    private int quantum;
}
