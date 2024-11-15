package com.samuelFalla.cursos.model;

import com.samuelFalla.common.model.Alumno;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @Column(name="create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Alumno> listaAlumnos;

    @PrePersist
    public void prePersist() {
        this.createAt = new Date();
    }

    public void addAlumnos(Alumno alumno) {
        this.listaAlumnos.add(alumno);
    }

    public void removeAlumnos(Alumno alumno) {
        this.listaAlumnos.remove(alumno);
    }


}
