package DesafioAPIRest.ApiRest.modules.repository;

import DesafioAPIRest.ApiRest.modules.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
