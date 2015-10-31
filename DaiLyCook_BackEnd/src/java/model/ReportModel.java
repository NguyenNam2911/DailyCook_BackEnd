/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.ReportDAO;
import entity.Report;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KhanhDN
 */
public class ReportModel {

    public List<Report> getListReports(){
        List<Report> listReport = new ArrayList<Report>();
        listReport = ReportDAO.getInstance().getAllReport();
        return listReport;
    }
    
    public boolean approveReportStatus(String id){
        return ReportDAO.getInstance().updateReportStatus(id);
    }
}
