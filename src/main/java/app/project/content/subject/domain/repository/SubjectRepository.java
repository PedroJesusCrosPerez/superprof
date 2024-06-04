package app.project.content.subject.domain.repository;

import app.project.content.subject.domain.entity.Subject;

import java.util.List;

public interface SubjectRepository {

    Long saveSubject(Subject subject);

    Subject findByIdSubject(Long idSubject);

    List<Subject> findAllSubjects();

    Subject updateSubject(Subject subject);

    Boolean deleteByIdSubject(Long idSubject);
}
