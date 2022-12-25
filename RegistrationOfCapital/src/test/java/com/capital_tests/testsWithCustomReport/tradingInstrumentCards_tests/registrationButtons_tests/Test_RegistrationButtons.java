package com.capital_tests.testsWithCustomReport.tradingInstrumentCards_tests.registrationButtons_tests;

import com.capital_tests.Locators;
import com.capital_tests.testsWithCustomReport.MethodsWithCustomReport;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Test_RegistrationButtons extends MethodsWithCustomReport {
  private String reportFile = "";


  @Test
  public void checkingRegistrationBtnInSectionForex() {
    ArrayList<String> urlList = new ArrayList<>();
    transferDataFromFileToList(urlList,Locators.addressOfUrlFileFromSectionForex);
    goToPageAndCheckUrl(urlList.get(0));
    cookiesAcceptConsent();
    PrintWriter writer = null;
    try {
      writer = new PrintWriter(Locators.addressOfReportFileSectionForex);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
    for(String urlPage : urlList) {
      goToPageAndCheckUrl(urlPage);
      checkLicense(Locators.licenseNameFCA, Locators.licenseBtnFCA);
      reportFile = reportFile + checkingAllRegistrationBtnOnPage() + "\n";
    }
    writer.write(reportFile);
    writer.flush();
    writer.close();
    System.out.println(reportFile);
  }


  @Test
  public void checkingRegistrationBtnInSectionIndices() {
    ArrayList<String> urlList = new ArrayList<>();
    transferDataFromFileToList(urlList,Locators.addressOfUrlFileFromSectionIndices);
    goToPageAndCheckUrl(urlList.get(0));
    cookiesAcceptConsent();
    PrintWriter writer = null;
    try {
      writer = new PrintWriter(Locators.addressOfReportFileSectionIndices);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
    for(String urlPage : urlList) {
      goToPageAndCheckUrl(urlPage);
      checkLicense(Locators.licenseNameCYSEC, Locators.licenseBtnCYSEC);
      reportFile = reportFile + checkingAllRegistrationBtnOnPage() + "\n";
    }
    writer.write(reportFile);
    writer.flush();
    writer.close();
    System.out.println(reportFile);
  }


  @Test
  public void checkingRegistrationBtnInSectionCommodities() {
    ArrayList<String> urlList = new ArrayList<>();
    transferDataFromFileToList(urlList,Locators.addressOfUrlFileFromSectionCommodities);
    goToPageAndCheckUrl(urlList.get(0));
    cookiesAcceptConsent();
    PrintWriter writer = null;
    try {
      writer = new PrintWriter(Locators.addressOfReportFileSectionCommodities);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
    for(String urlPage : urlList) {
      goToPageAndCheckUrl(urlPage);
      checkLicense(Locators.licenseNameCYSEC, Locators.licenseBtnCYSEC);
      reportFile = reportFile + checkingAllRegistrationBtnOnPage() + "\n";
    }
    writer.write(reportFile);
    writer.flush();
    writer.close();
    System.out.println(reportFile);
  }


  @Test
  public void checkingRegistrationBtnInSectionCryptocurrencies() {
    ArrayList<String> urlList = new ArrayList<>();
    transferDataFromFileToList(urlList,Locators.addressOfUrlFileFromSectionCryptocurrencies);
    goToPageAndCheckUrl(urlList.get(0));
    cookiesAcceptConsent();
    PrintWriter writer = null;
    try {
      writer = new PrintWriter(Locators.addressOfReportFileSectionCryptocurrencies);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
    for(String urlPage : urlList) {
      goToPageAndCheckUrl(urlPage);
      checkLicense(Locators.licenseNameCYSEC, Locators.licenseBtnCYSEC);
      reportFile = reportFile + checkingAllRegistrationBtnOnPage() + "\n";
    }
    writer.write(reportFile);
    writer.flush();
    writer.close();
    System.out.println(reportFile);
  }


  @Test
  public void checkingRegistrationBtnInSectionShares() {
    ArrayList<String> urlList = new ArrayList<>();
    transferDataFromFileToList(urlList,Locators.addressOfUrlFileFromSectionShares);
    goToPageAndCheckUrl(urlList.get(0));
    cookiesAcceptConsent();
    PrintWriter writer = null;
    try {
      writer = new PrintWriter(Locators.addressOfReportFileSectionShares);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
    for(String urlPage : urlList) {
      goToPageAndCheckUrl(urlPage);
      checkLicense(Locators.licenseNameCYSEC, Locators.licenseBtnCYSEC);
      reportFile = reportFile + checkingAllRegistrationBtnOnPage() + "\n";
    }
    writer.write(reportFile);
    writer.flush();
    writer.close();
    System.out.println(reportFile);
  }
}