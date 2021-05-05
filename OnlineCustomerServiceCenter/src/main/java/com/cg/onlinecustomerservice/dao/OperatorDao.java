package com.cg.onlinecustomerservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cg.onlinecustomerservice.entity.Operator;
@Repository
public interface OperatorDao extends JpaRepository<Operator , Integer>{
	@Query(value = "from Operator operator where operator.operatorId=?1")
	public Operator findOperatorById(int code);
	@Query(value = "from Operator operator where operator.password=?1 and operator.email=?2")
	public Operator operatorLogin(String password,String email);
	@Query(value = "from Operator operator where operator.email=?1")
	public Operator checkoperator(String email);
}
