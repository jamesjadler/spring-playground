package com.example.Models.Database;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JPACustomRepository extends CrudRepository<Lesson, Long> {

   List<Lesson> findByTitle(String title);

   List<Lesson> findByYearBetween(Long year1,Long year2);

   @Query("Select id,title,year from Lesson where year>= ?1 AND year<=?2")
   List<Lesson> findMovieYearBetween(Long year1,Long year2);

}
