package com.superops.bookyourticket.repository;

import com.superops.bookyourticket.model.BookedSeatInfo;
import com.superops.bookyourticket.model.ScreenSeatInfo;
import com.superops.bookyourticket.model.ShowInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookedSeatInfoRepository extends JpaRepository<BookedSeatInfo, Long> {

    List<BookedSeatInfo> findByShowInfoAndScreenSeatInfo(final ShowInfo showInfo, final ScreenSeatInfo screenSeatInfo);
}
