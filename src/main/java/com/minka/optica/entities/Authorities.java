package com.minka.optica.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@Table(name = "authorities")
public class Authorities {

    @EmbeddedId
    private AuthorityId id;

    @ManyToOne
    @MapsId("username") // Vincula el campo username de la clave compuesta con la entidad Users
    @JoinColumn(name = "username", nullable = false)
    private Users users;

    // Clase embebida para la clave primaria compuesta
    @Embeddable
    @Data
    @NoArgsConstructor
    public static class AuthorityId implements Serializable {

        @Column(name = "username")
        private String username;

        @Column(name = "authority")
        private String authority;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            AuthorityId that = (AuthorityId) o;
            return Objects.equals(username, that.username) && Objects.equals(authority, that.authority);
        }

        @Override
        public int hashCode() {
            return Objects.hash(username, authority);
        }
    }
}

