package org.wahlzeit.testsuits;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.services.*;
import org.wahlzeit.services.mailing.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        EmailServiceTest.class,
        EmailAddressTest.class
})

public class EmailSuite {
}