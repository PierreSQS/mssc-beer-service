package guru.springframework.msscbeerservice.services.inventory.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by jt on 2019-06-07.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerInventoryDto {
    private UUID id;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
    private UUID beerId;
    private Integer quantityOnHand;
}
