package org.wahlzeit.testsuits;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.services.*;
import org.wahlzeit.testsuits.EmailSuite;;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        EmailSuite.class,
        LogBuilderTest.class
})

public class ServicesSuite {

}
