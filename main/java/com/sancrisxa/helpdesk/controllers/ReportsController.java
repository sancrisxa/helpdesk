package com.sancrisxa.helpdesk.controllers;

import com.sancrisxa.helpdesk.models.Ticket;
import com.sancrisxa.helpdesk.services.TicketService;
import com.sancrisxa.helpdesk.util.TicketReportPdf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.ByteArrayInputStream;
import java.util.List;

@Controller
@RequestMapping("/reports")
public class ReportsController {

    @Autowired
    private TicketService ticketService;

    public ReportsController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/tickets")
    public String ticketReport(@RequestParam(required = false, value = "day") Integer day,Model model) {
        model.addAttribute("list", this.ticketService.reportTicketByDays(day));
        return "reports/ticket";
    }

    @GetMapping("/tickets/pdfgen")
    public String ticketReportPdfForm(Model model) {
        return "reports/ticket_pdf";
    }

    @GetMapping(value = "/tickets/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> pdfTicketReport(@RequestParam(required = false, value = "day") Integer day, Model model) {
        List<Ticket> tickets = this.ticketService.reportTicketByDays(day);

        ByteArrayInputStream pdf = TicketReportPdf.generate(tickets);

        return ResponseEntity
                .ok()
                .header("Content-Disposition", "inline; filname=report.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(pdf));
    }

}
