/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.vn.dailycookapp.utils.TimeUtils;
import entity.Recipe;
import entity.Report;
import entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.RecipeModel;
import model.ReportModel;
import model.UserModel;

/**
 *
 * @author KhanhDN
 */
@ManagedBean
@RequestScoped
public class ReportManagedBean {

    /**
     * Creates a new instance of ReportManagedBean
     */
    ReportModel reportModel = new ReportModel();
    RecipeModel recipeModel = new RecipeModel();
    UserModel userModel = new UserModel();
    List<Report> listReport = new ArrayList<Report>();
    String searchText;
    String filterText;
    int filter;
    
    public ReportManagedBean() {
        listReport = reportModel.getListReports();
    }

    public List<Report> getListReport() {
        return listReport;
    }

    public void setListReport(List<Report> listReport) {
        this.listReport = listReport;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public String getFilterText() {
        return filterText;
    }

    public void setFilterText(String filterText) {
        this.filterText = filterText;
    }
    
    public String getUserName(String id){
        User user = userModel.getUserByID(id);
        if (user != null)
            return user.getDisplayName();
        return "";
    }
    
    public String getRecipeName(String id){
        Recipe recipe = recipeModel.getRecipeByID(id);
        if (recipe != null)
            return recipe.getTitle();
        return "";
    }
    
    public String convertTime(long time){
        return TimeUtils.convertTime(time);
    }
    
    public void searchReport(){
       List<Report> reports = new ArrayList<Report>();
       if (filterText != null){
           try{
               filter = Integer.parseInt(filterText);
               if (filter != 1 && filter !=0)
                   filter=-1;
           }catch(Exception ex){
               filter=-1;
           }
       }
       if (searchText != null){
           for (Report report : listReport){
               if (getRecipeName(report.getId()).contains(searchText)){
                   if (filter==-1){
                       reports.add(report);
                   }else{
                       if (report.getStatus() == filter)
                           reports.add(report);
                   }
               }
           }
           listReport = reports;
       }
    }
    
    public void filter(){
        List<Report> reports = new ArrayList<Report>();
        if (filterText != null){
           try{
               filter = Integer.parseInt(filterText);
               if (filter != 1 && filter !=0)
                   filter=-1;
           }catch(Exception ex){
               filter=-1;
           }
       }else{
            filter=-1;
       }
       
        if (filter!=-1){
            for (Report report : listReport){
                if (report.getStatus() == filter)
                    reports.add(report);
           }
           listReport = reports;
        }
    }
    
    public void approveReportStatus(String id){
        reportModel.approveReportStatus(id);
    }
}
