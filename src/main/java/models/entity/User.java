package models.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Size(max = 50, message = "email должен быть короче 50 символов")
    @Column(name = "email", length = 50, nullable = false, unique = true)
    private String email;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    //@Pattern(regexp = ValidationPattern.PASSWORD_PATTERN, message = "Пароль не должен содержать пробельных символов")
    @Size(min = 6, max = 60, message = "Пароль должен быть больше 6 символов и меньше 30")
    @Column(name = "password", length = 60, nullable = false)
    private String password;

    @Column(name = "birthday")
    @Type(type = "org.hibernate.type.LocalDateType")
    private LocalDate birthday;

    @Column(name = "enabled", nullable = false, columnDefinition = "TINYINT")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean enabled = true;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Role role;
}