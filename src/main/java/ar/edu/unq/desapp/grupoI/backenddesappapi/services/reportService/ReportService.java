package ar.edu.unq.desapp.grupoi.backenddesappapi.services.reportService;

import ar.edu.unq.desapp.grupoi.backenddesappapi.exceptions.NoSuchReview;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.report.Report;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.Review;
import ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.report.ReportRepository;
import ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.review.ReviewRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Getter
@NoArgsConstructor
public class ReportService {

    @Autowired
    private ReportRepository reportRepostory;

    @Autowired
    ReviewRepository reviewRepository;

    public ReportService(ReportRepository reportRepostory) {
        this.reportRepostory = reportRepostory;
    }

    public List<Report> findAll(){ return reportRepostory.findAll();}
    public Report findReportBy(Long id){return  reportRepostory.findReportBy(id);}
    public  List<Report> findReportByReview_id(Long review_id){ return reportRepostory.findReportByReview_id(review_id);}
    public Report addReport(Report report){
        Optional<Review> review  = reviewRepository.findById(report.getReview_id());
        review.orElseThrow(() -> new NoSuchReview(HttpStatus.BAD_REQUEST));
        return reportRepostory.save(report);
    }
}
