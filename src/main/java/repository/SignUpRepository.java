package repository;

import entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignUpRepository extends JpaRepository<Profile, Long> {

}
