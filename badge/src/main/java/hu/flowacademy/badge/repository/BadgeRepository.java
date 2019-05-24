package hu.flowacademy.badge.repository;

import hu.flowacademy.badge.domain.Badge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface BadgeRepository extends JpaRepository<Badge, Long> {

    public void deleteBadgeById (Long id);
}
