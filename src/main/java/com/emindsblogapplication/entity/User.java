package com.emindsblogapplication.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users" , uniqueConstraints =
                         {@UniqueConstraint(columnNames = {"username"}),
                         @UniqueConstraint(columnNames = {"email"})
                         })
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;

    private String name;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
             joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),
              inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Roles> roles;


}
