package com.cpe.wongnai.repository;





import java.util.List;

import com.cpe.wongnai.entity.InfoMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoMenurepository extends JpaRepository<InfoMenu, Long> {
    
}
