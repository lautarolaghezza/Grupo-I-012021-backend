package ar.edu.unq.desapp.grupoi.backenddesappapi.services.reportService;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.report.Report;
import ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.report.ReportRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
@NoArgsConstructor
public class ReportService {

    @Autowired
    private ReportRepository reportRepostory;

    public ReportService(ReportRepository reportRepostory) {
        this.reportRepostory = reportRepostory;
    }

    public List<Report> findAll(){ return reportRepostory.findAll();}
    public Report findReportBy(Long id){return  reportRepostory.findReportBy(id);}
    public  List<Report> findReportByReview_id(Long review_id){ return reportRepostory.findReportByReview_id(review_id);}
    public Report addReport(Report report){ return reportRepostory.save(report);}
}
