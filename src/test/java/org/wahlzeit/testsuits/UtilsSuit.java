package org.wahlzeit.testsuits;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.wahlzeit.utils.*;

@RunWith(Suite.class)
@SuiteClasses({
	StringUtilTest.class,
	VersionTest.class
})
public class UtilsSuit {

}