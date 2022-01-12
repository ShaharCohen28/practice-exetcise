package exercise;

public class CompanyReportException extends Exception {
    private String companyName;
    private String reportName;

    public CompanyReportException(String msg,String companyName, String reportName) {
        super(msg);
        this.companyName = companyName;
        this.reportName = reportName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getReportName() {
        return reportName;
    }

}
