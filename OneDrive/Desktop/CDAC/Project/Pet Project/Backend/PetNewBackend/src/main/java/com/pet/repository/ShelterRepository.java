package com.pet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pet.entities.Shelter;

public interface ShelterRepository extends JpaRepository<Shelter, Integer>{
	@Query("SELECT s FROM Shelter s WHERE s.user.id = :userId")
	Shelter findByUserId(@Param("userId") Integer userId);

}
