package com.transform.helper

import net.masterthought.cucumber.ReportBuilder

import java.util.regex.Matcher
import java.util.regex.Pattern

/*
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 14/04/14
 * Time: 18:39
 * To change this template use File | Settings | File Templates.
 */

class ReportingClass {
    static String fileName

    public static void main(String[] args) {
        fileName= lastFileModified("target")
        String dateForFile = getDateFromFileName(fileName)
        new ReportBuilder(["target/transform-report${dateForFile}.json".toString()], new File("target/transform-html-report${dateForFile}".toString()),"","1","Transform",false,false,false,false,true,false,false,"",true,false).generateReports()
    }

    public static String lastFileModified(String dir) {
        File fl = new File(dir);
        File[] files = fl.listFiles(new FileFilter() {
            @Override
            boolean accept(File pathname) {
                return pathname.isFile();
            }
        });
        long lastMod = Long.MIN_VALUE;
        File choice = null;
        for (File file : files) {
            if (file.lastModified() > lastMod) {
                choice = file;
                lastMod = file.lastModified();
            }
        }
        return choice.name;
    }

    public static String getDateFromFileName(String fileName){
        Matcher matcher = fileName =~ /transform-report(.*).json/
        return matcher[0][1]
    }

}

