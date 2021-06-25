package ar.edu.unq.desapp.grupoi.backenddesappapi.service;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.report.Report;
import ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.report.ReportRepository;
import ar.edu.unq.desapp.grupoi.backenddesappapi.repositories.review.ReviewRepository;
import ar.edu.unq.desapp.grupoi.backenddesappapi.services.reportService.ReportService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class ReportServiceTest{

    @Mock
    private ReportRepository reportRepository;

    private List<Report> reports;
    private ReportService reportService;
    private Report report;


    @BeforeEach
    public void setUp(){
        reports = new ArrayList<>();
        MockitoAnnotations.initMocks(this);
        report = new Report(1L, 2L, "Lenguaje inapropiado");
        reportService = new ReportService(reportRepository);
        //reportService.addReport(report);
        reports.add(report);
    }

    @Test
    public void findAllTest(){
        Mockito.doReturn(reports).when(reportRepository).findAll();
        Assertions.assertEquals(1, reportService.findAll().size());
    }
    @Test
    public void findReportByTest(){
        Mockito.doReturn(reports.get(0)).when(reportRepository).findReportBy(1L);
        Report reportRes = reportService.findReportBy(1L);
        Assertions.assertEquals(1, reportRes.getId());
    }
    @Test
    public void findReportByReview_idTest(){
        Mockito.doReturn(reports).when(reportRepository).findReportByReview_id(2L);
        List<Report> reportListRes = reportService.findReportByReview_id(2L);
        Assertions.assertEquals(1, reportListRes.size());
    }


}

