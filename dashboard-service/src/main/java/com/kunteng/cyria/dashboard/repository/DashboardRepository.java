package com.kunteng.cyria.dashboard.repository;

import com.kunteng.cyria.dashboard.domain.Dashboard;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface DashboardRepository extends MongoRepository<Dashboard, String> {
	@Query(value= "{'user':?0}",fields="{'config.title':1, 'user':1, 'hash':1, 'publish.status':1}")
	List<Dashboard> findByUser(String user, Pageable pageable);
	
	@Query(value= "{'publish.status':?1}",fields="{'config.title':1, 'user':1, 'hash':1, 'publish.status':1}")
	List<Dashboard> findByUserAndStatus(String user, String status,Pageable pageable);
	
	@Query(value= "{'config.title':?1}",fields="{'config.title':1, 'user':1, 'hash':1, 'publish.status':1}")
	List<Dashboard> findByUserAndTitle(String user, String title,Pageable pageable);
	
	@Query(value= "{'config.title':?1, 'publish.status':?2}",fields="{'config.title':1, 'user':1,'hash':1, 'publish.status':1}")
	List<Dashboard> findByUserAndTitleAndStatus(String user, String title, String status,Pageable pageable);
	String deleteByHash(String hash);
	Dashboard findByHash(String id);
}
