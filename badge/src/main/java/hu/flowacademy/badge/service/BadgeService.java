package hu.flowacademy.badge.service;

import hu.flowacademy.badge.domain.Badge;
import hu.flowacademy.badge.exception.BadgeNotFoundException;
import hu.flowacademy.badge.repository.BadgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BadgeService {

    @Autowired
    private BadgeRepository badgeRepository;

    public Badge save (Badge badge) {
        if(badgeRepository.findById(badge.getId()).isEmpty()) {
            return badgeRepository.save(badge);
        } else {
            throw new BadgeNotFoundException(badge.getId());
        }

    }

    public void delete (Long id) {
        try {
            badgeRepository.deleteBadgeById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new BadgeNotFoundException(id);
        }
    }

    public List<Badge> listUsers() {
        return badgeRepository.findAll();
    }

    public Badge getOneBadge(Long id) {
        if (badgeRepository.findById(id).isPresent()) {
            return badgeRepository.findById(id).get();
        }
        throw new BadgeNotFoundException(id);
    }
}
