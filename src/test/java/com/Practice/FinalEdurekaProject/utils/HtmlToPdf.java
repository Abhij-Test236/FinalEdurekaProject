package com.Practice.FinalEdurekaProject.utils;

import java.io.File;
import java.io.IOException;
import com.itextpdf.html2pdf.HtmlConverter;

public class HtmlToPdf {
	
	public void convertToPDF() throws IOException {
		String src = "./ExtentReport.html";
		String dest = "./ExtentReport.pdf";
		HtmlConverter.convertToPdf(new File(src), new File(dest));

	}
}
