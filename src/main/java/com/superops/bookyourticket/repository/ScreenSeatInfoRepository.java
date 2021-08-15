package com.superops.bookyourticket.repository;

import com.superops.bookyourticket.model.ScreenInfo;
import com.superops.bookyourticket.model.ScreenSeatInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScreenSeatInfoRepository extends JpaRepository<ScreenSeatInfo, Long> {

    List<ScreenSeatInfo> findByScreenInfo(final ScreenInfo screenInfo);
}
