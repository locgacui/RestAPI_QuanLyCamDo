package com.exampleAPI.APIdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.exampleAPI.APIdemo.model.*;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
	@Query(value = "EXEC dbo.List_Account"
			,nativeQuery = true)
	List<Account> List_Account();
}
