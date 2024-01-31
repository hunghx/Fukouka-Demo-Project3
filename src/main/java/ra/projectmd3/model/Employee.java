package ra.projectmd3.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String avatar;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(columnDefinition = "date")
    private Date dob;
    private String bio;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
