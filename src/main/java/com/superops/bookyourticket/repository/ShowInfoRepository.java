package com.superops.bookyourticket.repository;

import com.superops.bookyourticket.model.ScreenInfo;
import com.superops.bookyourticket.model.ShowInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowInfoRepository extends JpaRepository<ShowInfo, Long> {

    List<ShowInfo> findByScreenInfo(final ScreenInfo screenInfo);
}
