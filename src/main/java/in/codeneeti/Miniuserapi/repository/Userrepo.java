package in.codeneeti.Miniuserapi.repository;

import in.codeneeti.Miniuserapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Userrepo extends JpaRepository<User,Integer> {

}