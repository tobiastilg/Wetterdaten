package at.itkollegimst.wetterdaten.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "messwerte")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Messwerte {

    @Id
    @Column(name = "messwert_id")
    @SequenceGenerator(name = "messwert_sequence" , sequenceName = "messwert_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "messwert_sequence")
    private Long id;

    @Min(-273)
    @Max(1000)
    private Integer temperaturwert;

    private String name;
}