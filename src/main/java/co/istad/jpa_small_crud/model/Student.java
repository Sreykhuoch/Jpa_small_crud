package co.istad.jpa_small_crud.model;


import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student-seq")
    @SequenceGenerator(name = "student_seq", sequenceName = "student_segs", allocationSize = 1)
    private Integer id;

    @Column(nullable=false, name="full_name")
    private String name;

    @Column(nullable = false)
    @Min(value = 1, message = "Age must be greater than 0")
    private String age;

    @Column(precision=10, scale=2 , nullable = false)
    @Positive(message = "Negative number is  unacceptable")
    private BigDecimal payment;
}
