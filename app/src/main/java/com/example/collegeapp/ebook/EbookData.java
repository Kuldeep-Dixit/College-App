package com.example.collegeapp.ebook;

public class EbookData {
    private String PdfTitle;
    private String pdfUrl;

    public EbookData() {
    }

    public EbookData(String PdfTitle, String pdfUrl) {
        this.PdfTitle = PdfTitle;
        this.pdfUrl = pdfUrl;
    }

    public String getName() {
        return PdfTitle;
    }

    public void setName(String PdfTitle) {
        this.PdfTitle = PdfTitle;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }


}
