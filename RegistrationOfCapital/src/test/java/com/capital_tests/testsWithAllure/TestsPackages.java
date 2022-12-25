package com.capital_tests.testsWithAllure;

import com.capital_tests.testsWithAllure.mainPage_tests.registrationButtons_tests.Tests_RegistrationButtons;
import com.capital_tests.testsWithAllure.mainPage_tests.registrationButtons_tests.specific_tests.Tests_TradingInstrumentsWidget;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        Tests_TradingInstrumentsWidget.class,
        Tests_RegistrationButtons.class})
public class TestsPackages {

}
