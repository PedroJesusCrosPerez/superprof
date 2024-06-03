package app.project.teacher.infrastructure.repository.jpa;

import app.project.teacher.infrastructure.repository.jpa.entity.TeacherJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepositoryJpa extends JpaRepository<TeacherJpa, Long> {}
