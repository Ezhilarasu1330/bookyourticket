package com.superops.bookyourticket.repository;

import com.superops.bookyourticket.model.TheatreInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheatreInfoRepository extends JpaRepository<TheatreInfo, Long> {
}
