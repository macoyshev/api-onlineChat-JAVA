package com.macoyshev.restAPI.store.entities;


import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;


@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
@Entity
@Table(name="users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @Column(unique = true, nullable = false)
    String name;

    String password;
}
