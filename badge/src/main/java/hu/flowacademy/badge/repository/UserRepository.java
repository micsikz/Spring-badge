package hu.flowacademy.badge.repository;

import hu.flowacademy.badge.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, String> {

    public void deleteUserByUserName(String username);

    //public List<User> findByUserNameIn (String username);
}
