package com.eviro.assessment.grad001.raisibeserakalala.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.eviro.assessment.grad001.raisibeserakalala.model.UserAccount;

import java.util.List;

public interface UserAccountRepository extends JpaRepository<UserAccount,Long> {
    List<UserAccount> gethttpImageLink(String imagelink);

}
