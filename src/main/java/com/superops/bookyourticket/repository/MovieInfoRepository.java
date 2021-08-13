package com.superops.bookyourticket.repository;

import com.superops.bookyourticket.model.MovieInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieInfoRepository extends JpaRepository<MovieInfo, Long> {
}
