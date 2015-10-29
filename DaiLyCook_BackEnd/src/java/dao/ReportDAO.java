/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Report;
import java.util.List;
import org.mongodb.morphia.query.Query;

/**
 *
 * @author KhanhDN
 */
public class ReportDAO extends AbstractDAO{
    private static final ReportDAO instance = new ReportDAO();
    
    private ReportDAO(){
        datastore.ensureIndexes();
    }
    
    public static final ReportDAO getInstance() {
        return instance;
    }
    
    public List<Report> getAllReport(){
        try{
            Query<Report> query = datastore.createQuery(Report.class);
            return query.asList();
        }catch (Exception ex){
        }
        return null;
    }
}
