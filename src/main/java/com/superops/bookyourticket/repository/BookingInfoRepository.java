package com.superops.bookyourticket.repository;

import com.superops.bookyourticket.model.BookingInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingInfoRepository extends JpaRepository<BookingInfo, Long> {
}
