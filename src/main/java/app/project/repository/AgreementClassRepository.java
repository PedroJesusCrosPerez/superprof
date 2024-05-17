package app.project.repository;

import app.project.entity.AgreementClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgreementClassRepository extends JpaRepository<AgreementClass, Long> {
}
