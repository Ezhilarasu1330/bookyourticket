package com.superops.bookyourticket.repository;

import com.superops.bookyourticket.model.ShowInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowInfoRepository extends JpaRepository<ShowInfo, Long> {
}
