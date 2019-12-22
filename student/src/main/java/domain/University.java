package domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Table(name = "sr_university")
@Entity
@Data
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "university_id")
    private Long universityId;

    @Column(name = "university_name")
    private String universityName;

    @OneToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy = "university")
    private List<Faculty> faculties;

}
