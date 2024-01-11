package org.dnyanyog.repo;

import java.util.List;

import org.dnyanyog.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface UsersRepository extends JpaRepository<Users, Long> {
	List<Users> findByEmailAndPassword(String email, String password); // Declaration
	
	List<Users> findByUsername(String nameToSearch);
}
