package com.cpe.wongnai.repository;




import com.cpe.wongnai.entity.Story;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Storyrepository extends JpaRepository<Story,Long> {
	Story findByStext(String stext);   
}