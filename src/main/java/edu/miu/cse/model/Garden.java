package edu.miu.cse.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.Query;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "garden")
public class Garden {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer gardenId;

    private String name;
    private Double size;

    @Override
    public String toString() {
        return
                "ID:" + gardenId +
                ", Name:'" + name + '\'' +
                ", Size:" + size + " m²";
    }
}
