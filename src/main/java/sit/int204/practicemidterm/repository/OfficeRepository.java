package sit.int204.practicemidterm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.practicemidterm.entity.Office;

public interface OfficeRepository extends JpaRepository<Office,String> {
    Office findOfficeById(String id);
}
