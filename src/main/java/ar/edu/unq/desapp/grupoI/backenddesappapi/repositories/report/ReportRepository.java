package ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.report;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.report.Report;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Configuration
@Repository
public interface ReportRepository extends JpaRepository<Report, String> {

    @Query(value = "SELECT * FROM report", nativeQuery = true)
    List<Report> findAll();

    @Query(value = "SELECT * FROM report r where r.id = :id", nativeQuery = true)
    Report findReportBy(@Param("id")Long id);

    @Query(value ="SELECT * FROM report r WHERE r.review_id = :review_id", nativeQuery = true)
    List<Report> findReportByReview_id(@Param("review_id")Long review_id);
}

