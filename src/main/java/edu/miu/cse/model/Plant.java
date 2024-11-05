package edu.miu.cse.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "plant")
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer plantId;
    private String name;
    private String type;
    private LocalDate plantDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "garden_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Garden garden;

    @Override
    public String toString() {
        return
                "ID:" + plantId +
                ", Name:'" + name + '\'' +
                ", Type:'" + type + '\'' +
                ", Plant Date:" + plantDate
//                ", Garden:" + garden.getName() +
               ;
    }
}
