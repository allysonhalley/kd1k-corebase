package com.kd1k.corebase.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "militaries")
@Entity(name = "militaries")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Military {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(foreignKey = @ForeignKey(name = "person_id"))
    private Person person;

    @Column(unique = true, nullable = false)
    private String register;

    private String nickname;

    private String hierarchy;

    public Military(Person person, String register, String nickname, String hierarchy) {
        this.person = person;
        this.register = register;
        this.nickname = nickname;
        this.hierarchy = hierarchy;
    }

}
