package com.eviro.assessment.grad001.raisibeserakalala.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.eviro.assessment.grad001.raisibeserakalala.model.UserAccount;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface UserAccountRepository extends JpaRepository<UserAccount,Long> {

}
