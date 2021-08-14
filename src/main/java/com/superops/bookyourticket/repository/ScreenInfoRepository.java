package com.superops.bookyourticket.repository;

import com.superops.bookyourticket.model.ScreenInfo;
import com.superops.bookyourticket.model.TheatreInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScreenInfoRepository extends JpaRepository<ScreenInfo, Long> {

    List<ScreenInfo> findByTheatreInfo(final TheatreInfo theatreInfo);
}
