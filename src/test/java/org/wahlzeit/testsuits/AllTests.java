package org.wahlzeit.testsuits;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	org.wahlzeit.handlers.TellFriendTest.class,
	org.wahlzeit.services.LogBuilderTest.class,

	HandlersSuite.class,
	ModelSuite.class,
	ServicesSuite.class,
	UtilsSuit.class
})
public class AllTests {

}