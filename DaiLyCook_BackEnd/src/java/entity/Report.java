/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

/**
 *
 * @author Nguyen Hoai Nam
 */
public class Report {

    public static final int ACTIVE_FLAG = 1;
    public static final int BAN_FLAG = 0;

    @Id
    private String id;
    @Property("reporter")
    private String reporter;

    @Property("recipe")
    private String recipe;

    @Property("resion")
    private String resion;

    @Property("status")
    private int status = ACTIVE_FLAG;

    @Property("verify_by")
    private String veryfyBy;

    @Property("verify_time")
    private long verifyTime;

    @Property("reported_time")
    private long reportTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public String getResion() {
        return resion;
    }

    public void setResion(String resion) {
        this.resion = resion;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getVeryfyBy() {
        return veryfyBy;
    }

    public void setVeryfyBy(String veryfyBy) {
        this.veryfyBy = veryfyBy;
    }

    public long getVerifyTime() {
        return verifyTime;
    }

    public void setVerifyTime(long verifyTime) {
        this.verifyTime = verifyTime;
    }

    public long getReportTime() {
        return reportTime;
    }

    public void setReportTime(long reportTime) {
        this.reportTime = reportTime;
    }
    
    
    
}
