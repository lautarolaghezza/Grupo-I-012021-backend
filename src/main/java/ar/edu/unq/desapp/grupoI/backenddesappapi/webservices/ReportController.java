package ar.edu.unq.desapp.grupoi.backenddesappapi.webservices;

import ar.edu.unq.desapp.grupoi.backenddesappapi.Utils.BaseController;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.report.Report;
import ar.edu.unq.desapp.grupoi.backenddesappapi.services.reportService.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class ReportController extends BaseController {

    @Autowired
    private ReportService reportService;

    @PostMapping(value = "report/review")
    public Report reportReview(@RequestHeader("api-key") String apiKey, @RequestBody Report report) {
        validateApiKey(apiKey);
        return reportService.addReport(report);
    }
}
